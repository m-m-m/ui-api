/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.button;

import io.github.mmm.ui.api.widget.UiAtomicWidget;
import io.github.mmm.ui.api.widget.UiClickableWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.link.UiInternalLink;

/**
 * This is the abstract interface for an {@link UiRegularWidget regular widget} that represents a <em>button</em> what
 * is a widget that can be clicked by the end-user in order to trigger some action.
 *
 * @see UiButton
 * @see UiInternalLink
 *
 * @since 1.0.0
 */
public abstract interface UiAbstractButton extends UiAtomicWidget, UiClickableWidget {

}
