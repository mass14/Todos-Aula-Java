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

package com.sun.javafx.accessible.utils;

/**
 *
 */
public enum ProviderOptions {
    // Summary:
    //     The UI Automation provider is a client-side provider.
    CLIENT_SIDE_PROVIDER,
    //
    // Summary:
    //     The UI Automation provider is a server-side provider.
    SERVER_SIDE_PROVIDER,
    //
    // Summary:
    //     The UI Automation provider is a non-client-area provider.
    NON_CLIENT_AREA_PROVIDER,
    //
    // Summary:
    //     The UI Automation provider overrides another provider.
    OVERRIDE_PROVIDER,
    //
    // Summary:
    //     The UI Automation provider handles its own focus, and does not want UI Automation
    //     to set focus to the nearest window on its behalf when System.Windows.Automation.AutomationElement.SetFocus
    //     is called. This option is typically used by providers for windows that appear
    //     to take focus without actually receiving Win32 focus, such as menus and drop-down
    //     menus.
    PROVIDER_OWNS_SETFOUCS,
  
}
