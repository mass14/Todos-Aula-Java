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
package com.sun.glass.ui.accessible.win;

import com.sun.glass.ui.accessible.AccessibleBasePatternProvider;

abstract public class WinAccessibleBasePatternProvider extends AccessibleBasePatternProvider {
    
    public WinAccessibleBasePatternProvider(Object node){
        super(node);
    }
    
    abstract long getNativeAccessible();
    
}
