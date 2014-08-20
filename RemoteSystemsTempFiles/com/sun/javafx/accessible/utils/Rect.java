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

package com.sun.javafx.accessible.utils;

/**
 *
 */
public class Rect {
    public final double getMinX() { return minX; }
    private double minX;

    public final double getMinY() { return minY; }
    private double minY;

    public final double getMaxX() { return maxX; }
    private double maxX;

    public final double getMaxY() { return maxY; }
    private double maxY;
    
    public Rect(double x, double y, double width, double height) {
        this.minX = x;
        this.minY = y;
        this.maxX = width;
        this.maxY = height;
    }
    
}
