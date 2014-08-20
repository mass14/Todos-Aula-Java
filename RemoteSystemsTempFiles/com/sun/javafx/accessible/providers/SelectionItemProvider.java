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
public interface SelectionItemProvider {
    
    public void addToSelection();
    
    public void removeFromSelection();

    public void select();

    public boolean isSelected();

    public Object getSelectionContainer();
}
