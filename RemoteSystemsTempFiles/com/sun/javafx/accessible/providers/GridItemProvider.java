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

public interface GridItemProvider {
    
    public int getRow();
    
    public int getColumn();
    
    public int getRowSpan();
    
    public int getColumnSpan();
    
    public Object getContainingGrid();
    
}
