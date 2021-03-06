/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.nio.FloatBuffer;
import com.sun.javafx.geom.Rectangle;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.geom.transform.NoninvertibleTransformException;

public class MotionBlurState extends LinearConvolveKernel {
    private float radius;
    private float angle;
    private FloatBuffer weights;

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        if (radius < 0f || radius > 63f) {
            throw new IllegalArgumentException("Radius must be in the range [1,63]");
        }
        this.radius = radius;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public int getHPad() {
        return (int) Math.ceil(Math.abs(Math.cos(angle)) * radius);
    }

    public int getVPad() {
        return (int) Math.ceil(Math.abs(Math.sin(angle)) * radius);
    }

    @Override
    public int getNumberOfPasses() {
        return 1;
    }

    @Override
    public boolean isNop() {
        return (radius == 0f);
    }

    @Override
    public boolean isNop(int pass) {
        return (pass > 0 || radius == 0f);
    }

    @Override
    public int getKernelSize(int pass) {
        return ((int) Math.ceil(radius)) * 2 + 1;
    }

    @Override
    public final Rectangle getResultBounds(Rectangle srcdimension, int pass) {
        Rectangle ret = new Rectangle(srcdimension);
        ret.grow(getHPad(), getVPad());
        return ret;
    }

    @Override
    public float[] getVector(Rectangle srcnativedimensions,
                             BaseTransform transform, int pass)
    {
//        float xoff = (float) (Math.cos(angle) / srcnativedimensions.width);
//        float yoff = (float) (Math.sin(angle) / srcnativedimensions.height);
        float ret[] = new float[4];
        float cos = (float) Math.cos(angle);
        float sin = (float) Math.sin(angle);
        if (!transform.isTranslateOrIdentity()) {
            ret[0] = cos;
            ret[1] = sin;
            try {
                transform.inverseDeltaTransform(ret, 0, ret, 0, 1);
                cos = ret[0];
                sin = ret[1];
            } catch (NoninvertibleTransformException e) {
                sin = cos = 0f;
            }
        }
        float xoff = cos / srcnativedimensions.width;
        float yoff = sin / srcnativedimensions.height;
        int ksize = getScaledKernelSize(pass);
        int center = ksize / 2;
        ret[0] = xoff;
        ret[1] = yoff;
        ret[2] = -center * xoff;
        ret[3] = -center * yoff;
        return ret;
    }

    @Override
    public FloatBuffer getWeights(int pass) {
        int pad = (int) Math.ceil(radius);
        weights = GaussianBlurState.getGaussianWeights(weights, pad, radius, 0f);
        return weights;
    }
}
