/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.controller;

import io.github.mmm.ui.api.attribute.AttributeReadId;
import io.github.mmm.ui.api.attribute.AttributeReadTitle;
import io.github.mmm.ui.api.attribute.AttributeReadVisible;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.UiWidget;

/**
 * This is the interface for a dialog of the client application. It displays itself in the page of the main application
 * window. It is a singleton instance that is addressed via a {@link UiPlace}. A {@link UiController} is not a
 * {@link io.github.mmm.ui.api.widget.UiWidget} should NOT be mixed with a
 * {@link io.github.mmm.ui.api.widget.window.UiAbstractWindow winodw} or
 * {@link io.github.mmm.ui.api.widget.window.UiPopup popup}.
 *
 * @param <W> type of the {@link #getView() view}.
 * @since 1.0.0
 */
public interface UiController<W extends UiRegularWidget>
    extends AttributeReadTitle, AttributeReadId, AttributeReadVisible {

  /** The {@link #getId() id} of the root {@link UiController}. */
  String ID_ROOT = "root";

  /** The {@link #getId() id} of the {@link UiController} for the home page. */
  String ID_HOME = "home";

  /** The {@link #getId() id} of the page {@link UiController}. */
  String ID_PAGE = "page";

  /** The {@link #getId() id} of the content {@link UiController}. */
  String ID_CONTENT = "content";

  /** The {@link #getId() id} of the navigation {@link UiController}. */
  String ID_NAVIGATION = "navigation";

  /**
   * The {@link #getId() id} of the header {@link UiController}. Its {@link #getView() view} is supposed to be
   * {@link #embed(UiEmbedding, UiController) embedded} at the top of the page.
   */
  String ID_HEADER = "header";

  /**
   * The {@link #getId() id} of the header {@link UiController}. Its {@link #getView() view} is supposed to be
   * {@link #embed(UiEmbedding, UiController) embedded} at the bottom of the page.
   */
  String ID_FOOTER = "footer";

  /**
   * The {@link #getId() id} of the margin {@link UiController}. Its {@link #getView() view} is supposed to be
   * {@link #embed(UiEmbedding, UiController) embedded} at the right of the page (in the margin column).
   */
  String ID_MARGIN = "margin";

  /**
   * The ID of a controller should only contain ASCII letters, Latin digits, hyphens or underscores. It may also contain
   * slashes ('/') or the hash sign ('#'). It must not contain '?', '&', '=', ':', ';', '\\' or ' '.
   *
   * @see #ID_ROOT
   * @see #ID_PAGE
   * @see #ID_HOME
   */
  @Override
  String getId();

  @Override
  String getTitle();

  /**
   * @return {@code true} if this {@link UiController} can be {@link UiNavigationManager#navigateTo(UiPlace) navigated}
   *         directly (default), {@code false} otherwise. Override this method for internal parent controllers than may
   *         not be navigated directly.
   */
  default boolean isNavigable() {

    String id = getId();
    switch (id) {
      case ID_ROOT:
      case ID_HEADER:
      case ID_FOOTER:
      case ID_MARGIN:
      case ID_NAVIGATION:
      case ID_PAGE:
        return false;
    }
    return true;
  }

  /**
   * @return the view of this {@link UiController}. The view is the actual UI represented by a {@link UiWidget},
   *         typically a {@link io.github.mmm.ui.api.widget.UiRegularWidget regular widget}.
   */
  W getView();

  /**
   * Embeds the {@link UiController#getView() view} of the given child {@link UiController} into the
   * {@link UiEmbedding#getSlotId() specified slot} of this controllers {@link #getView() view}.
   *
   * @param embedding the {@link UiEmbedding#getSlotId() slotId} where to embed the given child {@link UiController}s
   *        {@link #getView() view}.
   * @param childController the child controller to embed.
   */
  void embed(UiEmbedding embedding, UiController<?> childController);

}
