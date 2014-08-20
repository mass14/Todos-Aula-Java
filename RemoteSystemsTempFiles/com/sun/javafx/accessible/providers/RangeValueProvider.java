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

package com.sun.javafx.accessible.providers;

/**
 *
 */
public interface RangeValueProvider {
    
    public double getValue();
    
    public boolean isReadOnly();
    
    public double getLargeValue();
    
    public double getMinimum();
    
    public double getMaximum();
    
    public double getSmallChange();
    
}
