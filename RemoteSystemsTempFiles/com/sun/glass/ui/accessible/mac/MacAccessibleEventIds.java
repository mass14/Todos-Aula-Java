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

/**
 *
 * Note: This enum must be kept in sync with the native NSArray
 */
public class MacAccessibleEventIds {
    
    public enum MacEventId {
        MAIN_WINDOW_CHANGED,
        FOCUSED_WINDOW_CHANGED,
        FOCUSED_UI_ELEMENT_CHANGED,
        // Window-change notifications
        WINDOW__CREATED,
        WINDOW_DEMINIATURIZED,
        WINDOW_MINIATURIZED,
        WINDOW_MOVED,
        WINDOW_RESIZED,
        // Application notifications
        APPLICATION_ACTIVATED,
        APPLICATION_DEACTIVATED,
        APPLICATION_HIDDEN,
        APPLICATION_SHOWN,
        // Drawer and sheet notifications
        DRAWER_CREATED,
        SHEET_CREATED,
        // Element notifications
        CREATED,
        MOVED,
        RESIZED,
        TITLE_CHANGED,
        UI_ELEMENT_DESTROYED,
        VALUE_CHANGED,
        // Miscellaneous notifications
        HELP_TAG_CREATED,
        ROW_COUNT_CHANGED,
        SELECTED_CHILDREN_CHANGED,
        SELECTED_COLUMNS_CHANGED,
        SELECTED_ROWS_CHANGED,
        SELECTED_TEXT_CHANGED,
        ROW_EXPANDED,
        ROW_COLLAPSED,
        SELECTED_CELLS_CHANGED,
        UNITS_CHANGED,
        SELECTED_CHILDREN_MOVED
    }
    
}
