/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget;

import io.github.mmm.ui.widget.attribute.UiWidgetWithClick;
import io.github.mmm.ui.widget.attribute.UiWidgetWithText;

/**
 * {@link UiActiveWidget} that has a {@link #getText() label} and is {@link #click() clickable}.
 *
 * @since 1.0.0
 */
public abstract interface UiClickableWidget extends UiActiveWidget, UiWidgetWithText, UiWidgetWithClick {

}
