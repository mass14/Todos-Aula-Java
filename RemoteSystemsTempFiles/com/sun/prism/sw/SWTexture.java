/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.sw;

import com.sun.prism.Image;
import com.sun.prism.PixelFormat;
import com.sun.prism.Texture;
import com.sun.prism.impl.PrismSettings;

abstract class SWTexture implements Texture {

    static Texture create(SWResourceFactory factory, PixelFormat formatHint, WrapMode wrapMode, int w, int h) {
        switch (formatHint) {
            case BYTE_ALPHA:
                return new SWMaskTexture(factory, wrapMode, w, h);
            default:
                return new SWArgbPreTexture(factory, wrapMode, w, h);
        }
    }

    boolean allocated = false;
    int physicalWidth, physicalHeight, contentWidth, contentHeight;
    private SWResourceFactory factory;
    private int lastImageSerial;
    private final WrapMode wrapMode;

    SWTexture(SWResourceFactory factory, WrapMode wrapMode, int w, int h) {
        this.factory = factory;
        this.wrapMode = wrapMode;
        physicalWidth = w;
        physicalHeight = h;
        contentWidth = w;
        contentHeight = h;
        lock();
    }

    SWTexture(SWTexture sharedTex, WrapMode altMode) {
        this.allocated = sharedTex.allocated;
        this.physicalWidth = sharedTex.physicalWidth;
        this.physicalHeight = sharedTex.physicalHeight;
        this.contentWidth = sharedTex.contentWidth;
        this.contentHeight = sharedTex.contentHeight;
        this.factory = sharedTex.factory;
        // REMIND: Use indirection to share the serial number?
        this.lastImageSerial = sharedTex.lastImageSerial;
        this.wrapMode = altMode;
        lock();
    }

    SWResourceFactory getResourceFactory() {
        return this.factory;
    }

    int getOffset() {
        return 0;
    }

    private int lockcount;
    public void lock() {
        lockcount++;
    }

    public void unlock() {
        assertLocked();
        lockcount--;
    }

    public boolean isLocked() {
        return (lockcount > 0);
    }

    public int getLockCount() {
        return lockcount;
    }

    public void assertLocked() {
        if (lockcount <= 0) {
            throw new IllegalStateException("texture not locked");
        }
    }

    boolean permanent;
    public void makePermanent() {
        permanent = true;
    }

    int employcount;
    public void contentsUseful() {
        assertLocked();
        employcount++;
    }

    public void contentsNotUseful() {
        if (employcount <= 0) {
            throw new IllegalStateException("Resource obsoleted too many times");
        }
        employcount--;
    }

    public boolean isSurfaceLost() {
        return false;
    }

    @Override
    public void dispose() { }

    @Override
    public int getPhysicalWidth() {
        return physicalWidth;
    }

    @Override
    public int getPhysicalHeight() {
        return physicalHeight;
    }

    @Override
    public int getContentX() {
        return 0;
    }

    @Override
    public int getContentY() {
        return 0;
    }

    @Override
    public int getContentWidth() {
        return contentWidth;
    }

    @Override
    public void setContentWidth(int contentWidth) {
        if (contentWidth > physicalWidth) {
            throw new IllegalArgumentException("contentWidth cannot exceed physicalWidth");
        }
        this.contentWidth = contentWidth;
    }

    @Override
    public int getContentHeight() {
        return contentHeight;
    }

    @Override
    public void setContentHeight(int contentHeight) {
        if (contentHeight > physicalHeight) {
            throw new IllegalArgumentException("contentHeight cannot exceed physicalHeight");
        }
        this.contentHeight = contentHeight;
    }

    @Override
    public int getMaxContentWidth() {
        return getPhysicalWidth();
    }

    @Override
    public int getMaxContentHeight() {
        return getPhysicalHeight();
    }

    public int getLastImageSerial() {
        return lastImageSerial;
    }

    public void setLastImageSerial(int serial) {
        lastImageSerial = serial;
    }

    @Override
    public void update(Image img) {
        this.update(img, 0, 0);
    }

    @Override
    public void update(Image img, int dstx, int dsty) {
        this.update(img, dstx, dsty, img.getWidth(), img.getHeight());
    }

    @Override
    public void update(Image img, int dstx, int dsty, int srcw, int srch) {
        this.update(img, dstx, dsty, srcw, srch, false);
    }

    @Override
    public void update(Image img, int dstx, int dsty, int srcw, int srch, boolean skipFlush) {
        if (PrismSettings.debug) {
            System.out.println("IMG.Bytes per pixel: " + img.getBytesPerPixelUnit());
            System.out.println("IMG.scanline: " + img.getScanlineStride());
        }
        this.update(img.getPixelBuffer(), img.getPixelFormat(), dstx, dsty,
                    0, 0, srcw, srch, img.getScanlineStride(), skipFlush);
    }

    @Override
    public WrapMode getWrapMode() {
        return wrapMode;
    }

    public Texture getSharedTexture(WrapMode altMode) {
        assertLocked();
        if (wrapMode == altMode) {
            lock();
            return this;
        }
        switch (altMode) {
            case REPEAT:
                if (wrapMode != WrapMode.CLAMP_TO_EDGE) {
                    return null;
                }
                break;
            case CLAMP_TO_EDGE:
                if (wrapMode != WrapMode.REPEAT) {
                    return null;
                }
                break;
            default:
                return null;
        }
        return this.createSharedLockedTexture(altMode);
    }

    @Override
    public boolean getLinearFiltering() {
        return false;
    }

    @Override
    public void setLinearFiltering(boolean linear) { }

    void allocate() {
        if (allocated) {
            return;
        }
        if (PrismSettings.debug) {
            System.out.println("PCS Texture allocating buffer: " + this + ", " + physicalWidth + "x" + physicalHeight);
        }
        this.allocateBuffer();
        allocated = true;
    }

    abstract void allocateBuffer();

    /**
     * Returns a new {@code Texture} object sharing all of the information
     * from this texture, but using the new {@code WrapMode}.
     * The new texture will be locked (in contrast to the similarly-named
     * method in BaseTexture).
     * 
     * @param altMode the new {@code WrapMode} for the new texture
     * @return a new, locked, texture object sharing all information with
     *         this texture except for the {@code WrapMode}
     */
    abstract Texture createSharedLockedTexture(WrapMode altMode);
}