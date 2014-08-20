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

import com.sun.javafx.accessible.utils.ToggleState;

/**
 * Defines the Toggle control pattern interface.
 */
public interface ToggleProvider {
    
    public void toggle();
    
    public ToggleState getToggleState();
    
}
