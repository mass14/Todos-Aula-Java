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

package com.sun.javafx.css.parser;


class SimpleRecognizer implements Recognizer {

    public boolean recognize(int c) {
        for (int n=0; n<recognizedChars.length; n++)
            if (recognizedChars[n] == c) return true;
        return false;
    }

    public SimpleRecognizer(int c, int... others) {
        final int nChars = 1 + (others != null ? others.length : 0);
        recognizedChars = new int[nChars];
        recognizedChars[0] = c;
        for (int n=1; n<nChars; n++) recognizedChars[n] = others[n-1];
    }

    private SimpleRecognizer() {
        recognizedChars = null;
    }

    private final int[] recognizedChars;
}
