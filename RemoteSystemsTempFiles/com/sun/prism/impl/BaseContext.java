/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.sun.prism.impl;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.sun.glass.ui.Screen;
import com.sun.javafx.font.FontResource;
import com.sun.javafx.font.FontStrike;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.sg.prism.NGCamera;
import com.sun.prism.PixelFormat;
import com.sun.prism.RTTexture;
import com.sun.prism.RenderTarget;
import com.sun.prism.ResourceFactory;
import com.sun.prism.Texture;
import com.sun.prism.Texture.WrapMode;
import com.sun.prism.impl.paint.PaintUtil;
import com.sun.prism.impl.shape.MaskData;
import com.sun.prism.paint.Gradient;

public abstract class BaseContext {

    private final Screen screen;
    private final ResourceFactory factory;
    private final VertexBuffer vertexBuffer;

    private Texture maskTex;
    private Texture paintTex;
    private int[] paintPixels;
    private ByteBuffer paintBuffer;

    private Texture rectTex;
    private int rectTexMax;
    private Texture wrapRectTex;
    private Texture ovalTex;

    // TODO: need to dispose these when the context is disposed... (RT-27421)
    private final Map<FontStrike, GlyphCache>
        greyGlyphCaches = new HashMap<FontStrike, GlyphCache>();
    private final Map<FontStrike, GlyphCache>
        lcdGlyphCaches = new HashMap<FontStrike, GlyphCache>();

    protected BaseContext(Screen screen, ResourceFactory factory, VertexBuffer vb) {
        this.screen = screen;
        this.factory = factory;
        this.vertexBuffer = vb;
    }

    protected void setDeviceParametersFor2D() {}
    protected void setDeviceParametersFor3D() {}

    public Screen getAssociatedScreen() {
        return screen;
    }

    public ResourceFactory getResourceFactory() {
        return factory;
    }

    public VertexBuffer getVertexBuffer() {
        return vertexBuffer;
    }

    public void flushVertexBuffer() {
        vertexBuffer.flush();
    }

    /**
     *
     * This method will call releaseRenderTarget method to reset last
     * renderTarget and textures if g is null
     */
    public void setRenderTarget(BaseGraphics g) {
        if (g != null) {
            setRenderTarget(g.getRenderTarget(), g.getCameraNoClone(),
                    g.isDepthTest() && g.isDepthBuffer(), g.isState3D());
        } else {
            releaseRenderTarget();
        }
    }

    protected void releaseRenderTarget() {
        // Default implementation is a no-op. A pipeline may override if needed.
    }

    protected abstract void setRenderTarget(RenderTarget target, NGCamera camera,
                                            boolean depthTest, boolean state3D);

    public void validateClearOp(BaseGraphics g) {
        validatePaintOp(g, BaseTransform.IDENTITY_TRANSFORM, null, 0, 0, 0, 0);
    }

    public abstract void validatePaintOp(BaseGraphics g, BaseTransform xform,
                                         Texture maskTex,
                                         float bx, float by, float bw, float bh);

    public abstract void validateTextureOp(BaseGraphics g, BaseTransform xform,
                                           Texture src, PixelFormat format);

    public void clearGlyphCaches() {
        clearCaches(greyGlyphCaches);
        clearCaches(lcdGlyphCaches);
    }

    private void clearCaches(Map<FontStrike, GlyphCache> glyphCaches) {
        for (Iterator<FontStrike> iter = glyphCaches.keySet().iterator(); iter.hasNext();) {
            iter.next().clearDesc();
        }

        for (GlyphCache cache : glyphCaches.values()) {
            if (cache != null) {
                cache.clear();
            }
        }
        glyphCaches.clear();
    }

    abstract public RTTexture getLCDBuffer();

    public GlyphCache getGlyphCache(FontStrike strike) {
        Map<FontStrike, GlyphCache> glyphCaches =
            (strike.getAAMode() ==FontResource.AA_LCD)
            ? lcdGlyphCaches : greyGlyphCaches;
        return getGlyphCache(strike, glyphCaches);
    }

    public boolean isSuperShaderEnabled() {
        return false;
    }

