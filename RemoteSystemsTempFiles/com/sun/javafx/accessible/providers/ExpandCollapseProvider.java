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

import com.sun.javafx.accessible.utils.ExpandCollapseState;

/** 
 * The ExpandCollapse control pattern is used to support controls that visually 
 * expand to display more content and collapse to hide content.
 */
public interface  ExpandCollapseProvider {
    
    /**
    * Indicates the state, expanded or collapsed, of the control.
    */
    public ExpandCollapseState getExpandCollapseState() ;
    
    /**
     * Display all child nodes, controls, or content of the control.
     */
    public void expand();
    
    /**
     * Hides all child nodes, controls, or content of this element.
     */
    public void collapse();
    
}
