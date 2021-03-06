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

package com.sun.javafx.scene.control.behavior;

import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRowBehavior<T> extends CellBehaviorBase<TableRow<T>> {

    /***************************************************************************
     *                                                                         *
     * Private fields                                                          *
     *                                                                         *
     **************************************************************************/

    // For RT-17456: have selection occur as fast as possible with mouse input.
    // The idea is (consistently with some native applications we've tested) to
    // do the action as soon as you can. It takes a bit more coding but provides
    // the best feel:
    //  - when you click on a not-selected item, you can select immediately on press
    //  - when you click on a selected item, you need to wait whether DragDetected or Release comes first
    //
    // To support touch devices, we have to slightly modify this behavior, such
    // that selection only happens on mouse release, if only minimal dragging
    // has occurred.
    private boolean latePress = false;
    private boolean wasSelected = false;



    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/

    public TableRowBehavior(TableRow<T> control) {
        super(control, Collections.EMPTY_LIST);
    }



    /***************************************************************************
     *                                                                         *
     * Public API                                                              *
     *                                                                         *
     **************************************************************************/

    @Override public void mousePressed(MouseEvent event) {
        // we only care about clicks to the right of the right-most column
        if (! isClickOutsideCellBounds(event.getX())) return;

        boolean selectedBefore = getControl().isSelected();

        if (getControl().isSelected()) {
            latePress = true;
            return;
        }

        doSelect(event);

        if (IS_TOUCH_SUPPORTED && selectedBefore) {
            wasSelected = getControl().isSelected();
        }
    }

    @Override public void mouseReleased(MouseEvent event) {
        // we only care about clicks to the right of the right-most column
        if (! isClickOutsideCellBounds(event.getX())) return;

        if (latePress) {
            latePress = false;
            doSelect(event);
        }

        wasSelected = false;
    }

    @Override public void mouseDragged(MouseEvent event) {
        // we only care about clicks to the right of the right-most column
        if (! isClickOutsideCellBounds(event.getX())) return;

        latePress = false;

        // the mouse has now been dragged on a touch device, we should
        // remove the selection if we just added it in the last mouse press
        // event
        if (IS_TOUCH_SUPPORTED && ! wasSelected && getControl().isSelected()) {
            getControl().getTableView().getSelectionModel().clearSelection(getControl().getIndex());
        }
    }




    /***************************************************************************
     *                                                                         *
     * Private implementation                                                  *
     *                                                                         *
     **************************************************************************/

    private void doSelect(MouseEvent e) {
        super.mouseReleased(e);
        
        if (e.getButton() != MouseButton.PRIMARY) return;
        
        final TableRow<T> tableRow = getControl();
        final TableView<T> table = tableRow.getTableView();
        if (table == null) return;
        final TableSelectionModel<T> sm = table.getSelectionModel();
        if (sm == null || sm.isCellSelectionEnabled()) return;
        
        final int index = getControl().getIndex();
        final boolean isAlreadySelected = sm.isSelected(index);
        int clickCount = e.getClickCount();
        if (clickCount == 1) {
            // we only care about clicks to the right of the right-most column
            if (! isClickOutsideCellBounds(e.getX())) return;
            
            // In the case of clicking to the right of the rightmost
            // TreeTableCell, we should still support selection, so that
            // is what we are doing here.
            if (isAlreadySelected && e.isShortcutDown()) {
                sm.clearSelection(index);
            } else {
                if (e.isShortcutDown()) {
                    sm.select(tableRow.getIndex());
                } else if (e.isShiftDown()) {
                    // we add all rows between the current focus and
                    // this row (inclusive) to the current selection.
                    TablePositionBase anchor = TableCellBehavior.getAnchor(table, table.getFocusModel().getFocusedCell());
                    final int anchorRow = anchor.getRow();
                    final boolean asc = anchorRow < index;

                    // and then determine all row and columns which must be selected
                    int minRow = Math.min(anchorRow, index);
                    int maxRow = Math.max(anchorRow, index);

                    // To prevent RT-32119, we make a copy of the selected indices
                    // list first, so that we are not iterating and modifying it
                    // concurrently.
                    List<Integer> selectedIndices = new ArrayList<>(sm.getSelectedIndices());
                    for (int i = 0, max = selectedIndices.size(); i < max; i++) {
                        int selectedIndex = selectedIndices.get(i);
                        if (selectedIndex < minRow || selectedIndex > maxRow) {
                            sm.clearSelection(selectedIndex);
                        }
                    }

                    if (minRow == maxRow) {
                        // RT-32560: This prevents the anchor 'sticking' in
                        // the wrong place when a range is selected and then
                        // selection goes back to the anchor position.
                        // (Refer to the video in RT-32560 for more detail).
                        sm.select(minRow);
                    } else {
                        // RT-21444: We need to put the range in the correct
                        // order or else the last selected row will not be the
                        // last item in the selectedItems list of the selection
                        // model,
                        if (asc) {
                            sm.selectRange(minRow, maxRow + 1);
                        } else {
                            sm.selectRange(maxRow, minRow - 1);
                        }
                    }
                } else {
                    sm.clearAndSelect(tableRow.getIndex());
                }
            }
        }
    }

    private boolean isClickOutsideCellBounds(final double x) {
        // get width of all visible columns (we only care about clicks to the
        // right of the right-most column)
        final TableRow<T> tableRow = getControl();
        final TableView<T> table = tableRow.getTableView();
        if (table == null) return false;
        List<TableColumn<T, ?>> columns = table.getVisibleLeafColumns();
        double width = 0.0;
        for (int i = 0; i < columns.size(); i++) {
            width += columns.get(i).getWidth();
        }

        return x > width;
    }
}
