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

package com.sun.glass.ui.lens;

import com.sun.glass.ui.Application;
import com.sun.glass.ui.Menu;
import com.sun.glass.ui.MenuBar;
import com.sun.glass.ui.MenuItem;
import com.sun.glass.ui.PlatformFactory;
import com.sun.glass.ui.Window;
import com.sun.glass.ui.accessible.AccessibleBaseProvider;
import com.sun.glass.ui.accessible.AccessibleRoot;
import com.sun.glass.ui.delegate.ClipboardDelegate;
import com.sun.glass.ui.delegate.MenuBarDelegate;
import com.sun.glass.ui.delegate.MenuDelegate;
import com.sun.glass.ui.delegate.MenuItemDelegate;
import com.sun.javafx.accessible.providers.AccessibleProvider;

public final class LensPlatformFactory extends PlatformFactory {

    @Override public Application createApplication() {
        return new LensApplication();
    }

    @Override public MenuBarDelegate createMenuBarDelegate(MenuBar menubar) {
        return new LensMenuBarDelegate();
    }

    @Override public MenuDelegate createMenuDelegate(Menu menu) {
        return new LensMenuDelegate();
    }

    @Override public MenuItemDelegate createMenuItemDelegate(MenuItem item) {
        return new LensMenuDelegate();
    }

    public ClipboardDelegate createClipboardDelegate() {
        return new LensClipboardDelegate();
    }

    @Override
    public AccessibleRoot createAccessibleRoot(Object node, Window window) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AccessibleBaseProvider createAccessibleProvider(Object node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
