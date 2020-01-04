/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.input;

import io.github.mmm.ui.widget.UiNativeWidget;

/**
 * {@link UiAbstractSingleChoice} for a <em>combo-box</em> that allows the end-user to expand a drop-down menu and
 * select the {@link #getValue() value} from a given list of {@link #getOptions() options}. However, the combo-box is
 * also and editable text input field that allows the user to enter the value manually including auto-completion from
 * the given {@link #getOptions() options} what is a valuable feature for accessibility and power-usage.
 *
 * @param <V> type of the {@link #getValue() value} and {@link #getOptions() option}.
 * @since 1.0.0
 */
public interface UiComboBox<V> extends UiAbstractSingleChoice<V>, UiNativeWidget {

  /**
   * @return the current text from the combo-box text input field. Typically the end-user shall only select one of the
   *         given {@link #getOptions() options} so you only need to use {@link #getValue()}. In some cases it may be
   *         necessary to get the text the user entered manually into the combo-box text input field e.g. in cases where
   *         this would be accepted as a new option (e.g. for a tag).
   */
  String getText();

}
