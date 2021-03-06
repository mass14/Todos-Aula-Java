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

package javafx.geometry;

/**
Builder class for javafx.geometry.Insets
@see javafx.geometry.Insets
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class InsetsBuilder<B extends javafx.geometry.InsetsBuilder<B>> implements javafx.util.Builder<javafx.geometry.Insets> {
    protected InsetsBuilder() {
    }
    
    /** Creates a new instance of InsetsBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static javafx.geometry.InsetsBuilder<?> create() {
        return new javafx.geometry.InsetsBuilder();
    }
    
    private double bottom;
    /**
    Set the value of the {@link javafx.geometry.Insets#getBottom() bottom} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B bottom(double x) {
        this.bottom = x;
        return (B) this;
    }
    
    private double left;
    /**
    Set the value of the {@link javafx.geometry.Insets#getLeft() left} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B left(double x) {
        this.left = x;
        return (B) this;
    }
    
    private double right;
    /**
    Set the value of the {@link javafx.geometry.Insets#getRight() right} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B right(double x) {
        this.right = x;
        return (B) this;
    }
    
    private double top;
    /**
    Set the value of the {@link javafx.geometry.Insets#getTop() top} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B top(double x) {
        this.top = x;
        return (B) this;
    }
    
    /**
    Make an instance of {@link javafx.geometry.Insets} based on the properties set on this builder.
    */
    public javafx.geometry.Insets build() {
        javafx.geometry.Insets x = new javafx.geometry.Insets(this.top, this.right, this.bottom, this.left);
        return x;
    }
}
