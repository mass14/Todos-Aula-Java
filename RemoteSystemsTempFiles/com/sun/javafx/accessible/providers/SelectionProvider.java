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
public interface SelectionProvider {
    public boolean canSelectMultiple();

    /**
     * Get the array of selected items
     * 
     * @return the array of selected items
     */
    public Object[] getSelection();

    /**
     * Determines if the provider requires at least one child element to be selected.
     * 
     * @return indicates if the provider requires at least one child element to be selected.
     */
    public boolean isSelectionRequired();
}
