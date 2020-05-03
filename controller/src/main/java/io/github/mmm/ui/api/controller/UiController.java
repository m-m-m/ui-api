/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.controller;

import io.github.mmm.ui.api.attribute.AttributeReadId;
import io.github.mmm.ui.api.attribute.AttributeReadTitle;
import io.github.mmm.ui.api.attribute.AttributeReadVisible;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.api.widget.composite.UiMutableSingleComposite;

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
public interface UiController<W extends UiWidget> extends AttributeReadTitle, AttributeReadId, AttributeReadVisible {

  /**
   * {@link UiController#getType() Type} of the <em>root</em> {@link UiController}. This is the top-level
   * {@link UiController} of the application and holds the {@link io.github.mmm.ui.api.widget.window.UiMainWindow} as
   * {@link #getView() view}.
   */
  String TYPE_ROOT = "Root";

  /**
   * {@link UiController#getType() Type} of the <em>page</em> {@link UiController}. This is the first custom dialog that
   * defines the structure of the application. It is supposed to embed itself into the {@link #TYPE_ROOT root} page and
   * provide {@link #getSlot(String) slots} for child {@link UiController}s. At least a {@link #TYPE_MAIN main} slot
   * shall be present.
   */
  String TYPE_PAGE = "Page";

  /**
   * {@link UiController#getType() Type} of a <em>main</em> {@link UiController}. Its {@link #getView() view} is
   * supposed to be displayed in the main {@link #getSlot(String) slot} of the {@link #TYPE_PAGE page}
   * {@link UiController}.
   */
  String TYPE_MAIN = "Main";

  /**
   * {@link UiController#getType() Type} of a <em>header</em> {@link UiController}. Its {@link #getView() view} is
   * supposed to be displayed at the top {@link #getSlot(String) slot} of the {@link #TYPE_PAGE page}
   * {@link UiController} above {@link #TYPE_MAIN main}.
   */
  String TYPE_HEADER = "Header";

  /**
   * {@link UiController#getType() Type} of a <em>footer</em> {@link UiController}. Its {@link #getView() view} is
   * supposed to be displayed at the bottom {@link #getSlot(String) slot} of the {@link #TYPE_PAGE page}
   * {@link UiController} below {@link #TYPE_MAIN main}.
   */
  String TYPE_FOOTER = "Footer";

  /**
   * {@link UiController#getType() Type} of a <em>navigation</em> {@link UiController}. The navigation offers a
   * structured way for the user to navigate through the application. Typically it is displayed as a list or tree of
   * links beside the {@link #TYPE_MAIN main dialog} (typically on the left).
   */
  String TYPE_NAVIGATION = "Navigation";

  /**
   * {@link UiController#getType() Type} of a <em>side</em> {@link UiController}. Typically it is displayed on the right
   * of the {@link #TYPE_MAIN main} content area and shows additional information or a summary of the current state
   * (e.g. shopping cart). However, it may also be used to display advertisements.
   */
  String TYPE_SIDE = "Side";

  /** The {@link #getId() id} of the {@link #TYPE_ROOT root} {@link UiController}. */
  String ID_ROOT = "root";

  /** The {@link #getId() id} of the {@link #TYPE_PAGE page} {@link UiController}. */
  String ID_PAGE = "page";

  /** The {@link #getId() id} of the (default) {@link #TYPE_NAVIGATION navigation} {@link UiController}. */
  String ID_NAVIGATION = "nav";

  /** The {@link #getId() id} of the {@link #TYPE_MAIN main} {@link UiController} for the home page. */
  String ID_HOME = "home";

  /**
   * {@inheritDoc}
   *
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
   * @return the view of this {@link UiController}. The view is the actual UI represented by a {@link UiWidget},
   *         typically a {@link io.github.mmm.ui.api.widget.UiRegularWidget regular widget}.
   */
  W getView();

  /**
   * This method determines the type of this {@link UiController}. There are {@code TYPE_*} constants predefined here
   * for common types. However, you can simply create additional custom types for your needs.
   *
   * @see #TYPE_MAIN
   * @see #TYPE_HEADER
   * @see #TYPE_FOOTER
   * @see #TYPE_NAVIGATION
   * @see #TYPE_SIDE
   * @see #TYPE_ROOT
   *
   * @return the type of this {@link UiController}.
   */
  String getType();

  /**
   * @param slotId the {@link UiControllerSlot#getSlot() slot identifier}.
   * @return the {@link UiMutableSingleComposite} where to embed the {@link #getView() view} of a child
   *         {@link UiController} or {@code null} if no such slot is defined by this {@link UiController}.
   */
  default UiMutableSingleComposite<? extends UiRegularWidget> getSlot(String slotId) {

    return null;
  }
}
