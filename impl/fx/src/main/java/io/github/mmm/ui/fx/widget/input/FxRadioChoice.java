/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.spi.ToStringFormatter;
import io.github.mmm.ui.widget.input.UiRadioChoice;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

/**
 * Implementation of {@link UiRadioChoice} using JavaFx {@link CheckBox}es.
 *
 * @param <V> type of the {@link #getValue() value} and {@link #getOptions() option}.
 * @since 1.0.0
 */
public class FxRadioChoice<V> extends FxInput<RadioButton, V> implements UiRadioChoice<V> {

  private final ToggleGroup group;

  private final HBox topWidget;

  private final List<RadioButton> radios;

  private List<V> options;

  private Function<V, String> formatter;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxRadioChoice(UiContext context) {

    super(context, new RadioButton());
    this.group = new ToggleGroup();
    this.widget.setToggleGroup(this.group);
    this.widget.setText("uninitialized");
    this.topWidget = new HBox();
    this.topWidget.getChildren().add(this.widget);
    this.radios = new ArrayList<>();
    this.radios.add(this.widget);
    this.options = Collections.emptyList();
    this.formatter = ToStringFormatter.get();
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.group.selectedToggleProperty().addListener(this::onValueChange);
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    for (RadioButton rb : this.radios) {
      rb.setDisable(!enabled);
    }
  }

  @Override
  public List<V> getOptions() {

    return this.options;
  }

  @Override
  public void setOptions(List<V> options) {

    if (options == null) {
      options = Collections.emptyList();
    }
    this.options = options;
    int optionCount = options.size();
    ensureRadioButtonCount(optionCount);
    ObservableList<Node> children = this.topWidget.getChildren();
    List<RadioButton> rbs = this.radios;
    if (optionCount < this.radios.size()) {
      rbs = this.radios.subList(0, optionCount);
    }
    children.setAll(rbs);
    for (int i = 0; i < optionCount; i++) {
      V option = options.get(i);
      RadioButton rb = this.radios.get(i);
      rb.setUserData(option);
      rb.setText(this.formatter.apply(option));
    }
  }

  private void ensureRadioButtonCount(int count) {

    for (int i = this.radios.size(); i < count; i++) {
      RadioButton rb = new RadioButton();
      rb.setToggleGroup(this.group);
      rb.focusedProperty().addListener(this::onFocusChange);
      this.radios.add(rb);
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public V getValue() {

    Toggle selection = this.group.getSelectedToggle();
    return (V) selection.getUserData();
  }

  @Override
  protected void setValueNative(V value) {

    int size = this.options.size();
    for (int i = 0; i < size; i++) {
      if (this.options.get(i) == value) {
        this.radios.get(i).setSelected(true);
      }
    }
  }

  @Override
  public Function<V, String> getFormatter() {

    return this.formatter;
  }

  @Override
  public void setFormatter(Function<V, String> formatter) {

    if (formatter == null) {
      this.formatter = ToStringFormatter.get();
    } else {
      this.formatter = formatter;
    }
  }

  @Override
  public Node getTopWidget() {

    return this.topWidget;
  }

}
