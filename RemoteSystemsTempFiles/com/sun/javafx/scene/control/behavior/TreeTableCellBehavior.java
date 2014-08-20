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

import javafx.scene.Node;
import javafx.scene.control.TableColumnBase;
import javafx.scene.control.TablePositionBase;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 */
public class TreeTableCellBehavior<S,T> extends TableCellBehaviorBase<TreeItem<S>, T, TreeTableColumn<S, ?>, TreeTableCell<S,T>> {
    
    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/    

    public TreeTableCellBehavior(TreeTableCell<S,T> control) {
        super(control);
    }
    
    
    
    /***************************************************************************
     *                                                                         *
     * Implement TableCellBehaviorBase Abstract API                            *
     *                                                                         *
     **************************************************************************/          

    /** @{@inheritDoc} */
    @Override TreeTableView<S> getTableControl() {
        return getControl().getTreeTableView();
    }

    /** @{@inheritDoc} */
    @Override TreeTableColumn<S,T> getTableColumn() {
        return getControl().getTableColumn();
    }

    /** @{@inheritDoc} */
    @Override int getItemCount() {
        return getTableControl().getExpandedItemCount();
    }

    /** @{@inheritDoc} */
    @Override TreeTableView.TreeTableViewSelectionModel<S> getSelectionModel() {
        return getTableControl().getSelectionModel();
    }

    /** @{@inheritDoc} */
    @Override TreeTableView.TreeTableViewFocusModel<S> getFocusModel() {
        return getTableControl().getFocusModel();
    }

    /** @{@inheritDoc} */
    @Override TablePositionBase getFocusedCell() {
        return getTableControl().getFocusModel().getFocusedCell();
    }

    /** @{@inheritDoc} */
    @Override boolean isTableRowSelected() {
        return getControl().getTreeTableRow().isSelected();
    }

    /** @{@inheritDoc} */
    @Override TableColumnBase getVisibleLeafColumn(int index) {
        return getTableControl().getVisibleLeafColumn(index);
    }

    /** @{@inheritDoc} */
    @Override protected int getVisibleLeafIndex(TableColumnBase tc) {
        return getTableControl().getVisibleLeafIndex(null);
    }

    /** @{@inheritDoc} */
    @Override void focus(int row, TableColumnBase tc) {
        getFocusModel().focus(row, (TreeTableColumn)tc);
    }

    /** @{@inheritDoc} */
    @Override void edit(int row, TableColumnBase tc) {
        getTableControl().edit(row, (TreeTableColumn)tc);
    }

    @Override protected boolean checkDisclosureNodeClick(MouseEvent e) {
        final TreeItem<S> treeItem = getControl().getTreeTableRow().getTreeItem();
        final Node disclosureNode = getControl().getTreeTableRow().getDisclosureNode();
        if (disclosureNode != null) {
            if (disclosureNode.getBoundsInParent().contains(e.getX(), e.getY())) {
                if (treeItem != null) {
                    treeItem.setExpanded(! treeItem.isExpanded());
                }
                return true;
            }
        }
        return false;
    }
    
    @Override protected void simpleSelect(MouseEvent e) {
        TreeTableView<S> tv = getControl().getTreeTableView();
        TreeItem treeItem = getControl().getTreeTableRow().getTreeItem();
        int index = getControl().getIndex();
        TreeTableColumn<S,T> column = getTableColumn();
        TableSelectionModel sm = tv.getSelectionModel();
        
        boolean isAlreadySelected = sm.isSelected(index, column);

        if (isAlreadySelected && (e.isControlDown() || e.isMetaDown())) {
            sm.clearSelection(index, column);
            isAlreadySelected = false;
        } else {
            sm.clearAndSelect(index, column);
        }

        // handle editing, which only occurs with the primary mouse button
        if (e.getButton() == MouseButton.PRIMARY) {
            if (e.getClickCount() == 1 && isAlreadySelected) {
                tv.edit(index, column);
            } else if (e.getClickCount() == 1) {
                // cancel editing
                tv.edit(-1, null);
            } else if (e.getClickCount() == 2 && treeItem.isLeaf()) {
                // attempt to edit
                tv.edit(index, column);
            } else if (e.getClickCount() % 2 == 0) {
                // try to expand/collapse branch tree item
                treeItem.setExpanded(! treeItem.isExpanded());
            }
        }
    }
}
