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

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Control;
import sun.util.logging.PlatformLogger;
import sun.util.logging.PlatformLogger.Level;

import com.sun.javafx.Logging;
import com.sun.javafx.accessible.AccessibleNode;
import com.sun.javafx.accessible.utils.EventIds;

public class AccessibleControl extends AccessibleNode {
    Control control ;
    public AccessibleControl(Control control)
    {
	super(control);
        this.control = control ;

        control.focusedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                PlatformLogger logger = Logging.getAccessibilityLogger();
                if(!t && t1)
                {
                    if (logger.isLoggable(Level.FINER)) {
                        logger.finer(this.toString() + " Focus Change: true");
                    }
                    fireEvent(EventIds.AUTOMATION_FOCUS_CHANGED);
                }
                else
                    if (logger.isLoggable(Level.FINER)) {
                        logger.finer(this.toString() + " Focus Change: false");
                    }
            }
        } );
    }

    public void fireEvent(int id)
    {
        super.fireEvent(id);
    }

    public void firePropertyChange(int propertyId, int oldProperty, int newProperty) {
        super.firePropertyChange(propertyId, oldProperty, newProperty);
    }
    public void firePropertyChange(int propertyId, boolean oldProperty, boolean newProperty) {
        super.firePropertyChange(propertyId, oldProperty, newProperty);
    }

}
