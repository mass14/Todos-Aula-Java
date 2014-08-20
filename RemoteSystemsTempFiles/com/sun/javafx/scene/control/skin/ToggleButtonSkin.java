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

package com.sun.javafx.scene.control.skin;

import javafx.scene.control.ToggleButton;

import com.sun.javafx.scene.control.behavior.ButtonBehavior;

public class ToggleButtonSkin extends LabeledSkinBase<ToggleButton, ButtonBehavior<ToggleButton>> {

    public ToggleButtonSkin(ToggleButton toggleButton) {
        super(toggleButton, new ButtonBehavior<ToggleButton>(toggleButton));
    }
}
