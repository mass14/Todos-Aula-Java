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
public interface ValueProvider {
    
    public Object getValue();
    
    /* Not needed for accessibility, but in future can be added for Test Automation 
    public void setValue(Object val);
    
    public boolean isReadOnly();
    */
}