    private GlyphCache getGlyphCache(FontStrike strike,
                                     Map<FontStrike, GlyphCache> glyphCaches) {
        GlyphCache glyphCache = glyphCaches.get(strike);
        if (glyphCache == null) {
            glyphCache = new GlyphCache(this, strike);
            glyphCaches.put(strike, glyphCache);
        }
        return glyphCache;
    }

    public Texture getMaskTexture(MaskData maskData, boolean canScale) {
        int maskW = maskData.getWidth();
        int maskH = maskData.getHeight();
        if (maskTex != null) {
            maskTex.lock();
            if (maskTex.isSurfaceLost()) {
                maskTex = null;
            }
        }
        if (maskTex == null ||
            maskTex.getContentWidth()  < maskW ||
            maskTex.getContentHeight() < maskH)
        {
            int newTexW = maskW;
            int newTexH = maskH;
            if (maskTex != null) {
                // grow the mask texture so that the new one is always
                // at least as large as the previous one; this avoids
                // lots of creation/disposal when the shapes alternate
                // between narrow/tall and wide/short
                newTexW = Math.max(maskW, maskTex.getContentWidth());
                newTexH = Math.max(maskH, maskTex.getContentHeight());
                maskTex.dispose();
            }
            maskTex = getResourceFactory().
                createMaskTexture(newTexW, newTexH,
                                  canScale
                                      ? WrapMode.CLAMP_TO_ZERO
                                      : WrapMode.CLAMP_NOT_NEEDED);
        }

        maskData.uploadToTexture(maskTex, 0, 0, false);

        return maskTex;
    }

    public int getRectTextureMaxSize() {
        if (rectTex == null) {
            createRectTexture();
        }
        return rectTexMax;
    }

    public Texture getRectTexture() {
        if (rectTex == null) {
            createRectTexture();
        }

        // rectTex is left permanent and locked so it never
        // goes away or needs to be checked for isSurfaceLost(), but we
        // add a lock here so that the caller can unlock without knowing
        // our inner implementation details
        rectTex.lock();
        return rectTex;
    }

    private void createRectTexture() {
        int texMax = PrismSettings.primTextureSize;
        if (texMax < 0) texMax = getResourceFactory().getMaximumTextureSize();
        int texDim = 3;
        int nextCellSize = 2;
        while (texDim + nextCellSize + 1 <= texMax) {
            rectTexMax = nextCellSize;
            texDim += ++nextCellSize;
        }
        byte mask[] = new byte[texDim * texDim];
        int cellY = 1;
        for (int cellH = 1; cellH <= rectTexMax; cellH++) {
            int cellX = 1;
            for (int cellW = 1; cellW <= rectTexMax; cellW++) {
                int index = cellY * texDim + cellX;
                for (int y = 0; y < cellH; y++) {
                    for (int x = 0; x < cellW; x++) {
                        mask[index + x] = (byte) 0xff;
                    }
                    index += texDim;
                }
                cellX += cellW + 1;
            }
            cellY += cellH + 1;
        }
        if (PrismSettings.verbose) {
            System.out.println("max rectangle texture cell size = "+rectTexMax);
        }
        Texture tex =
            getResourceFactory().createMaskTexture(texDim, texDim,
                                                   WrapMode.CLAMP_NOT_NEEDED);
        // rectTex remains permanently locked, useful, and permanent
        // an additional lock is added when a caller calls getWrapGreientTeture for
        // them to unlock
        tex.contentsUseful();
        tex.makePermanent();
        PixelFormat pf = tex.getPixelFormat();
        int scan = texDim * pf.getBytesPerPixelUnit();
        tex.update(ByteBuffer.wrap(mask), pf,
                   0, 0, 0, 0, texDim, texDim,
                   scan, false);
        rectTex = tex;
    }

