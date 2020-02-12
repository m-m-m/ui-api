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
public class TvmComboBoxDataList<V> extends TvmTextualInput<V> implements UiComboBox<V> {

  private static int counter = 1;

  private final HTMLElement topWidget;

  private final HTMLElement datalist;

  private List<V> options;

  private List<String> titles;

  private Function<V, String> formatter;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmComboBoxDataList(UiContext context) {

    super(context, "text");
    HTMLDocument document = Window.current().getDocument();
    this.topWidget = document.createElement("div");
    this.datalist = document.createElement("datalist");
    String dataListId = "tvm-dl-" + counter++;
    this.datalist.setAttribute("id", dataListId);
    this.widget.setAttribute("list", dataListId);
    this.topWidget.appendChild(this.widget);
    this.topWidget.appendChild(this.datalist);
    this.options = Collections.emptyList();
    this.formatter = ToStringFormatter.get();
    this.titles = new ArrayList<>();
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

    removeAllChildren(this.datalist);
    HTMLDocument document = this.datalist.getOwnerDocument();
    this.titles.clear();
    for (V option : this.options) {
      HTMLOptionElement optionElement = document.createElement("option").cast();
      String title = this.formatter.apply(option);
      this.titles.add(title);
      optionElement.setValue(title);
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
  public V getValue() {

    String title = this.widget.getValue();
    int index = this.titles.indexOf(title);
    if ((index < 0) || (index >= this.options.size())) {
      return null;
    }
    return this.options.get(index);
  }

  @Override
  protected void setValueNative(V value) {

    int index = this.options.indexOf(value);
    String title = "";
    if ((index >= 0) && (index < this.titles.size())) {
      title = this.titles.get(index);
    }
    this.widget.setValue(title);
  }

}
