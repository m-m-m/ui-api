/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import org.teavm.jso.browser.Window;
import org.teavm.jso.dom.html.HTMLDocument;
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

  private final List<HTMLInputElement> radios;

  private Function<V, String> formatter;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmRadioChoice(UiContext context) {

    super(context, "radio");
    HTMLDocument document = Window.current().getDocument();
    this.topWidget = document.createElement("div");
    String radioId = "tvm-radio-" + counter++;
    this.widget.setName(radioId);
    this.widget.addEventListener("focus", this::onFocusGain);
    this.widget.addEventListener("blur", this::onFocusLoss);
    this.radios = new ArrayList<>();
    this.radios.add(this.widget);
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
      HTMLInputElement inputElement = this.radios.get(i++);
      String title = this.formatter.apply(option);
      setTextContent(inputElement, title);
      this.topWidget.appendChild(inputElement);
    }
  }

  private void ensureRadioButtonCount(int count) {

    HTMLDocument document = this.widget.getOwnerDocument();
    for (int i = this.radios.size(); i < count; i++) {
      HTMLInputElement rb = document.createElement("input").cast();
      rb.setType("radio");
      rb.setName(this.widget.getName());
      rb.addEventListener("focus", this::onFocusGain);
      rb.addEventListener("blur", this::onFocusLoss);
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
      HTMLInputElement rb = this.radios.get(i);
      if (rb.isChecked()) {
        return this.options.get(i);
      }
    }
    return null;
  }

  @Override
  protected void setValueNative(V value) {

    int index = this.options.indexOf(value);
    if ((index >= 0) && (index < this.radios.size())) {
      this.radios.get(index).setChecked(true);
    }
  }

}
