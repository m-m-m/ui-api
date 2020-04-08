/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.img;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * {@link UiAbstractImage} for an icon. Unlike a {@link UiImage} that can show images from any
 * {@link UiImage#getSource() source} (URL) a {@link UiIcon} can only show icons out of a predefined set of icons
 * shipped with the implementation. By default the icons of FontAwesome are used. In order to be portable the
 * {@link #getIconId() icon IDs} of the icons used by {@code mmm-ui} use their own naming. Even when using FontAwesome
 * this allows to replace the FontAwesome-icon used for warning, error, etc. with a simple modification of a style-sheet
 * and without changing any Java code.
 *
 * @since 1.0.0
 */
public interface UiIcon extends UiAbstractImage, UiNativeWidget {

  /**
   * @return the ID of the pre-defined icon. E.g.
   *         {@link io.github.mmm.ui.api.datatype.UiSeverity#WARNING}.{@link io.github.mmm.ui.api.datatype.UiSeverity#getName()
   *         getName()}.
   */
  String getIconId();

  /**
   * @param iconId the new value of {@link #getIconId()}.
   */
  void setIconId(String iconId);

  /**
   * @return the size of this icon. A value of {@code 1} is the default size. A larger value will increase the size
   *         (e.g. {@code 3} for triple of the original size) and a smaller value will decrease the size (e.g.
   *         {@code 0.5} for half the original size).
   */
  double getSize();

  /**
   * @param size the new value of {@link #getSize() size}.
   */
  void setSize(double size);

  /**
   * @param context the {@link UiContext}.
   * @param iconId the {@link UiIcon#getIconId() icon ID}.
   * @return the new {@link UiIcon}.
   */
  static UiIcon of(UiContext context, String iconId) {

    UiIcon widget = context.create(UiIcon.class);
    widget.setIconId(iconId);
    return widget;
  }
}
