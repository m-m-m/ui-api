/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.img;

import io.github.mmm.base.text.CaseHelper;
import io.github.mmm.ui.api.datatype.UiSeverity;
import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;

/**
 * {@link UiAbstractImage} for an icon. Unlike a {@link UiImage} that can show images from any {@link UiImage#getUrl()
 * source} (URL) a {@link UiIcon} can only show icons out of a predefined set of icons shipped with the implementation.
 * By default the icons of FontAwesome are used. In order to be portable the {@link #getIconId() icon IDs} of the icons
 * used by {@code mmm-ui} use their own naming. Even when using FontAwesome this allows to replace the FontAwesome-icon
 * used for warning, error, etc. with a simple modification of a style-sheet and without changing any Java code.
 *
 * @since 1.0.0
 */
public interface UiIcon extends UiAbstractImage, UiNativeWidget {

  /** {@link #getIconId() ID} for error icon. */
  String ID_ERROR = CaseHelper.toLowerCase(UiSeverity.ERROR.getName());

  /** {@link #getIconId() ID} for warning icon. */
  String ID_WARNING = CaseHelper.toLowerCase(UiSeverity.WARNING.getName());

  /** {@link #getIconId() ID} for information icon. */
  String ID_INFORMATION = CaseHelper.toLowerCase(UiSeverity.INFORMATION.getName());

  /** {@link #getIconId() ID} for question icon. */
  String ID_QUESTION = CaseHelper.toLowerCase(UiSeverity.QUESTION.getName());

  /** {@link #getIconId() ID} for play icon. */
  String ID_PLAY = "play";

  /** {@link #getIconId() ID} for pause icon. */
  String ID_PAUSE = "pause";

  /** {@link #getIconId() ID} for next icon. */
  String ID_NEXT = "next";

  /** {@link #getIconId() ID} for previous icon. */
  String ID_PREVIOUS = "previous";

  /** {@link #getIconId() ID} for mute icon. */
  String ID_MUTE = "mute";

  /** {@link #getIconId() ID} for unmute icon. */
  String ID_UNMUTE = "unmute";

  /** {@link #getIconId() ID} for collapse icon. */
  String ID_COLLAPSE = "collapse";

  /** {@link #getIconId() ID} for expand icon. */
  String ID_EXPAND = "expand";

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
   * @param iconId the {@link UiIcon#getIconId() icon ID}.
   * @return the new {@link UiIcon}.
   */
  static UiIcon of(String iconId) {

    UiIcon widget = UiWidgetFactoryNative.get().create(UiIcon.class);
    widget.setIconId(iconId);
    return widget;
  }
}
