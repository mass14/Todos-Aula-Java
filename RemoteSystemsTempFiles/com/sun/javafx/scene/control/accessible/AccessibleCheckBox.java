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

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import com.sun.javafx.Logging;
import com.sun.javafx.accessible.providers.ToggleProvider;
import com.sun.javafx.accessible.utils.ControlTypeIds;
import com.sun.javafx.accessible.utils.EventIds;
import com.sun.javafx.accessible.utils.PropertyIds;
import com.sun.javafx.accessible.utils.ToggleState;
import sun.util.logging.PlatformLogger;
import sun.util.logging.PlatformLogger.Level;

public class AccessibleCheckBox extends AccessibleControl implements ToggleProvider {
    CheckBox checkBox ;
    public AccessibleCheckBox(CheckBox checkBox)
    {
        super(checkBox);
        this.checkBox = checkBox ;

        // initialize to receive state change event
        checkBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                ToggleState toggleOldState, toggleCurrState=ToggleState.OFF; // Disabled
                toggleOldState=ToggleState.ON;
                CheckBox checkBox = (CheckBox)t.getSource();
                if( checkBox.isIndeterminate() )
                {
                    toggleCurrState = ToggleState.INDETERMINATE;
                    toggleOldState = ToggleState.OFF ;
                }
                if( checkBox.isSelected() )
                {
                    toggleCurrState = ToggleState.ON;
                    toggleOldState = ToggleState.OFF ;
                }
                firePropertyChange(EventIds.AUTOMATION_PROPERTY_CHANGED,
                        toggleOldState.hashCode(), toggleCurrState.hashCode());
            }
        });
    }

   public ToggleState getToggleState()
   {
       PlatformLogger logger = Logging.getAccessibilityLogger();
        ToggleState toggleState=ToggleState.OFF; // Disabled
        if( checkBox.isIndeterminate() )
            toggleState = ToggleState.INDETERMINATE;
        if( checkBox.isSelected() )
            toggleState = ToggleState.ON;
        if (logger.isLoggable(Level.FINER)) {
            logger.finer(this.toString()+ "getToggleState" + toggleState.toString());
        }
        return toggleState ;

   }
    //
    // Summary:
    //     Retrieves the value of a property supported by the UI Automation provider.
    //
    // Parameters:
    //   propertyId:
    //     The property identifier.
    //
    // Returns:
    //     The property value, or a null if the property is not supported by this provider,
    //     or System.Windows.Automation.AutomationElementIdentifiers.NotSupported if
    //     it is not supported at all.
    @Override
    public Object getPropertyValue(int propertyId)
    {
        Object retVal = null ;
        switch(propertyId){
            case PropertyIds.NAME:
            case PropertyIds.DESCRIBED_BY:
                retVal = (Object)checkBox.getText() ;
                break;
            case PropertyIds.CONTROL_TYPE:
                retVal = ControlTypeIds.CHECK_BOX;
                break;
            case PropertyIds.IS_KEYBOARD_FOCUSABLE:
                retVal = true;
                break;
            case PropertyIds.HAS_KEYBOARD_FOCUS:
                retVal = checkBox.isFocused();
                break;
            case PropertyIds.IS_CONTROL_ELEMENT:
                retVal = true;
                break;
            case PropertyIds.IS_ENABLED:
                retVal = !checkBox.isDisabled();
                break;
            case PropertyIds.CLASS_NAME:
                retVal = this.getClass().toString();
                break;
            case PropertyIds.TOGGLE_TOGGLE_STATE:
                retVal = ToggleState.ON;
                break;
        }
        return retVal;
    }

    // Summary:
    //     Retrieves an object that provides support for a control pattern on a UI Automation
    //     element.
    //
    // Parameters:
    //   patternId:
    //     Identifier of the pattern.
    //
    // Returns:
    //     Object that implements the pattern interface, or null if the pattern is not
    //     supported.
    @Override
    public Object getPatternProvider(int patternId)
    {
        return (Object)super.getAccessibleElement() ;
    }

    @Override
    public void toggle()
    {
        checkBox.arm();
    }
}
