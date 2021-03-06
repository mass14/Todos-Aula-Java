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

package com.sun.glass.ui.ios;

import com.sun.glass.ui.Pixels;
import com.sun.glass.ui.View;
import java.util.Map;

/**
 * iOS View platform implementation.
 */
final class IosView extends View {
    public IosView() {
        super();
    }

    // Constants /reusing Mac OS X values
    private static final long multiClickTime =  300;
    private static final int multiClickMaxX = 2;
    private static final int multiClickMaxY = 2;
    
    // native object pointer
    private long nativePtr;

    /**
     * Returns ID of Open GL ES (2.0) FrameBuffer Object associated with this view.
     * i.e. FBO used when rendering into this IosView
     */
    public long getFrameBuffer() {
        return getFrameBufferImpl(nativePtr);
    }

    static long _getMultiClickTime() {
        return multiClickTime;
    }

    static int _getMultiClickMaxX() {
        return multiClickMaxX;
    }

    static int _getMultiClickMaxY() {
        return multiClickMaxY;
    }
   
    native protected long getFrameBufferImpl(long nativePtr);

    // See View
    @Override protected void _enableInputMethodEvents(long ptr, boolean enable) { }

    @Override native protected long _create(Map caps);

    @Override native protected long _getNativeView(long ptr);

    @Override native protected int _getX(long ptr);
    @Override protected native int _getY(long ptr);

    @Override native protected boolean _close(long ptr);

    @Override native protected void _scheduleRepaint(long ptr);

    @Override native protected void _begin(long ptr);
    @Override native protected void _end(long ptr);

    @Override native protected boolean _enterFullscreen(long ptr, boolean animate, boolean keepRatio, boolean hideCursor);
    @Override native protected void _exitFullscreen(long ptr, boolean animate);

    @Override native protected void _setParent(long ptr, long parentPtr);
    @Override protected void _uploadPixels(long ptr, Pixels pixels) {
        throw new RuntimeException("IosView._uploadPixels() UNIMPLEMENTED.");
    }
}

