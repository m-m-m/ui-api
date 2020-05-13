/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.link;

import io.github.mmm.ui.api.attribute.AttributeWriteText;
import io.github.mmm.ui.api.widget.UiAtomicWidget;
import io.github.mmm.ui.api.widget.button.UiButton;

/**
 * {@link UiAtomicWidget} that represents a hyperlink (link). A link is some text that is highlighted and can be clicked
 * in order to navigate somewhere.<br>
 * <b>ATTENTION:</b> For usability a link navigate somewhere when clicked. For actions that change some state, load
 * additional data, or do something that does not switch the current dialog use other widgets, typically
 * {@link UiButton} instead.
 *
 * @since 1.0.0
 * @see UiExternalLink
 * @see UiInternalLink
 */
public abstract interface UiAbstractLink extends UiAtomicWidget, AttributeWriteText {

}
