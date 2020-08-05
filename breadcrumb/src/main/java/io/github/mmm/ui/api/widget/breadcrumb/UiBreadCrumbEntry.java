/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.breadcrumb;

import io.github.mmm.event.EventSource;
import io.github.mmm.ui.api.attribute.AttributeWriteId;
import io.github.mmm.ui.api.attribute.AttributeWriteText;
import io.github.mmm.ui.api.event.UiClickEventListener;
import io.github.mmm.ui.api.event.UiEvent;
import io.github.mmm.ui.api.event.UiEventListener;

/**
 * An entry in the bread crumb. You may add a {@link UiClickEventListener} that triggers the navigation if the entry is
 * clicked.
 *
 * @since 1.0.0
 */
public interface UiBreadCrumbEntry extends AttributeWriteText, AttributeWriteId, EventSource<UiEvent, UiEventListener> {

}