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

package com.sun.javafx.fxml.expression;

import java.util.List;

/**
 * Abstract base class for binary expressions.
 */
public abstract class BinaryExpression extends Expression {
    private Expression left;
    private Expression right;

    public BinaryExpression(Expression left, Expression right) {
        if (left == null) {
            throw new NullPointerException();
        }

        if (right == null) {
            throw new NullPointerException();
        }

        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public abstract String getOperator();

    @Override
    public void update(Object namespace, Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isDefined(Object namespace) {
        return left.isDefined(namespace) && right.isDefined(namespace);
    }

    @Override
    public boolean isLValue() {
        return false;
    }

    @Override
    protected void getArguments(List<KeyPath> arguments) {
        left.getArguments(arguments);
        right.getArguments(arguments);
    }

    @Override
    public String toString() {
        return "(" + left + " " + getOperator() + " " + right + ")";
    }
}
