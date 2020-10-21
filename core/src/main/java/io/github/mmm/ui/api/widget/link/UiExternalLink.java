/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.link;

import io.github.mmm.ui.api.attribute.AttributeWriteUrl;
import io.github.mmm.ui.api.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.api.widget.UiNativeWidget;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.api.widget.button.UiButton;

/**
 * {@link UiAbstractLink} to an external {@link #getUrl() URL}.<br>
 * Here you can see an example (with {@link #setText(String) setText("Click me")} and {@link #setUrl(String)
 * setUrl("https://en.wikipedia.org/wiki/Hyperlink")}):
 *
 * <pre>
 * <a href="https://en.wikipedia.org/wiki/Hyperlink">Click me</a>
 * </pre>
 *
 * @since 1.0.0
 */
public interface UiExternalLink extends UiAbstractLink, AttributeWriteUrl, UiRegularWidget, UiNativeWidget {

  /**
   * @param text the {@link UiButton#getText() label text}.
   * @param url the {@link #getUrl() URL}.
   * @return the new {@link UiButton}.
   */
  static UiExternalLink of(String text, String url) {

    UiExternalLink widget = UiWidgetFactoryNative.get().create(UiExternalLink.class);
    UiWidget.initText(widget, text);
    if (url != null) {
      widget.setUrl(url);
    }
    return widget;
  }

}
