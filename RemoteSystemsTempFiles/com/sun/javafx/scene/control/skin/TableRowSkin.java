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

package com.sun.javafx.scene.control.skin;


import javafx.beans.property.DoubleProperty;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;

import com.sun.javafx.scene.control.behavior.CellBehaviorBase;
import com.sun.javafx.scene.control.behavior.TableRowBehavior;

import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.TableColumnBase;

/**
 */
public class TableRowSkin<T> extends TableRowSkinBase<T, TableRow<T>, CellBehaviorBase<TableRow<T>>, TableCell<T,?>> {

    private TableView<T> tableView;
    private TableViewSkin<T> tableViewSkin;
    
    public TableRowSkin(TableRow<T> tableRow) {
        super(tableRow, new TableRowBehavior<T>(tableRow));
        
        this.tableView = tableRow.getTableView();
        updateTableViewSkin();
        
        super.init(tableRow);

        registerChangeListener(tableRow.tableViewProperty(), "TABLE_VIEW");
    }

    @Override protected void handleControlPropertyChanged(String p) {
        super.handleControlPropertyChanged(p);
        if ("TABLE_VIEW".equals(p)) {
            updateTableViewSkin();
            
            for (int i = 0, max = cells.size(); i < max; i++) {
                Node n = cells.get(i);
                if (n instanceof TableCell) {
                    ((TableCell)n).updateTableView(getSkinnable().getTableView());
                }
            }
            
            this.tableView = getSkinnable().getTableView();
        }
    }
    
    @Override protected TableCell<T, ?> getCell(TableColumnBase tcb) {
        TableColumn tableColumn = (TableColumn<T,?>) tcb;
        TableCell cell = (TableCell) tableColumn.getCellFactory().call(tableColumn);

        // we set it's TableColumn, TableView and TableRow
        cell.updateTableColumn(tableColumn);
        cell.updateTableView(tableColumn.getTableView());
        cell.updateTableRow(getSkinnable());
        
        return cell;
    }

    @Override protected ObservableList<TableColumn<T, ?>> getVisibleLeafColumns() {
        return tableView.getVisibleLeafColumns();
    }

    @Override protected void updateCell(TableCell<T, ?> cell, TableRow<T> row) {
        cell.updateTableRow(row);
    }

    @Override protected DoubleProperty fixedCellSizeProperty() {
        return tableView.fixedCellSizeProperty();
    }

    @Override protected boolean isColumnPartiallyOrFullyVisible(TableColumnBase tc) {
        return tableViewSkin == null ? false : tableViewSkin.isColumnPartiallyOrFullyVisible((TableColumn)tc);
    }

    @Override protected TableColumn<T, ?> getTableColumnBase(TableCell<T, ?> cell) {
        return cell.getTableColumn();
    }

    @Override protected ObjectProperty<Node> graphicProperty() {
        return null;
    }

    @Override protected Control getVirtualFlowOwner() {
        return getSkinnable().getTableView();
    }
    
    private void updateTableViewSkin() {
        TableView<T> tableView = getSkinnable().getTableView();
        if (tableView.getSkin() instanceof TableViewSkin) {
            tableViewSkin = (TableViewSkin)tableView.getSkin();
        }
    }
}
