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

package com.sun.javafx.accessible.utils;

/**
 * Contains values that specify the state of a UI element that can be expanded and collapsed.
 */
public enum ExpandCollapseState {  
    /**
     * No children are visible.
     */
    ExpandCollapseState_Collapsed,
  
    /*
     * All children are visible.
     */
    ExpandCollapseState_Expanded,
  
    /*
     * Some, but not all, children are visible.
     */
    ExpandCollapseState_PartiallyExpanded,
    
    /*
     * The element does not expand or collapse.
     */
    ExpandCollapseState_LeafNode
    
};
