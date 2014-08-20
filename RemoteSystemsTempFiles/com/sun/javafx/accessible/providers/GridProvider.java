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

public interface GridProvider {
    
    /**
     * Specifies the total number of columns in the grid
     * 
     * @return the column count
     */
    public int getColumnCount();
    
    /**
     * Specifies the total number of rows in the grid
     *
     * @return the row count
     */
    public int getRowCount();
    
    /**
     * Retrieves the Glass provider for the specified cell
     *
     * @return the Glass provider of the specified cell
     */
    public Object getItem(int row, int col);
}
