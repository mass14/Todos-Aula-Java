/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.scene.control.behavior;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumnBase;
import javafx.scene.control.TablePositionBase;
import javafx.scene.control.TableView;

import javafx.scene.control.TableView.TableViewFocusModel;

/**
 */
public class TableCellBehavior<S,T> extends TableCellBehaviorBase<S, T, TableColumn<S,?>, TableCell<S, T>> {
    
    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/    

    public TableCellBehavior(TableCell<S,T> control) {
        super(control);
    }
    
    
    
    /***************************************************************************
     *                                                                         *
     * Implement TableCellBehaviorBase Abstract API                            *
     *                                                                         *
     **************************************************************************/          

    /** @{@inheritDoc} */
    @Override TableView<S> getTableControl() {
        return getControl().getTableView();
    }

    /** @{@inheritDoc} */
    @Override TableColumn<S,T> getTableColumn() {
        return getControl().getTableColumn();
    }

    /** @{@inheritDoc} */
    @Override int getItemCount() {
        return getTableControl().getItems().size();
    }

    /** @{@inheritDoc} */
    @Override TableView.TableViewSelectionModel<S> getSelectionModel() {
        return getTableControl().getSelectionModel();
    }

    /** @{@inheritDoc} */
    @Override TableViewFocusModel<S> getFocusModel() {
        return getTableControl().getFocusModel();
    }

    /** @{@inheritDoc} */
    @Override TablePositionBase getFocusedCell() {
        return getTableControl().getFocusModel().getFocusedCell();
    }

    /** @{@inheritDoc} */
    @Override boolean isTableRowSelected() {
        return getControl().getTableRow().isSelected();
    }

    /** @{@inheritDoc} */
    @Override TableColumnBase getVisibleLeafColumn(int index) {
        return getTableControl().getVisibleLeafColumn(index);
    }

    /** @{@inheritDoc} */
    @Override protected int getVisibleLeafIndex(TableColumnBase tc) {
        return getTableControl().getVisibleLeafIndex((TableColumn) tc);
    }

    /** @{@inheritDoc} */
    @Override void focus(int row, TableColumnBase tc) {
        getFocusModel().focus(row, (TableColumn)tc);
    }

    /** @{@inheritDoc} */
    @Override void edit(int row, TableColumnBase tc) {
        getTableControl().edit(row, (TableColumn)tc);
    }
}
