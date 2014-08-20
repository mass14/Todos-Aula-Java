/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
import javafx.scene.control.DateCell;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.sun.javafx.scene.control.skin.DatePickerContent;
import com.sun.javafx.scene.traversal.Direction;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MONTHS;
import static java.time.temporal.ChronoUnit.WEEKS;
import static javafx.scene.input.KeyCode.DOWN;
import static javafx.scene.input.KeyCode.ENTER;
import static javafx.scene.input.KeyCode.LEFT;
import static javafx.scene.input.KeyCode.PAGE_DOWN;
import static javafx.scene.input.KeyCode.PAGE_UP;
import static javafx.scene.input.KeyCode.RIGHT;
import static javafx.scene.input.KeyCode.SPACE;
import static javafx.scene.input.KeyCode.UP;
import static javafx.scene.input.KeyEvent.*;

/**
 * Behaviors for LocalDate based cells types. Simply defines methods
 * that subclasses implement so that CellSkinBase has API to call.
 *
 */
public class DateCellBehavior extends CellBehaviorBase<DateCell> {
    /**************************************************************************
     *                          Setup KeyBindings                             *
     *************************************************************************/
    protected static final List<KeyBinding> DATE_CELL_BINDINGS = new ArrayList<KeyBinding>();
    static {
        DATE_CELL_BINDINGS.add(new KeyBinding(UP, "TraverseUp"));
        DATE_CELL_BINDINGS.add(new KeyBinding(DOWN, "TraverseDown"));
        DATE_CELL_BINDINGS.add(new KeyBinding(LEFT, "TraverseLeft"));
        DATE_CELL_BINDINGS.add(new KeyBinding(RIGHT, "TraverseRight"));
        DATE_CELL_BINDINGS.add(new KeyBinding(ENTER, KEY_RELEASED, "SelectDate"));
        DATE_CELL_BINDINGS.add(new KeyBinding(SPACE, KEY_RELEASED, "SelectDate"));
    }


    public DateCellBehavior(DateCell dateCell) {
        super(dateCell, DATE_CELL_BINDINGS);
    }

    @Override public void callAction(String name) {
        DateCell cell = getControl();
        DatePickerContent dpc = findDatePickerContent(cell);

        if (dpc != null) {
            switch (name) {
              case "SelectDate":    dpc.selectDayCell(cell); break;
              default: super.callAction(name);
            }
            return;
        }
        super.callAction(name);
    }

    @Override public void traverse(final Node node, final Direction dir) {
        switch (dir) {
          case UP:
          case DOWN:
          case LEFT:
          case RIGHT:
              if (node instanceof DateCell) {
                  DatePickerContent dpc = findDatePickerContent(node);
                  if (dpc != null) {
                      DateCell cell = (DateCell)node;
                      switch (dir) {
                        case UP:    dpc.goToDayCell(cell, -1, WEEKS); break;
                        case DOWN:  dpc.goToDayCell(cell, +1, WEEKS); break;
                        case LEFT:  dpc.goToDayCell(cell, -1, DAYS); break;
                        case RIGHT: dpc.goToDayCell(cell, +1, DAYS); break;
                      }
                      return;
                  }
              }
        }
        super.traverse(node, dir);
    }

    protected DatePickerContent findDatePickerContent(Node node) {
        Node parent = node;
        while ((parent = parent.getParent()) != null && !(parent instanceof DatePickerContent));
        return (DatePickerContent)parent;
    }
}
