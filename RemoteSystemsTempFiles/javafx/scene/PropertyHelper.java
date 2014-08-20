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

package javafx.scene;

import java.security.AccessController;

class PropertyHelper {

    // Function to return whether a system property is set to true. Note that
    // this runs within a doPrivilege block so this function must be package-private.
    static boolean getBooleanProperty(final String propName) {
        try {
            boolean answer =
                AccessController.doPrivileged(new java.security.PrivilegedAction<Boolean>() {
                @Override
                    public Boolean run() {
                        String propVal = java.lang.System.getProperty(propName);
                        return "true".equals(propVal.toLowerCase());
                    }
            });
            return answer;
        } catch (Exception any) {
        }
        return false;
    }

}
