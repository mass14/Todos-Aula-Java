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

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.Label;
import java.util.Collections;
import com.sun.javafx.scene.control.behavior.BehaviorBase;


/**
 * A Skin for Labels.
 */
public class LabelSkin extends LabeledSkinBase<Label, BehaviorBase<Label>> {

    public LabelSkin(final Label label) {
        super(label, new BehaviorBase<>(label, Collections.EMPTY_LIST));

        // Labels do not block the mouse by default, unlike most other UI Controls.
        consumeMouseEvents(false);

        registerChangeListener(label.labelForProperty(), "LABEL_FOR");
    }


    @Override protected void handleControlPropertyChanged(String p) {     
        super.handleControlPropertyChanged(p);
        if ("LABEL_FOR".equals(p)) {
            mnemonicTargetChanged();
        }
    }
}
