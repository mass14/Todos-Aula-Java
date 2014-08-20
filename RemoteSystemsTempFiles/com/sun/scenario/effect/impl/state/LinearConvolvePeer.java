/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.scenario.effect.impl.state;

public interface LinearConvolvePeer {
    /**
     * Returns the number of power of 2 scales along the X axis.
     * Positive numbers mean to scale the image larger by the indicated
     * factors of 2.0.
     * Negative numbers mean to scale the image smaller by the indicated
     * factors of 0.5.
     * Overall the image will be scaled by {@code pow(2.0, getPow2ScaleX())}.
     * <p>
     * @param kernel the {@code LinearConvolveKernel} instance for the operation.
     * @return the power of 2.0 by which to scale the source image along the
     *         X axis.
     */
    public int getPow2ScaleX(LinearConvolveKernel kernel);

    /**
     * Returns the number of power of 2 scales along the Y axis.
     * Positive numbers mean to scale the image larger by the indicated
     * factors of 2.0.
     * Negative numbers mean to scale the image smaller by the indicated
     * factors of 0.5.
     * Overall the image will be scaled by {@code pow(2.0, getPow2ScaleY())}.
     * <p>
     * @param kernel the {@code LinearConvolveKernel} instance for the operation.
     * @return the power of 2.0 by which to scale the source image along the
     *         Y axis.
     */
    public int getPow2ScaleY(LinearConvolveKernel kernel);
}