    public Texture getWrapRectTexture() {
        if (wrapRectTex == null) {
            Texture tex =
                getResourceFactory().createMaskTexture(2, 2, WrapMode.CLAMP_TO_EDGE);
            // wrapRectTex remains permanently locked, useful, and permanent
            // an additional lock is added when a caller calls getWrapGreientTeture for
            // them to unlock
            tex.contentsUseful();
            tex.makePermanent();
            int w = tex.getPhysicalWidth();
            int h = tex.getPhysicalHeight();
            if (PrismSettings.verbose) {
                System.out.println("wrap rectangle texture = "+w+" x "+h);
            }
            // assert w == 2 && h == 2?
            byte mask[] = new byte[w * h];
            int off = w;
            for (int y = 1; y < h; y++) {
                for (int x = 1; x < h; x++) {
                    mask[off + x] = (byte) 0xff;
                }
                off += w;
            }
            PixelFormat pf = tex.getPixelFormat();
            int scan = w * pf.getBytesPerPixelUnit();
            tex.update(ByteBuffer.wrap(mask), pf,
                       0, 0, 0, 0, w, h,
                       scan, false);
            wrapRectTex = tex;
        }

        // wrapRectTex is left permanent and locked so it never
        // goes away or needs to be checked for isSurfaceLost(), but we
        // add a lock here so that the caller can unlock without knowing
        // our inner implementation details
        wrapRectTex.lock();
        return wrapRectTex;
    }

    public Texture getOvalTexture() {
        if (ovalTex == null) {
            int cellMax = getRectTextureMaxSize();
            int texDim = (cellMax * (cellMax + 1)) / 2;
            // size now points at the start of the max-sized cell
            texDim += cellMax + 1;
            // size now points just past the empty row on the far side of the
            // max-sized cell - which is the dimension we want the texture...
            byte mask[] = new byte[texDim * texDim];
            int cellY = 1;
            for (int cellH = 1; cellH <= cellMax; cellH++) {
                int cellX = 1;
                for (int cellW = 1; cellW <= cellMax; cellW++) {
                    int index = cellY * texDim + cellX;
//                    System.out.println("rasterizing "+cell_w+" x "+cell_h);
                    for (int y = 0; y < cellH; y++) {
                        if (y * 2 >= cellH) {
                            int reflecty = cellH - 1 - y;
                            // handle bottom half of ellipse via reflection
                            int rindex = index + (reflecty - y) * texDim;
                            for (int x = 0; x < cellW; x++) {
                                mask[index + x] = mask[rindex + x];
                            }
                        } else {
                            // Use 8 sub-row samples
                            float ovalY = y + 0.0625f;  // 1/16
                            for (int i = 0; i < 8; i++) {
                                float ovalX = (ovalY / cellH) - 0.5f;
                                ovalX = (float) Math.sqrt(0.25f - ovalX * ovalX);
                                int oxi = Math.round(cellW * 4.0f * (1.0f - ovalX * 2.0f));
                                int edgeX = oxi >> 3;
                                int subX = oxi & 0x7;
//                                System.out.println("y = "+oy+", mask["+rx+"] += "+(8-subx)+", mask["+(rx+1)+"] += "+subx);
                                mask[index + edgeX] += 8 - subX;
                                mask[index + edgeX + 1] += subX;
                                ovalY += 0.125f;  // 1/8
                            }
                            int accum = 0;
                            for (int x = 0; x < cellW; x++) {
                                if (x * 2 >= cellW) {
                                    // handle right half of ellipse via reflection
                                    mask[index + x] = mask[index + cellW - 1 - x];
                                } else {
                                    accum += mask[index + x];
//                                    System.out.println("accum["+rx+"] = "+accum);
                                    mask[index + x] = (byte) ((accum * 255 + 32) / 64);
                                }
                            }
                            // Sometimes for smaller ovals we leave some
                            // accumulation dirt just past the last cell
                            mask[index + cellW] = 0;
                        }
                        index += texDim;
                    }
                    cellX += cellW + 1;
                }
                cellY += cellH + 1;
            }
            if (false) {
                int index = 0;
                for (int y = 0; y < texDim; y++) {
                    for (int x = 0; x < texDim; x++) {
                        String s = Integer.toHexString((mask[index++] & 0xff) | 0x100);
                        System.out.print(s.substring(1)+" ");
                    }
                    System.out.println();
                }
            }
            Texture tex =
                getResourceFactory().createMaskTexture(texDim, texDim,
                                                       WrapMode.CLAMP_NOT_NEEDED);
            tex.contentsUseful();
            tex.makePermanent();
            PixelFormat pf = tex.getPixelFormat();
            int scan = texDim * pf.getBytesPerPixelUnit();
            tex.update(ByteBuffer.wrap(mask), pf,
                       0, 0, 0, 0, texDim, texDim,
                       scan, false);
            ovalTex = tex;
        }

        // ovalTex is left permanent and locked so it never
        // goes away or needs to be checked for isSurfaceLost(), but we
        // add a lock here so that the caller can unlock without knowing
        // our inner implementation details
        ovalTex.lock();
        return ovalTex;
    }

