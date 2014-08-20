/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism;

/**
 * TODO: 3D - Need documentation
 * This class represents mesh geometry data object
 */
public interface Mesh extends GraphicsResource {
    // This method will fail if and only if ALL faces are wrong.
    // A wrong face is one with zero area or with any index out of range
    public boolean buildGeometry(float pos[], float uv[], int faces[], int smoothing[]);

    public int getCount();
}
