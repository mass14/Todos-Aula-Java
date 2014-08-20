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
Builder class for javafx.scene.control.TableView
@see javafx.scene.control.TableView
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class TableViewBuilder<S, B extends javafx.scene.control.TableViewBuilder<S, B>> extends javafx.scene.control.ControlBuilder<B> implements javafx.util.Builder<javafx.scene.control.TableView<S>> {
    protected TableViewBuilder() {
    }
    
    /** Creates a new instance of TableViewBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static <S> javafx.scene.control.TableViewBuilder<S, ?> create() {
        return new javafx.scene.control.TableViewBuilder();
    }
    
    private int __set;
    private void __set(int i) {
        __set |= 1 << i;
    }
    public void applyTo(javafx.scene.control.TableView<S> x) {
        super.applyTo(x);
        int set = __set;
        while (set != 0) {
            int i = Integer.numberOfTrailingZeros(set);
            set &= ~(1 << i);
            switch (i) {
                case 0: x.setColumnResizePolicy(this.columnResizePolicy); break;
                case 1: x.getColumns().addAll(this.columns); break;
                case 2: x.setEditable(this.editable); break;
                case 3: x.setFocusModel(this.focusModel); break;
                case 4: x.setItems(this.items); break;
                case 5: x.setPlaceholder(this.placeholder); break;
                case 6: x.setRowFactory(this.rowFactory); break;
                case 7: x.setSelectionModel(this.selectionModel); break;
                case 8: x.getSortOrder().addAll(this.sortOrder); break;
                case 9: x.setTableMenuButtonVisible(this.tableMenuButtonVisible); break;
            }
        }
    }
    
    private javafx.util.Callback<javafx.scene.control.TableView.ResizeFeatures,java.lang.Boolean> columnResizePolicy;
    /**
    Set the value of the {@link javafx.scene.control.TableView#getColumnResizePolicy() columnResizePolicy} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B columnResizePolicy(javafx.util.Callback<javafx.scene.control.TableView.ResizeFeatures,java.lang.Boolean> x) {
        this.columnResizePolicy = x;
        __set(0);
        return (B) this;
    }
    
    private java.util.Collection<? extends javafx.scene.control.TableColumn<S,?>> columns;
    /**
    Add the given items to the List of items in the {@link javafx.scene.control.TableView#getColumns() columns} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B columns(java.util.Collection<? extends javafx.scene.control.TableColumn<S,?>> x) {
        this.columns = x;
        __set(1);
        return (B) this;
    }
    
    /**
    Add the given items to the List of items in the {@link javafx.scene.control.TableView#getColumns() columns} property for the instance constructed by this builder.
    */
    public B columns(javafx.scene.control.TableColumn<S,?>... x) {
        return columns(java.util.Arrays.asList(x));
    }
    
    private boolean editable;
    /**
    Set the value of the {@link javafx.scene.control.TableView#isEditable() editable} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B editable(boolean x) {
        this.editable = x;
        __set(2);
        return (B) this;
    }
    
    private javafx.scene.control.TableView.TableViewFocusModel<S> focusModel;
    /**
    Set the value of the {@link javafx.scene.control.TableView#getFocusModel() focusModel} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B focusModel(javafx.scene.control.TableView.TableViewFocusModel<S> x) {
        this.focusModel = x;
        __set(3);
        return (B) this;
    }
    
    private javafx.collections.ObservableList<S> items;
    /**
    Set the value of the {@link javafx.scene.control.TableView#getItems() items} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B items(javafx.collections.ObservableList<S> x) {
        this.items = x;
        __set(4);
        return (B) this;
    }
    
    private javafx.scene.Node placeholder;
    /**
    Set the value of the {@link javafx.scene.control.TableView#getPlaceholder() placeholder} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B placeholder(javafx.scene.Node x) {
        this.placeholder = x;
        __set(5);
        return (B) this;
    }
    
    private javafx.util.Callback<javafx.scene.control.TableView<S>,javafx.scene.control.TableRow<S>> rowFactory;
    /**
    Set the value of the {@link javafx.scene.control.TableView#getRowFactory() rowFactory} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B rowFactory(javafx.util.Callback<javafx.scene.control.TableView<S>,javafx.scene.control.TableRow<S>> x) {
        this.rowFactory = x;
        __set(6);
        return (B) this;
    }
    
    private javafx.scene.control.TableView.TableViewSelectionModel<S> selectionModel;
    /**
    Set the value of the {@link javafx.scene.control.TableView#getSelectionModel() selectionModel} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B selectionModel(javafx.scene.control.TableView.TableViewSelectionModel<S> x) {
        this.selectionModel = x;
        __set(7);
        return (B) this;
    }
    
    private java.util.Collection<? extends javafx.scene.control.TableColumn<S,?>> sortOrder;
    /**
    Add the given items to the List of items in the {@link javafx.scene.control.TableView#getSortOrder() sortOrder} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B sortOrder(java.util.Collection<? extends javafx.scene.control.TableColumn<S,?>> x) {
        this.sortOrder = x;
        __set(8);
        return (B) this;
    }
    
    /**
    Add the given items to the List of items in the {@link javafx.scene.control.TableView#getSortOrder() sortOrder} property for the instance constructed by this builder.
    */
    public B sortOrder(javafx.scene.control.TableColumn<S,?>... x) {
        return sortOrder(java.util.Arrays.asList(x));
    }
    
    private boolean tableMenuButtonVisible;
    /**
    Set the value of the {@link javafx.scene.control.TableView#isTableMenuButtonVisible() tableMenuButtonVisible} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B tableMenuButtonVisible(boolean x) {
        this.tableMenuButtonVisible = x;
        __set(9);
        return (B) this;
    }
    
    /**
    Make an instance of {@link javafx.scene.control.TableView} based on the properties set on this builder.
    */
    public javafx.scene.control.TableView<S> build() {
        javafx.scene.control.TableView<S> x = new javafx.scene.control.TableView<S>();
        applyTo(x);
        return x;
    }
}