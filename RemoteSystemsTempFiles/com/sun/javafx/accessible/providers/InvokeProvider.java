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
 * The Invoke control pattern is used to support controls that do not maintain 
 * state when activated but rather initiate or perform a single, unambiguous action.
 */
public interface InvokeProvider {
    
    /**
     * Sends a request to activate a control and initiate its single, unambiguous action.
     */
    public void invoke();
}
