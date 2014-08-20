/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.scenario.effect.impl.prism;

import java.util.Map;
import java.util.WeakHashMap;
import com.sun.glass.ui.Screen;
import com.sun.scenario.effect.FilterContext;

public class PrFilterContext extends FilterContext {

    private static Screen defaultScreen;
    private static final Map<Screen, PrFilterContext> ctxMap =
        new WeakHashMap<Screen, PrFilterContext>();

    private static PrFilterContext printerFilterContext = null;
    public static PrFilterContext getPrinterContext(Object resourceFactory) {
        if (printerFilterContext == null) {
            // Parameter is returned by FilterContext.getReferent()
            printerFilterContext = new PrFilterContext(resourceFactory);
        }
        return printerFilterContext;
    }

    private PrFilterContext(Object screen) {
        super(screen);
    }

    public static PrFilterContext getInstance(Screen screen) {
        if (screen == null) {
            throw new IllegalArgumentException("Screen must be non-null");
        }
        PrFilterContext fctx = ctxMap.get(screen);
        if (fctx == null) {
            fctx = new PrFilterContext(screen);
            ctxMap.put(screen, fctx);
        }
        return fctx;
    }

    public static PrFilterContext getDefaultInstance() {
        if (defaultScreen == null) {
            // NOTE: filter context may need to sign up for screen set config
            // changes
            defaultScreen = Screen.getMainScreen();
        }
        return getInstance(defaultScreen);
    }
}
