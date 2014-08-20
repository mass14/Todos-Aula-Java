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

import javafx.scene.input.KeyCharacterCombination;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class KeystrokeUtils {

    public static String toString(final KeyCombination kc) {
        if (kc == null) {
            return "";
        }
        
        StringBuilder stringBuilder = new StringBuilder();
        if (com.sun.javafx.PlatformUtil.isMac()) {
            // Macs have a different convention for keyboard accelerators -
            // no pluses to separate modifiers, and special symbols for
            // each modifier (in a particular order), etc
            if (kc.getControl() == KeyCombination.ModifierValue.DOWN) {
                stringBuilder.append("\u2303");
            }
            if (kc.getAlt() == KeyCombination.ModifierValue.DOWN) {
                stringBuilder.append("\u2325");
            }
            if (kc.getShift() == KeyCombination.ModifierValue.DOWN) {
                stringBuilder.append("\u21e7");
            }
            if (kc.getMeta() == KeyCombination.ModifierValue.DOWN || kc.getShortcut() == KeyCombination.ModifierValue.DOWN) {
                stringBuilder.append("\u2318");
            }
            // TODO refer to RT-14486 for remaining glyphs
        }
        else {
            if (kc.getControl() == KeyCombination.ModifierValue.DOWN || kc.getShortcut() == KeyCombination.ModifierValue.DOWN ) {
                stringBuilder.append("Ctrl+");
            }
            if (kc.getAlt() == KeyCombination.ModifierValue.DOWN) {
                stringBuilder.append("Alt+");
            }
            if (kc.getShift() == KeyCombination.ModifierValue.DOWN) {
                stringBuilder.append("Shift+");
            }
            if (kc.getMeta() == KeyCombination.ModifierValue.DOWN) {
                stringBuilder.append("Meta+");
            }
        }
        
        if (kc instanceof KeyCodeCombination) {
            stringBuilder.append(KeyCodeUtils.getAccelerator(((KeyCodeCombination)kc).getCode()));
        } else if (kc instanceof KeyCharacterCombination) {
            stringBuilder.append(((KeyCharacterCombination)kc).getCharacter());
        }

        return stringBuilder.toString();
    }
}
