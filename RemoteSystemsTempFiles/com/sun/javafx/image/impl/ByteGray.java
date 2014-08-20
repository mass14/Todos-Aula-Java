/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.image.impl;

import com.sun.javafx.image.AlphaType;
import com.sun.javafx.image.BytePixelGetter;
import com.sun.javafx.image.BytePixelSetter;
import com.sun.javafx.image.ByteToBytePixelConverter;
import com.sun.javafx.image.ByteToIntPixelConverter;
import com.sun.javafx.image.IntPixelSetter;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class ByteGray {
    public static final BytePixelGetter getter = Getter.instance;

    public static final ByteToBytePixelConverter ToByteBgraConverter =
        ByteRgb.ToByteBgrfConv.nonpremult;
    public static final ByteToBytePixelConverter ToByteBgraPreConverter =
        ByteRgb.ToByteBgrfConv.premult;
    public static final ByteToIntPixelConverter ToIntArgbConverter =
        ByteRgb.ToIntFrgbConv.nonpremult;
    public static final ByteToIntPixelConverter ToIntArgbPreConverter =
        ByteRgb.ToIntFrgbConv.premult;

    static class Getter implements BytePixelGetter {
        static final BytePixelGetter instance = new Getter();
        private Getter() {}

        @Override
        public AlphaType getAlphaType() {
            return AlphaType.OPAQUE;
        }

        @Override
        public int getNumElements() {
            return 1;
        }

        @Override
        public int getArgb(byte arr[], int offset) {
            int g = arr[offset] & 0xff;
            return (0xff000000 | (g << 16) | (g << 8) | g);
        }

        @Override
        public int getArgbPre(byte arr[], int offset) {
            int g = arr[offset] & 0xff;
            return (0xff000000 | (g << 16) | (g << 8) | g);
        }

        @Override
        public int getArgb(ByteBuffer buf, int offset) {
            int g = buf.get(offset) & 0xff;
            return (0xff000000 | (g << 16) | (g << 8) | g);
        }

        @Override
        public int getArgbPre(ByteBuffer buf, int offset) {
            int g = buf.get(offset) & 0xff;
            return (0xff000000 | (g << 16) | (g << 8) | g);
        }
    }

    static class ToByteBgrfConv extends BaseByteToByteConverter {
        public static final ByteToBytePixelConverter nonpremult =
            new ToByteBgrfConv(ByteBgra.setter);
        public static final ByteToBytePixelConverter    premult =
            new ToByteBgrfConv(ByteBgraPre.setter);

        ToByteBgrfConv(BytePixelSetter setter) {
            super(ByteGray.getter, setter);
        }

        @Override
        void doConvert(byte srcarr[], int srcoff, int srcscanbytes,
                       byte dstarr[], int dstoff, int dstscanbytes,
                       int w, int h)
        {
            dstscanbytes -= w * 4;
            while (--h >= 0) {
                for (int x = 0; x < w; x++) {
                    byte g = srcarr[srcoff + x];
                    dstarr[dstoff++] = g;
                    dstarr[dstoff++] = g;
                    dstarr[dstoff++] = g;
                    dstarr[dstoff++] = (byte) 0xff;
                }
                srcoff += srcscanbytes;
                dstoff += dstscanbytes;
            }
        }

        @Override
        void doConvert(ByteBuffer srcbuf, int srcoff, int srcscanbytes,
                       ByteBuffer dstbuf, int dstoff, int dstscanbytes,
                       int w, int h)
        {
            dstscanbytes -= w * 4;
            while (--h >= 0) {
                for (int x = 0; x < w; x++) {
                    byte g = srcbuf.get(srcoff + x);
                    dstbuf.put(dstoff    , g);
                    dstbuf.put(dstoff + 1, g);
                    dstbuf.put(dstoff + 2, g);
                    dstbuf.put(dstoff + 3, (byte) 0xff);
                    dstoff += 4;
                }
                srcoff += srcscanbytes;
                dstoff += dstscanbytes;
            }
        }
    }

    static class ToIntFrgbConv extends BaseByteToIntConverter {
        public static final ByteToIntPixelConverter nonpremult =
            new ToIntFrgbConv(IntArgb.setter);
        public static final ByteToIntPixelConverter    premult =
            new ToIntFrgbConv(IntArgbPre.setter);

        private ToIntFrgbConv(IntPixelSetter setter) {
            super(ByteRgb.getter, setter);
        }

        @Override
        void doConvert(byte srcarr[], int srcoff, int srcscanbytes,
                       int  dstarr[], int dstoff, int dstscanints,
                       int w, int h)
        {
            while (--h >= 0) {
                for (int x = 0; x < w; x++) {
                    int g = srcarr[srcoff + x] & 0xff;
                    dstarr[dstoff + x] = 0xff000000 | (g << 16) | (g << 8) | g;
                }
                srcoff += srcscanbytes;
                dstoff += dstscanints;
            }
        }

        @Override
        void doConvert(ByteBuffer srcbuf, int srcoff, int srcscanbytes,
                       IntBuffer  dstbuf, int dstoff, int dstscanints,
                       int w, int h)
        {
            while (--h >= 0) {
                for (int x = 0; x < w; x++) {
                    int g = srcbuf.get(srcoff + x) & 0xff;
                    dstbuf.put(dstoff + x, 0xff000000 | (g << 16) | (g << 8) | g);
                }
                srcoff += srcscanbytes;
                dstoff += dstscanints;
            }
        }
    }
}
