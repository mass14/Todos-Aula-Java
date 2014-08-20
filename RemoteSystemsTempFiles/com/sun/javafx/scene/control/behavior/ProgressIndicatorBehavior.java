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

import javafx.scene.control.ProgressIndicator;
import java.util.Collections;

public class ProgressIndicatorBehavior<C extends ProgressIndicator> extends BehaviorBase<C> {

    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/

    public ProgressIndicatorBehavior(final C progress) {
        super(progress, Collections.EMPTY_LIST);
    }
}
