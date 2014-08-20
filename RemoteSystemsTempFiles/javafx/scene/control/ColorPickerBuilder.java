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

package javafx.scene.control;

/**
Builder class for javafx.scene.control.ColorPicker
@see javafx.scene.control.ColorPicker
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.2
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class ColorPickerBuilder<B extends javafx.scene.control.ColorPickerBuilder<B>> extends javafx.scene.control.ComboBoxBaseBuilder<javafx.scene.paint.Color, B> implements javafx.util.Builder<javafx.scene.control.ColorPicker> {
    protected ColorPickerBuilder() {
    }
    
    /** Creates a new instance of ColorPickerBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static javafx.scene.control.ColorPickerBuilder<?> create() {
        return new javafx.scene.control.ColorPickerBuilder();
    }
    
    private boolean __set;
    public void applyTo(javafx.scene.control.ColorPicker x) {
        super.applyTo(x);
        if (__set) x.getCustomColors().addAll(this.customColors);
    }
    
    private java.util.Collection<? extends javafx.scene.paint.Color> customColors;
    /**
    Add the given items to the List of items in the {@link javafx.scene.control.ColorPicker#getCustomColors() customColors} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B customColors(java.util.Collection<? extends javafx.scene.paint.Color> x) {
        this.customColors = x;
        __set = true;
        return (B) this;
    }
    
    /**
    Add the given items to the List of items in the {@link javafx.scene.control.ColorPicker#getCustomColors() customColors} property for the instance constructed by this builder.
    */
    public B customColors(javafx.scene.paint.Color... x) {
        return customColors(java.util.Arrays.asList(x));
    }
    
    /**
    Make an instance of {@link javafx.scene.control.ColorPicker} based on the properties set on this builder.
    */
    public javafx.scene.control.ColorPicker build() {
        javafx.scene.control.ColorPicker x = new javafx.scene.control.ColorPicker();
        applyTo(x);
        return x;
    }
}