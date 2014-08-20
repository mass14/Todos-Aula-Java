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
import com.sun.javafx.accessible.providers.SelectionProvider;
import com.sun.javafx.accessible.utils.PatternIds;

public final class WinAccessibleSelectionProvider extends WinAccessibleBasePatternProvider {

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
     * @param node          the related FX node object.
     * @param provider  the base provider which this pattern provider is chained to.
     */
    public WinAccessibleSelectionProvider(Object node, WinAccessibleBaseProvider provider) {
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
    
    private boolean canSelectMultiple() {
        AccessibleLogger.getLogger().fine("In WinAccessibleSelectionProvider.canSelectMultiple");
        boolean bRet = false;
        if (node instanceof SelectionProvider) {
            bRet = ((SelectionProvider)node).canSelectMultiple() ;
        }
        AccessibleLogger.getLogger().fine("In WinAccessibleSelectionProvider.canSelectMultiple" + bRet);
        return bRet ;
    }

    private long[] getSelection() {
        AccessibleLogger.getLogger().fine("In WinAccessibleSelectionProvider.getSelection");        
        long[] selection = null;
        if (node instanceof SelectionProvider) {
            Object[] selectedItems = ((SelectionProvider)node).getSelection();
            int size = selectedItems.length;
            selection = new long[size];
            for (int idx=0; idx<size; idx++) {
                if (selectedItems[idx] instanceof WinAccessibleBasePatternProvider) {
                    selection[idx] =
                        ((WinAccessibleBasePatternProvider)selectedItems[idx]).getNativeAccessible();
                } else {
                    selection = null;
                    break;
                }
            }
        }
        AccessibleLogger.getLogger().fine("returning: " + selection);
        return selection;
    }

    private boolean isSelectionRequired() {
        AccessibleLogger.getLogger().fine("In WinAccessibleSelectionProvider.isSelectionRequired"); 
        boolean bRet = false;
        if (node instanceof SelectionProvider) {
            bRet = ((SelectionProvider)node).isSelectionRequired();
        }
        AccessibleLogger.getLogger().fine("In WinAccessibleSelectionProvider.isSelectionRequired" + bRet);
        return bRet ;
        
    }
    
    /**
     * Return the ID of the pattern supported by this class
     */
    @Override
    public int getPatternId() {
        return PatternIds.SELECTION ;
    }

    //////////////////////////////////
    //
    // End of upcalls from native code
    //
    //////////////////////////////////
    
}
