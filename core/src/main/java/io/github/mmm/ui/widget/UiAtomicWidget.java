/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget;

import io.github.mmm.ui.attribute.AttributeWriteTooltip;

/**
 * Abstract interface for an <em>atomic</em> {@link UiWidget}. Here atomic means that it is not a
 * {@link io.github.mmm.ui.widget.composite.UiComposite}.
 *
 * @since 1.0.0
 */
public abstract interface UiAtomicWidget extends AttributeWriteTooltip, UiRegularWidget {

}
