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

package javafx.scene.layout;

/**
Builder class for javafx.scene.layout.GridPane
@see javafx.scene.layout.GridPane
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class GridPaneBuilder<B extends javafx.scene.layout.GridPaneBuilder<B>> extends javafx.scene.layout.PaneBuilder<B> {
    protected GridPaneBuilder() {
    }
    
    /** Creates a new instance of GridPaneBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static javafx.scene.layout.GridPaneBuilder<?> create() {
        return new javafx.scene.layout.GridPaneBuilder();
    }
    
    private int __set;
    public void applyTo(javafx.scene.layout.GridPane x) {
        super.applyTo(x);
        int set = __set;
        if ((set & (1 << 0)) != 0) x.setAlignment(this.alignment);
        if ((set & (1 << 1)) != 0) x.getColumnConstraints().addAll(this.columnConstraints);
        if ((set & (1 << 2)) != 0) x.setGridLinesVisible(this.gridLinesVisible);
        if ((set & (1 << 3)) != 0) x.setHgap(this.hgap);
        if ((set & (1 << 4)) != 0) x.getRowConstraints().addAll(this.rowConstraints);
        if ((set & (1 << 5)) != 0) x.setVgap(this.vgap);
    }
    
    private javafx.geometry.Pos alignment;
    /**
    Set the value of the {@link javafx.scene.layout.GridPane#getAlignment() alignment} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B alignment(javafx.geometry.Pos x) {
        this.alignment = x;
        __set |= 1 << 0;
        return (B) this;
    }
    
    private java.util.Collection<? extends javafx.scene.layout.ColumnConstraints> columnConstraints;
    /**
    Add the given items to the List of items in the {@link javafx.scene.layout.GridPane#getColumnConstraints() columnConstraints} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B columnConstraints(java.util.Collection<? extends javafx.scene.layout.ColumnConstraints> x) {
        this.columnConstraints = x;
        __set |= 1 << 1;
        return (B) this;
    }
    
    /**
    Add the given items to the List of items in the {@link javafx.scene.layout.GridPane#getColumnConstraints() columnConstraints} property for the instance constructed by this builder.
    */
    public B columnConstraints(javafx.scene.layout.ColumnConstraints... x) {
        return columnConstraints(java.util.Arrays.asList(x));
    }
    
    private boolean gridLinesVisible;
    /**
    Set the value of the {@link javafx.scene.layout.GridPane#isGridLinesVisible() gridLinesVisible} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B gridLinesVisible(boolean x) {
        this.gridLinesVisible = x;
        __set |= 1 << 2;
        return (B) this;
    }
    
    private double hgap;
    /**
    Set the value of the {@link javafx.scene.layout.GridPane#getHgap() hgap} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B hgap(double x) {
        this.hgap = x;
        __set |= 1 << 3;
        return (B) this;
    }
    
    private java.util.Collection<? extends javafx.scene.layout.RowConstraints> rowConstraints;
    /**
    Add the given items to the List of items in the {@link javafx.scene.layout.GridPane#getRowConstraints() rowConstraints} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B rowConstraints(java.util.Collection<? extends javafx.scene.layout.RowConstraints> x) {
        this.rowConstraints = x;
        __set |= 1 << 4;
        return (B) this;
    }
    
    /**
    Add the given items to the List of items in the {@link javafx.scene.layout.GridPane#getRowConstraints() rowConstraints} property for the instance constructed by this builder.
    */
    public B rowConstraints(javafx.scene.layout.RowConstraints... x) {
        return rowConstraints(java.util.Arrays.asList(x));
    }
    
    private double vgap;
    /**
    Set the value of the {@link javafx.scene.layout.GridPane#getVgap() vgap} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B vgap(double x) {
        this.vgap = x;
        __set |= 1 << 5;
        return (B) this;
    }
    
    /**
    Make an instance of {@link javafx.scene.layout.GridPane} based on the properties set on this builder.
    */
    public javafx.scene.layout.GridPane build() {
        javafx.scene.layout.GridPane x = new javafx.scene.layout.GridPane();
        applyTo(x);
        return x;
    }
}
