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

package com.sun.javafx.css.converters;

import com.sun.javafx.css.StyleConverterImpl;
import javafx.css.ParsedValue;
import javafx.css.StyleConverter;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public final class ColorConverter extends StyleConverterImpl<String, Color> {

    private static class Holder {
        static ColorConverter COLOR_INSTANCE = new ColorConverter();
    }

    // lazy, thread-safe instatiation
    public static StyleConverter<String, Color> getInstance() {
        return Holder.COLOR_INSTANCE;
    }

    private ColorConverter() {
        super();
    }

    @Override
    public Color convert(ParsedValue<String, Color> value, Font font) {
        String str = value.getValue();
        if (str == null || str.isEmpty() || "null".equals(str)) {
            return null;
        }
        try {
            return Color.web(str);
        } catch (final IllegalArgumentException e) {
            // TODO: use logger here
            System.err.println("not a color: " + value);
            return Color.BLACK;
        }
    }

    @Override
    public String toString() {
        return "ColorConverter";
    }
}
