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
import com.sun.glass.ui.accessible.AccessibleBaseProvider;
import com.sun.glass.ui.accessible.AccessibleLogger;
import com.sun.javafx.accessible.providers.AccessibleProvider;
import com.sun.javafx.accessible.utils.NavigateDirection;
import java.util.HashMap;
import sun.util.logging.PlatformLogger;

/**
 * Windows platform implementation class for Accessible.
 */
public final class WinAccessibleBaseProvider extends AccessibleBaseProvider {

    final private static HashMap<Integer, NavigateDirection> directionMap =
        new HashMap<Integer, NavigateDirection>();
    
    static {
        _initIDs();
        
        for (NavigateDirection type : NavigateDirection.values()) {
            directionMap.put(type.ordinal(), type);
        }
    }
    
    native private static void _initIDs();
    native private long _createAccessible();
    native private void _destroyAccessible(long nativeAccessible);
    native private void _fireEvent(long nativeAccessible, int eventID);
    native private void _firePropertyChange( long nativeAccessible, int propertyID, 
                                             int oldProperty, int newProperty );
    native private void _firePropertyChange( long nativeAccessible, int propertyID, 
                                             boolean oldProperty, boolean newProperty );
    
    private long nativeAccessible;  // the native accessible
    
    /**
     * Downcall to create the native accessible.  This will be used when firing
     * events or when destroying the native accessible.
     * 
     * @param node      the related FX node object.
     */
    public WinAccessibleBaseProvider(Object node) {
        super(node);
        nativeAccessible = _createAccessible();
    }
    
    /**
     * Get the reference to the native accessible.
     * 
     * @return a reference to the native accessible.
     */
    long getNativeAccessible() {
        return nativeAccessible;
    }
    
    ////////////////////////////////////
    //
    // Start of downcalls to native code
    //
    ////////////////////////////////////
    
    /**
     * Downcall to destroy the native accessible.
     */
    @Override
    public void destroyAccessible() {
        _destroyAccessible(nativeAccessible);
    }

    /**
     * Downcall to fire an event.
     * 
     * @param eventID   the event ID.
     */
    @Override
    public void fireEvent(int eventID) {
        AccessibleLogger.getLogger().fine("this: " + this);
        AccessibleLogger.getLogger().fine("nativeAccessible: " + Long.toHexString(nativeAccessible));
        AccessibleLogger.getLogger().fine("eventID: " + eventID);
        _fireEvent(nativeAccessible, eventID);
    }
    
    /** 
     * Fire a property change event
     *
     * @param propertyID    identifies the property
     * @param oldProperty   the old value of the property
     * @param newProperty   the new value of the property
     */
    @Override
    public void firePropertyChange(int propertyID, int oldProperty, int newProperty) {
        AccessibleLogger.getLogger().fine("this: " + this);
        AccessibleLogger.getLogger().fine("nativeAccessible: " + Long.toHexString(nativeAccessible));
        AccessibleLogger.getLogger().fine("propertyID: " + propertyID);
        AccessibleLogger.getLogger().fine("old: " + oldProperty);
        AccessibleLogger.getLogger().fine("new: " + newProperty);
        _firePropertyChange(nativeAccessible, propertyID, oldProperty, newProperty);
    }
    
    /** 
     * Fire a property change event
     *
     * @param propertyId    identifies the property
     * @param oldProperty   the old value of the property
     * @param newProperty   the new value of the property
     */
    @Override
    public void firePropertyChange(int propertyID, boolean oldProperty, boolean newProperty) {
        AccessibleLogger.getLogger().fine("this: " + this);
        AccessibleLogger.getLogger().fine("nativeAccessible: " + Long.toHexString(nativeAccessible));
        AccessibleLogger.getLogger().fine("propertyID: " + propertyID);
        AccessibleLogger.getLogger().fine("old: " + oldProperty);
        AccessibleLogger.getLogger().fine("new: " + newProperty);
        _firePropertyChange(nativeAccessible, propertyID, oldProperty, newProperty);
    }
    
    //////////////////////////////////
    //
    // End of downcalls to native code
    //
    //////////////////////////////////
    
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
     * For AccessibleProvider - get_FragmentRoot
     *
     * @return address of native accessible of root object
     */
    private long getFragmentRoot() {
        WinAccessibleRoot root = (WinAccessibleRoot)(((AccessibleProvider)node).fragmentRoot());
        if (root == null) {
            return 0;
        } else {
            long nativeRoot = root.getNativeAccessible();
            AccessibleLogger.getLogger().fine("nativeRoot:  " + Long.toHexString(nativeRoot));
            return nativeRoot;
        }
    }
    
    /**
     * For AccessibleProvider - Navigate
     * 
     * @param direction  parent, first/last child, prev/next sibling
     *
     * @return address of the requested native accessible or 0 if there is no target
     *         in the requested direction.
     */

    private long navigate(int direction) {
        //AccessibleLogger.getLogger().fine("Thread ID: " + Thread.currentThread().getId());
        AccessibleLogger.getLogger().fine("direction: " + directionMap.get(direction));
        Object target =
            ((AccessibleProvider)node).navigate(directionMap.get(direction));
        long nativeTarget = 0;
        if (target == null) {
            AccessibleLogger.getLogger().fine("No object in that direction.");
        } else {
            if (target instanceof WinAccessibleBaseProvider) {
                nativeTarget = ((WinAccessibleBaseProvider)target).getNativeAccessible();
            } else if (target instanceof WinAccessibleRoot) {
                nativeTarget = ((WinAccessibleRoot)target).getNativeAccessible();
            }
            // TODO: Throw exception if instanceof something else?
            if (nativeTarget != 0) {
                AccessibleLogger.getLogger().fine("nativeTarget:  " + Long.toHexString(nativeTarget));
            }
        }
        return nativeTarget;
    }
    
    /**
     *   For AccessibleProvider - getPatternProvider  Retrieves an object that provides support for a control pattern
     *
     *   @param patternId: Identifier of the pattern.
     *    
     *   @return Object that implements the pattern interface, or null if the pattern is not supported.
     */
    private long getPatternProvider(int patternId) {
        long nativeProvider = 0;
        PlatformLogger logger = AccessibleLogger.getLogger();
        
        logger.fine("id: " + patternId);
        for (AccessibleBasePatternProvider pattern : patternProviders) {
            logger.fine("pattern.id" + ((WinAccessibleBasePatternProvider)pattern).getPatternId());
            if ( ((AccessibleBasePatternProvider)pattern).getPatternId() == patternId &&
                 pattern instanceof WinAccessibleBasePatternProvider ) {
                logger.fine("Found matching id: " + patternId);
                logger.fine("returning: " +
                    ((WinAccessibleBasePatternProvider)pattern).getNativeAccessible());
                nativeProvider =
                    ((WinAccessibleBasePatternProvider)pattern).getNativeAccessible();
            }
        }
        return nativeProvider;
    }

    //////////////////////////////////
    //
    // End of upcalls from native code
    //
    //////////////////////////////////

}
