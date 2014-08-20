/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.scene.control.accessible;

import com.sun.javafx.accessible.providers.ToggleProvider;
import com.sun.javafx.accessible.providers.ExpandCollapseProvider;
import com.sun.javafx.accessible.providers.InvokeProvider;
import com.sun.javafx.accessible.utils.ExpandCollapseState;
import com.sun.javafx.accessible.utils.ToggleState;
import javafx.scene.control.MenuButton;


public class AccessibleMenuButton extends AccessibleButton implements ToggleProvider, InvokeProvider, 
        ExpandCollapseProvider {
    
    MenuButton menuButton;
    public AccessibleMenuButton(MenuButton b) {
        super(b);
        this.menuButton = b;
    }
    
    @Override public void toggle() {
        if ( menuButton.isShowing()) 
            menuButton.hide();
        else menuButton.show();
    }

    @Override public ToggleState getToggleState() {
        if(menuButton.isShowing())
            return ToggleState.ON;
        else return ToggleState.OFF;
    }

    @Override public void invoke() {
        menuButton.show();
        // need to fire action event as well or may be only action event which 
        // will automatically call menuButton.show. 
    }

    @Override public ExpandCollapseState getExpandCollapseState() {
        if (menuButton.isShowing()) {
            return ExpandCollapseState.ExpandCollapseState_Expanded;
        } else {
            return ExpandCollapseState.ExpandCollapseState_Collapsed;
        }
    }

    @Override public void expand() {
        menuButton.show();
    }

    @Override public void collapse() {
        menuButton.hide();
    }
    
    @Override public Object getPatternProvider(int patternId) {
        return (Object)super.getAccessibleElement() ;
    }
}

