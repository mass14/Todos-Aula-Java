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

package com.sun.glass.ui.ios;

import com.sun.glass.ui.*;
import com.sun.glass.ui.accessible.AccessibleBaseProvider;
import com.sun.glass.ui.accessible.AccessibleRoot;
import com.sun.glass.ui.delegate.ClipboardDelegate;
import com.sun.glass.ui.delegate.MenuBarDelegate;
import com.sun.glass.ui.delegate.MenuDelegate;
import com.sun.glass.ui.delegate.MenuItemDelegate;
import com.sun.javafx.accessible.providers.AccessibleProvider;

@SuppressWarnings({"UnusedDeclaration"})
public final class IosPlatformFactory extends PlatformFactory {

    /**
     * @inheritDoc 
     */
    @Override
    public Application createApplication(){
        return new IosApplication();
    }

    /**
     * @inheritDoc 
     */
    @Override
    public MenuBarDelegate createMenuBarDelegate(final MenuBar menubar) {
        return new IosMenuBarDelegate();
    }

    /**
     * @inheritDoc 
     */
    @Override
    public MenuDelegate createMenuDelegate(final Menu menu) {
        return new IosMenuDelegate();
    }

    /**
     * @inheritDoc 
     */
    @Override
    public MenuItemDelegate createMenuItemDelegate(final MenuItem item) {
        return new IosMenuDelegate();
    }

    /**
     * @inheritDoc 
     */
    @Override
    public ClipboardDelegate createClipboardDelegate() {
        return new IosClipboardDelegate();
    }

    /**
     * @inheritDoc 
     */
    @Override
    public AccessibleRoot createAccessibleRoot(Object node, Window window) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @inheritDoc 
     */
    @Override
    public AccessibleBaseProvider createAccessibleProvider(Object node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
