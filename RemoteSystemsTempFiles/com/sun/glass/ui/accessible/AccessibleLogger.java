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
package com.sun.glass.ui.accessible;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Locale;

import sun.util.logging.PlatformLogger;
import sun.util.logging.PlatformLogger.Level;

public class AccessibleLogger {

    private static final PlatformLogger logger = initLogger();

    private static PlatformLogger initLogger() {
        PlatformLogger logger = PlatformLogger.getLogger("accessible");
        String levelString = AccessController.doPrivileged(
        new PrivilegedAction<String>() {
            public String run() {
                return System.getProperty("log.accessible", "SEVERE").toUpperCase(Locale.ROOT);
            }
        });
        try {
            logger.setLevel(Level.valueOf(levelString));
        } catch (Exception e) {
            logger.setLevel(Level.SEVERE);
        }
        return logger;
    }

    public static PlatformLogger getLogger() {
        return logger;
    }
}
