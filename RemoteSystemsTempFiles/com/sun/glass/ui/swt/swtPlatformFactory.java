/*
 * Copyright (c) 2012, 2013, Oracle  and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.swt;

import com.sun.glass.ui.*;
import com.sun.glass.ui.accessible.AccessibleBaseProvider;
import com.sun.glass.ui.accessible.AccessibleRoot;
import com.sun.glass.ui.delegate.ClipboardDelegate;
import com.sun.glass.ui.delegate.MenuBarDelegate;
import com.sun.glass.ui.delegate.MenuDelegate;
import com.sun.glass.ui.delegate.MenuItemDelegate;
import com.sun.javafx.accessible.providers.AccessibleProvider;

public final class swtPlatformFactory extends PlatformFactory {

    @Override
    public Application createApplication(){
        return new SWTApplication();
    }

    @Override
    public MenuBarDelegate createMenuBarDelegate(final MenuBar menubar) {
        return new SWTMenuBarDelegate();
    }

    @Override
    public MenuDelegate createMenuDelegate(final Menu menu) {
        SWTMenuDelegate result = new SWTMenuDelegate(menu);
        return result;
    }

    @Override
    public MenuItemDelegate createMenuItemDelegate(final MenuItem item) {
        return new SWTMenuDelegate();
    }

    public ClipboardDelegate createClipboardDelegate() {
        return new ClipboardDelegate() {
            public Clipboard createClipboard(String clipboardName) {
                if (Clipboard.SYSTEM.equals(clipboardName)) {
                    return new SWTClipboard(clipboardName);
                }
                if (Clipboard.DND.equals(clipboardName)) {
                    return new SWTClipboard(clipboardName);
                }
                return null;
            }
        };
    }

    @Override
    public AccessibleRoot createAccessibleRoot(Object node, Window window) {
        //TODO - implement accessibility
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AccessibleBaseProvider createAccessibleProvider(Object node) {
        //TODO - implement accessibility
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
