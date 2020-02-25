/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.input;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.dom.html.HTMLOptionElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.spi.ToStringFormatter;
import io.github.mmm.ui.widget.input.UiComboBox;
import io.github.mmm.ui.widget.input.UiTextInput;

/**
 * Implementation of {@link UiTextInput} using TeaVM.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public class TvmComboBoxSelect<V> extends TvmHtmlSelect<V> implements UiComboBox<V> {

  private String placeholder;

  private List<V> options;

  private Function<V, String> formatter;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmComboBoxSelect(UiContext context) {

    super(context);
    this.options = Collections.emptyList();
    this.formatter = ToStringFormatter.get();
  }

  @Override
  public String getPlaceholder() {

    return this.placeholder;
  }

  @Override
  public void setPlaceholder(String placeholder) {

    this.placeholder = placeholder;
    // this.widget.setPlaceholder(placeholder);
    this.widget.setAttribute("placeholder", placeholder);
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

    removeAllChildren(this.widget);
    HTMLDocument document = this.widget.getOwnerDocument();
    for (V option : this.options) {
      HTMLOptionElement optionElement = document.createElement("option").cast();
      String title = this.formatter.apply(option);
      setTextContent(optionElement, title);
      this.widget.appendChild(optionElement);
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
  public void setText(String text) {

  }

  @Override
  public V getValue() {

    int index = this.widget.getSelectedIndex();
    if ((index < 0) || (index >= this.options.size())) {
      return null;
    }
    return this.options.get(index);
  }

  @Override
  public String getText() {

    return "";
  }

  @Override
  protected void setValueNative(V value) {

    int index = this.options.indexOf(value);
    if (index >= 0) {
      this.widget.setSelectedIndex(index);
    }
  }

}