    public Texture getGradientTexture(Gradient grad, BaseTransform xform,
                                      int paintW, int paintH,
                                      MaskData maskData,
                                      float bx, float by, float bw, float bh)
    {
        int sizeInPixels = paintW * paintH;
        int sizeInBytes = sizeInPixels * 4;
        if (paintBuffer == null || paintBuffer.capacity() < sizeInBytes) {
            paintPixels = new int[sizeInPixels];
            paintBuffer = ByteBuffer.wrap(new byte[sizeInBytes]);
        }

        if (paintTex != null) {
            paintTex.lock();
            if (paintTex.isSurfaceLost()) {
                paintTex = null;
            }
        }

        if (paintTex == null ||
            paintTex.getContentWidth()  < paintW ||
            paintTex.getContentHeight() < paintH)
        {
            int newTexW = paintW;
            int newTexH = paintH;
            if (paintTex != null) {
                // grow the paint texture so that the new one is always
                // at least as large as the previous one; this avoids
                // lots of creation/disposal when the shapes alternate
                // between narrow/tall and wide/short
                newTexW = Math.max(paintW, paintTex.getContentWidth());
                newTexH = Math.max(paintH, paintTex.getContentHeight());
                paintTex.dispose();
            }
            paintTex = getResourceFactory().
                createTexture(PixelFormat.BYTE_BGRA_PRE,
                              Texture.Usage.DEFAULT,
                              Texture.WrapMode.CLAMP_NOT_NEEDED,
                              newTexW, newTexH);
        }

        // note that the gradient will be tightly packed into paintImg
        // (i.e., no space at the end of each logical row) since there
        // is no way to control scanline stride for texture uploads in ES1
        PaintUtil.fillImageWithGradient(paintPixels, grad, xform,
                                        0, 0, paintW, paintH,
                                        bx, by, bw, bh);

        // RT-27421
        // TODO: could save some work here if we converted the *GradientContext
        // classes to produce ByteRgbaPre data instead of IntArgbPre data...
        byte[] bytePixels = paintBuffer.array();
        if (maskData != null) {
            // modulate with the mask pixels while we convert from
            // IntArgbPre to ByteRgbaPre
            byte[] maskPixels = maskData.getMaskBuffer().array();
            int j = 0;
            for (int i = 0; i < sizeInPixels; i++) {
                int pixel = paintPixels[i];
                int maskA = maskPixels[i] & 0xff;
                bytePixels[j++] = (byte)((((pixel       ) & 0xff) * maskA) / 255);
                bytePixels[j++] = (byte)((((pixel >>   8) & 0xff) * maskA) / 255);
                bytePixels[j++] = (byte)((((pixel >>  16) & 0xff) * maskA) / 255);
                bytePixels[j++] = (byte)((((pixel >>> 24)       ) * maskA) / 255);
            }
        } else {
            // just convert from IntArgbPre to ByteRgbaPre
            int j = 0;
            for (int i = 0; i < sizeInPixels; i++) {
                int pixel = paintPixels[i];
                bytePixels[j++] = (byte)((pixel       ) & 0xff);
                bytePixels[j++] = (byte)((pixel >>   8) & 0xff);
                bytePixels[j++] = (byte)((pixel >>  16) & 0xff);
                bytePixels[j++] = (byte)((pixel >>> 24)       );
            }
        }

        paintTex.update(paintBuffer, PixelFormat.BYTE_BGRA_PRE,
                        0, 0, 0, 0, paintW, paintH, paintW*4, false);

        return paintTex;
    }
}