/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget;

import io.github.mmm.ui.api.widget.composite.UiComposite;

/**
 * Interface for <em>custom widgets</em>. A custom widget is a {@link UiWidget} implemented via {@link #getDelegate()
 * delegation} to another widget. It is therefore toolkit independent and can be implemented as a regular class by
 * extending {@code AbstractUiCustomWidget} from {@code mmm-ui-api-custom}. This makes the programming model of this
 * UI-Toolkit easy to use as you can create reusable components as regular classes. <br>
 * Typical use-cases for custom widgets are {@link io.github.mmm.ui.api.widget.input.UiInput} fields for custom
 * datatypes and {@link UiComposite}s for editors of particular business objects.
 *
 * @param <W> type of the {@link #getDelegate() delegate}.
 *
 * @since 1.0.0
 */
public interface UiCustomWidget<W extends UiWidget> extends UiWidget {

  /**
   * @return the adapted {@link UiWidget} wrapped by this custom widget.
   */
  W getDelegate();
}
