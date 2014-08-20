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
import com.sun.javafx.accessible.providers.SelectionItemProvider;
import com.sun.javafx.accessible.utils.PatternIds;

/**
 * Windows platform implementation class for Accessible.
 */
public final class WinAccessibleSelectionItemProvider extends WinAccessibleBasePatternProvider {

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
     * @param provider  the base provider which this pattern provider is chained to.
     */
    public WinAccessibleSelectionItemProvider(Object node, WinAccessibleBaseProvider provider) {
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
     * For SelectionItemProvider - get_IsSelected
     *
     * @return the state
     */
    private boolean getIsSelected() {
        return ((SelectionItemProvider)node).isSelected();
    }

    /**
     * Gets the provider that implements the SelectionProvider pattern and acts as the
     * container for the calling object. 
     * 
     * @return the native accessible for the selection container
     */
    private long getSelectionContainer() {
        //AccessibleLogger.getLogger().fine("Thread ID: " + Thread.currentThread().getId());
        long nativeContainer = 0;
        if (node instanceof SelectionItemProvider) {
            WinAccessibleBaseProvider container =
                (WinAccessibleBaseProvider)((SelectionItemProvider)node).getSelectionContainer();
            if (container != null) {
                nativeContainer = container.getNativeAccessible();
            }
        }
        AccessibleLogger.getLogger().fine("nativeContainer:  " + Long.toHexString(nativeContainer));
        return nativeContainer;
    }

    /**
     * Return the ID of the pattern supported by this class
     */
    @Override
    public int getPatternId() {
        return PatternIds.SELECTION_ITEM ;
    }
    
    //////////////////////////////////
    //
    // End of upcalls from native code
    //
    //////////////////////////////////
    
}
