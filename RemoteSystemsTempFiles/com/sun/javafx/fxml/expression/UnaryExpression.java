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
 * Abstract base class for unary expressions.
 */
public abstract class UnaryExpression extends Expression {
    private Expression operand;

    public UnaryExpression(Expression operand) {
        if (operand == null) {
            throw new NullPointerException();
        }

        this.operand = operand;
    }

    public Expression getOperand() {
        return operand;
    }

    public abstract String getOperator();

    @Override
    public void update(Object namespace, Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isDefined(Object namespace) {
        return operand.isDefined(namespace);
    }

    @Override
    public boolean isLValue() {
        return false;
    }

    @Override
    protected void getArguments(List<KeyPath> arguments) {
        operand.getArguments(arguments);
    }

    @Override
    public String toString() {
        return "(" + getOperator() + operand + ")";
    }
}
