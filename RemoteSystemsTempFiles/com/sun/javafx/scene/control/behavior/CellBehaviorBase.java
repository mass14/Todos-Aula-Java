/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

import javafx.scene.control.Cell;
import java.util.List;

/**
 * Behaviors for standard cells types. Simply defines methods that subclasses
 * implement so that CellSkinBase has API to call.
 *
 */
public class CellBehaviorBase<T extends Cell> extends BehaviorBase<T> {

    public CellBehaviorBase(T control, List<KeyBinding> bindings) {
        super(control, bindings);
    }
}
