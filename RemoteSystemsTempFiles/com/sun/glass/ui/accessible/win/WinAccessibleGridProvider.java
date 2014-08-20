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

import com.sun.glass.ui.accessible.AccessibleLogger;
import com.sun.javafx.accessible.providers.GridProvider;
import com.sun.javafx.accessible.utils.PatternIds;

public final class WinAccessibleGridProvider extends WinAccessibleBasePatternProvider {

    /**
     * A class static block that initializes the JNI method IDs.
     */
    static {
        _initIDs();
    }
    
    native private static void _initIDs();
    native protected long _createAccessible(long nativeBaseProvider);
    native private void _destroyAccessible(long nativeAccessible);

    private long nativeAccessible;  // The native accessible

    /**
     * Downcall to create the native accessible.  This will be used when firing
     * events or when destroying the native accessible.
     * 
     * @param node      the related FX node object.
     * @param baseProvider  the base provider which this pattern provider is chained to.
     */
    public WinAccessibleGridProvider(Object node, WinAccessibleBaseProvider baseProvider) {
        super(node);
        nativeAccessible = _createAccessible(baseProvider.getNativeAccessible());
    }
    
    /**
     * Get the native accessible
     * 
     * @return the native accessible
     */
    @Override
    long getNativeAccessible() {
        return nativeAccessible;
    }
    
    // Downcalls
    
    /**
     * Destroy the native accessible
     * 
     */
    @Override
    public void destroyAccessible() {
        _destroyAccessible(nativeAccessible);
    }

    ////////////////////////////////////
    //
    // Start of upcalls from native code
    //
    ////////////////////////////////////
    
    // Note:
    //   These upcalls are from a native UIA implementation.  This code translates
    //   the upcalls to the UIA-like implementation used in the JavaFX accessibility 
    //   implementation.

    /**
     * For WinAccessibleGridProvider - getColumnCount
     *
     * @return the ColumnCount
     */
    private int getColumnCount() {
        AccessibleLogger.getLogger().fine("In WinAccessibleGridProvider.getColumnCount");
        return ((GridProvider)node).getColumnCount();
    }

    /**
     * For WinAccessibleGridProvider - getRowCount
     *
     * @return the RowCount
     */
    private int getRowCount() {
        AccessibleLogger.getLogger().fine("In WinAccessibleGridProvider.getRowCount");
        return ((GridProvider)node).getRowCount();
    }
    
    /**
     * For WinAccessibleGridProvider - getItem
     *
     * @return the native accessible at the specified indexes.
     */
    private long getItem(int row, int col) {
        long item = 0;
        if (node instanceof GridProvider) {
            Object glassItem = ((GridProvider)node).getItem(row, col);
            if (glassItem instanceof WinAccessibleBaseProvider) {
                item = ((WinAccessibleBaseProvider)glassItem).getNativeAccessible();
            }
        }
        return item;
    }
    
    /**
     * Return the ID of the pattern supported by this class
     */
    @Override
    public int getPatternId() {
        return PatternIds.GRID ;
    }

    //////////////////////////////////
    //
    // End of upcalls from native code
    //
    //////////////////////////////////

}
