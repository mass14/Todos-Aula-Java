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
package com.sun.glass.ui.accessible.mac;

import com.sun.glass.ui.accessible.AccessibleLogger;
import com.sun.javafx.accessible.providers.ToggleProvider;
import com.sun.javafx.accessible.utils.ToggleState;

/**
 * Mac platform implementation class for Accessible.
 */
public final class MacAccessibleToggleProvider extends MacAccessibleBasePatternProvider {
    
    /**
     * A class static block that initializes the JNI method IDs.
     */
    static {
        _initIDs();
    }
    
    native private static void _initIDs();  
    //native protected long _createAccessible(long nativeBaseProvider);
    native protected long _createAccessible();
    // TODO: The base/basic/simple provider needs to be passed on this call.  
    // At this point the Mac native code does not have the code that adds the
    // newly created pattern providing accessible to the list of pattern providers
    // that will be maintained in the base/basic/simple accessible.
    // See the Win code for how it's done there.
    native private void _destroyAccessible(long nativeAccessible);
    
    private long nativeAccessible;  // The native accessible
    
    /**
     * Downcall to create the native accessible.  This will be used when firing
     * events or when destroying the native accessible.
     *
     * @param node      the related FX node object.
     * @param provider  the base provider which this pattern provider is chained to.
     */
    public MacAccessibleToggleProvider(Object node, MacAccessibleBaseProvider provider) {
        super(node);
        //nativeAccessible = _createAccessible(provider.getNativeAccessible());
        nativeAccessible = _createAccessible();
        // TODO: See note on _createAccessible above.
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
    //   These upcalls are from a native NSAccessibility implementation.  This code
    //   translates the upcalls to a UIA-like implementation used in the JavaFX
    //   accessibility implementation.
    
    /**
     * For ToggleProvider - get_ToggleState
     *
     * @return the state: 0 == OFF, 1 == ON, 2 == INDETERMINATE
     */
    private long getToggleState() {
        long value = 2;
        ToggleState state = ((ToggleProvider)node).getToggleState();
        switch (state) {
            case OFF:
                value = 0;
                break;
            case ON:
                value = 1;
                break;
            case INDETERMINATE:
                value = 2;
                break;
        }
        return value;
    }

    
    //////////////////////////////////
    //
    // End of upcalls from native code
    //
    //////////////////////////////////
}
