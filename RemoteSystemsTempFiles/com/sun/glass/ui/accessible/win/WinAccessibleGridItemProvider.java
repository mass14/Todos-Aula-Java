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
import com.sun.javafx.accessible.providers.GridItemProvider;
import com.sun.javafx.accessible.utils.PatternIds;

public final class WinAccessibleGridItemProvider extends WinAccessibleBasePatternProvider {

    /**
     * A class static block that initializes the JNI method IDs.
     */
    static {
        _initIDs();
    }

    native private static void _initIDs();
    native private long _createAccessible(long nativeBaseProvider);
    native private void _destroyAccessible(long nativeAccessible);
    
    private long nativeAccessible;  // The native accessible
 
    /**
     * Downcall to create the native accessible.  This will be used when firing
     * events or when destroying the native accessible.
     * 
     * @param node      the related FX node object.
     * @param provider  the base provider which this pattern provider is chained to.
     */
    public WinAccessibleGridItemProvider(Object node, WinAccessibleBaseProvider provider) {
        super(node);
        nativeAccessible = _createAccessible(provider.getNativeAccessible());
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
     * For GridItemProvider Row property
     *
     * @return the row index of this object.
     */
    private int getRow() {
        AccessibleLogger.getLogger().fine("In WinAccessibleGridItemProvider.getRow");
        return ((GridItemProvider)node).getRow();
    }

    /**
     * For GridItemProvider RowSpan property
     *
     * @return the the number of rows spanned by this object.
     */
    private int getRowSpan() {
        AccessibleLogger.getLogger().fine("In WinAccessibleGridItemProvider.getRowSpan");
        return ((GridItemProvider)node).getRowSpan();
    }
    
    /**
     * For GridItemProvider Column property
     *
     * @return the column index of this object.
     */
    private int getColumn() {
        AccessibleLogger.getLogger().fine("In WinAccessibleGridItemProvider.getColumn");
        return ((GridItemProvider)node).getColumn();
    }

    /**
     * For GridItemProvider ColumnSpan property
     *
     * @return the the number of columns spanned by this object.
     */
    private int getColumnSpan() {
        AccessibleLogger.getLogger().fine("In WinAccessibleGridItemProvider.getColumnSpan");
        return ((GridItemProvider)node).getColumnSpan();
    }

    /**
     * For GridItemProvider ContainingGrid property
     *
     * @return the provider that implements the GridProvider pattern and represents
     *         the container of this object. 
     */
    private long getContainingGrid() {
        long nativeContainer = 0;
        Object glassContainer = ((GridItemProvider)node).getContainingGrid();
        if (glassContainer != null) {
            nativeContainer =
                ((WinAccessibleBasePatternProvider)glassContainer).getNativeAccessible();
            AccessibleLogger.getLogger().fine("nativeContainer: " +
                Long.toHexString(nativeContainer));
        }
        return nativeContainer;
    }
    
    /**
     * Return the ID of the pattern supported by this class
     */
    public int getPatternId() {
        return PatternIds.GRID_ITEM ;
    }
    
    //////////////////////////////////
    //
    // End of upcalls from native code
    //
    //////////////////////////////////
    
}
