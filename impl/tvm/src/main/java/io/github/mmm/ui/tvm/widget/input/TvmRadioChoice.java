/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import org.teavm.jso.dom.html.HTMLElement;
import org.teavm.jso.dom.html.HTMLInputElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.spi.ToStringFormatter;
import io.github.mmm.ui.widget.input.UiRadioChoice;
import io.github.mmm.ui.widget.input.UiTextInput;

/**
 * Implementation of {@link UiTextInput} using TeaVM.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public class TvmRadioChoice<V> extends TvmTextualInput<V> implements UiRadioChoice<V> {

  private static int counter = 1;

  private final HTMLElement topWidget;

  private List<V> options;

  private final List<RadioButton> radios;

  private Function<V, String> formatter;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmRadioChoice(UiContext context) {

    super(context, TYPE_RADIO);
    this.topWidget = newElement("ui-radios");
    String radioName = "tvm-radio-" + counter++;
    this.widget.addEventListener("focus", this::onFocusGain);
    this.widget.addEventListener("blur", this::onFocusLoss);
    this.radios = new ArrayList<>();
    this.radios.add(new RadioButton(this.widget, radioName, 0));
    this.options = Collections.emptyList();
    this.formatter = ToStringFormatter.get();
  }

  @Override
  public HTMLElement getTopWidget() {

    return this.topWidget;
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
    if (options == this.options) {
      return;
    }
    this.options = options;
    updateOptions();
  }

  private void updateOptions() {

    removeAllChildren(this.topWidget);
    ensureRadioButtonCount(this.options.size());
    int i = 0;
    for (V option : this.options) {
      RadioButton rb = this.radios.get(i++);
      String title = this.formatter.apply(option);
      rb.setLabel(title);
      this.topWidget.appendChild(rb.top);
    }
  }

  private void ensureRadioButtonCount(int count) {

    int size = this.radios.size();
    RadioButton rb = this.radios.get(size - 1);
    for (int i = size; i < count; i++) {
      rb = rb.createNext();
      rb.input.addEventListener("focus", this::onFocusGain);
      rb.input.addEventListener("blur", this::onFocusLoss);
      this.radios.add(rb);
    }
  }

  @Override
  public Function<V, String> getFormatter() {

    return this.formatter;
  }

  @Override
  public void setFormatter(Function<V, String> formatter) {

    if (formatter == null) {
      formatter = ToStringFormatter.get();
    }
    if (formatter == this.formatter) {
      return;
    }
    this.formatter = formatter;
    updateOptions();
  }

  @Override
  public V getValue() {

    int optionCount = this.options.size();
    for (int i = 0; i < optionCount; i++) {
      RadioButton rb = this.radios.get(i);
      if (rb.input.isChecked()) {
        return this.options.get(i);
      }
    }
    return null;
  }

  @Override
  protected void setValueNative(V value) {

    int index = this.options.indexOf(value);
    if ((index >= 0) && (index < this.radios.size())) {
      this.radios.get(index).input.setChecked(true);
    }
  }

  private class RadioButton {

    private final HTMLElement top;

    private final HTMLInputElement input;

    private final HTMLElement label;

    private int index;

    private RadioButton(String name, int index) {

      this(newInput(TYPE_RADIO), name, index);
    }

    private void setLabel(String title) {

      setTextContent(this.label, title);
    }

    private RadioButton(HTMLInputElement widget, String name, int index) {

      super();
      this.top = newElement(TvmRadioButton.TAG_UI_RADIO);
      this.input = widget;
      this.input.setName(name);
      this.index = index;
      String id = name + "-" + index;
      this.input.setAttribute("id", id);
      this.input.addEventListener("focus", TvmRadioChoice.this::onFocusGain);
      this.input.addEventListener("blur", TvmRadioChoice.this::onFocusLoss);
      this.label = newLabel();
      this.label.setAttribute("for", id);
      this.top.appendChild(this.input);
      this.top.appendChild(this.label);
    }

    private RadioButton createNext() {

      RadioButton radioButton = new RadioButton(this.input.getName(), this.index + 1);
      radioButton.input.setTabIndex(-1);
      return radioButton;
    }

  }

}
