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
package com.sun.glass.ui.mac;

import com.sun.glass.ui.*;
import com.sun.glass.ui.accessible.AccessibleBaseProvider;
import com.sun.glass.ui.accessible.AccessibleRoot;
import com.sun.glass.ui.accessible.mac.MacAccessibleBaseProvider;
import com.sun.glass.ui.accessible.mac.MacAccessibleRoot;
import com.sun.glass.ui.accessible.mac.MacAccessibleSelectionItemProvider;
import com.sun.glass.ui.accessible.mac.MacAccessibleSelectionProvider;
import com.sun.glass.ui.accessible.mac.MacAccessibleToggleProvider;
import com.sun.glass.ui.delegate.ClipboardDelegate;
import com.sun.glass.ui.delegate.MenuBarDelegate;
import com.sun.glass.ui.delegate.MenuDelegate;
import com.sun.glass.ui.delegate.MenuItemDelegate;
import com.sun.javafx.accessible.providers.AccessibleProvider;
import com.sun.javafx.accessible.providers.SelectionItemProvider;
import com.sun.javafx.accessible.providers.SelectionProvider;
import com.sun.javafx.accessible.providers.ToggleProvider;

public final class MacPlatformFactory extends PlatformFactory {

    @Override public Application createApplication(){
        return new MacApplication();
    }
    
    @Override public AccessibleRoot createAccessibleRoot(Object node, Window window) {
        return new MacAccessibleRoot(node, window);
    }
    
    @Override public AccessibleBaseProvider createAccessibleProvider(Object node) {
        MacAccessibleBaseProvider element = null;
        if (node instanceof AccessibleProvider) {
            element = new MacAccessibleBaseProvider(node);
        }
        if (node instanceof ToggleProvider) { 
            element.addPatternProviders(new MacAccessibleToggleProvider(node, element));
        }
        if (node instanceof SelectionProvider) { 
            element.addPatternProviders(new MacAccessibleSelectionProvider(node, element));
        }
        if (node instanceof SelectionItemProvider) {
            element.addPatternProviders(new MacAccessibleSelectionItemProvider(node, element));
        }
        return element;
    }

    @Override public MenuBarDelegate createMenuBarDelegate(MenuBar menubar) {
        return new MacMenuBarDelegate();
    }

    @Override public MenuDelegate createMenuDelegate(Menu menu) {
        return new MacMenuDelegate(menu);
    }

    @Override public MenuItemDelegate createMenuItemDelegate(MenuItem item) {
        return new MacMenuDelegate();
    }

    @Override public ClipboardDelegate createClipboardDelegate() {
        return new MacClipboardDelegate();
    }
}
