/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.input;

import io.github.mmm.ui.api.UiLocalizer;
import io.github.mmm.ui.api.attribute.AttributeWritePlaceholder;
import io.github.mmm.ui.api.widget.UiLabel;
import io.github.mmm.ui.api.widget.value.UiValidatableWidget;
import io.github.mmm.ui.api.widget.value.UiValuedWidget;

/**
 * {@link UiValuedWidget} for an input field.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public abstract interface UiAbstractInput<V> extends UiValidatableWidget<V> {

  /**
   * @return the {@link UiLabel#getText() label text} for the {@link UiInput#getNameWidget() name widget} or the title
   *         of the form group.
   */
  String getName();

  /**
   * @param name the new {@link #getName() name}. Prevents lazy initialization of the {@link UiInput#getNameWidget()
   *        name widget}.
   */
  void setName(String name);

  /**
   * @param widget the {@link UiAbstractInput} to initialize with the given {@code name}.
   * @param name the {@link #getName() name} to {@link #setName(String) set}. May be {@code null} in which case this
   *        method has no effect.
   * @param context the optional context for {@link UiLocalizer#localize(String, Object) localization}. May be
   *        {@code null}.
   */
  static void initName(UiAbstractInput<?> widget, String name) {

    initName(widget, name, null);
  }

  /**
   * @param widget the {@link UiAbstractInput} to initialize with the given {@code name}.
   * @param name the {@link #getName() name} to {@link #setName(String) set}. May be {@code null} in which case this
   *        method has no effect.
   * @param context the optional context for {@link UiLocalizer#localize(String, Object) localization}. May be
   *        {@code null}.
   */
  static void initName(UiAbstractInput<?> widget, String name, Object context) {

    if (name != null) {
      String l10n = UiLocalizer.get().localize(name, context);
      widget.setName(l10n);
      if (widget instanceof AttributeWritePlaceholder) {
        ((AttributeWritePlaceholder) widget).setPlaceholder(l10n);
      }
    }
  }

}
