/*
 * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.css;

import javafx.scene.paint.Paint;



final public class BorderPaint {
    private final Paint top;
    private final Paint right;
    private final Paint bottom;
    private final Paint left;
    
    public final Paint getTop() {
        return top;
    }

    public Paint getRight() {
        return right;
    }

    public Paint getBottom() {
        return bottom;
    }

    public Paint getLeft() {
        return left;
    }

    public BorderPaint(final Paint top, final Paint right,
                       final Paint bottom, final Paint left) {
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;
    }

    @Override public String toString() {
        StringBuilder sbuf = new StringBuilder();
        sbuf.append("top: ");
        sbuf.append(getTop());
        sbuf.append(", right: ");
        sbuf.append(getRight());
        sbuf.append(", bottom: ");
        sbuf.append(getBottom());
        sbuf.append(", left: ");
        sbuf.append(getLeft());
        return sbuf.toString();
    }
}

