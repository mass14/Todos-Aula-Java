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
package com.sun.glass.ui.accessible;

public abstract class AccessibleBasePatternProvider {
    protected Object node;  // the JavaFX node
    
    /**
     * Constructor for AccessibleBasePatternProvider
     * 
     * @param node          The FX accessible node.
     */
    public AccessibleBasePatternProvider(Object node) {
        this.node = node;
    }

    // Downcalls
    
    /**
     * Destroy the native accessible
     */
    abstract public void destroyAccessible();
    
    public int getPatternId() {
        return 0;  // Only needed for Win implementation
    }
    
}
