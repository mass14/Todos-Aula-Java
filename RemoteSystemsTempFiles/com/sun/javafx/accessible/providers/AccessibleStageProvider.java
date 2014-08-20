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
public interface AccessibleStageProvider {
    // Summary:
    //     Retrieves the element in this fragment that is at the specified point.
    //
    // Parameters:
    //   x:
    //     The X coordinate,.
    //
    //   y:
    //     The Y coordinate.
    //
    // Returns:
    //     The provider for the child element at the specified point, if one exists,
    //     or the root provider if the point is on this element but not on any child
    //     element. Otherwise returns null.
    public Object elementProviderFromPoint(double x, double y);
    //
    // Summary:
    //     Retrieves the element in this fragment that has the input focus.
    //
    // Returns:
    //     The provider for the element in this fragment that has the input focus, if
    //     any; otherwise, a null reference (Nothing in Visual Basic).
    public Object getFocus();
}
