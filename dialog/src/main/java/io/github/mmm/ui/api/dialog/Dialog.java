/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.dialog;

import io.github.mmm.ui.api.attribute.AttributeReadId;
import io.github.mmm.ui.api.attribute.AttributeReadTitle;

/**
 * This is the interface for a dialog of the client application. It displays itself in the page of the main application
 * window. It is a singleton instance that is addressed via a {@link DialogPlace}. A {@link Dialog} is not a
 * {@link io.github.mmm.ui.api.widget.UiWidget} should NOT be mixed with a
 * {@link io.github.mmm.ui.api.widget.window.UiAbstractWindow winodw} or {@link io.github.mmm.ui.api.widget.window.UiPopup
 * popup}.
 *
 * @since 1.0.0
 */
public interface Dialog extends AttributeReadTitle, AttributeReadId {

  /** The regex pattern {@link #getId() dialog IDs} have to match. */
  String PATTERN_DIALOG_ID = "[^:;=?&\\s/\\\\]+";

  /**
   * The {@link Dialog#getType() type} of the <em>root</em> dialog. This is the top-level dialog of the application and
   * represents the {@link net.sf.mmm.client.ui.api.widget.window.UiWidgetMainWindow}.
   *
   * @see net.sf.mmm.client.ui.base.dialog.root.RootDialogController
   */
  String TYPE_ROOT = "Root";

  /**
   * The {@link Dialog#getType() type} of the <em>page</em> dialog. This is the first custom dialog that defines the
   * structure of the application page (main window). It is supposed to embed itself into the {@link #TYPE_ROOT root}
   * page and provide {@link net.sf.mmm.client.ui.base.dialog.DialogSlot slots} for child dialogs, at least a
   * {@link #TYPE_MAIN main} slot. For an example see {@link net.sf.mmm.client.ui.base.dialog.DialogController}.
   *
   * @see net.sf.mmm.client.ui.base.dialog.page.AbstractPageDialogController
   */
  String TYPE_PAGE = "Page";

  /**
   * The {@link Dialog#getType() type} of a <em>main</em> dialog. This is a regular dialog displayed in the main content
   * area of the client application window.
   */
  String TYPE_MAIN = "Main";

  /**
   * The {@link Dialog#getType() type} of a <em>header</em> dialog. This is a dialog displayed at the top of the main
   * content area of the client application window above a {@link #TYPE_MAIN main dialog}.
   */
  String TYPE_HEADER = "Header";

  /**
   * The {@link Dialog#getType() type} of a <em>footer</em> dialog. This is a dialog displayed at the bottom of the main
   * content area of the client application window below a {@link #TYPE_MAIN main dialog}.
   */
  String TYPE_FOOTER = "Footer";

  /**
   * The {@link Dialog#getType() type} of a <em>navigation</em> dialog. The navigation offers a structured way for the
   * user to navigate through the application. This can happen in form of a menu-bar that is typically placed below the
   * {@link #TYPE_HEADER header} and above the {@link #TYPE_MAIN main dialog}. However it is often realized as a list or
   * tree of links that is displayed beside the {@link #TYPE_MAIN main dialog} (typically on the left).
   */
  String TYPE_NAVIGATION = "Navigation";

  /**
   * The {@link Dialog#getType() type} of a <em>side</em> dialog. This is a dialog typically displayed at on the right
   * of the main content area of the client application window beside a {@link #TYPE_MAIN main dialog}. It typically
   * shows additional information or a summary of the current state (e.g. shopping cart). However, it may also be used
   * to display advertisements.
   */
  String TYPE_SIDE = "Side";

  /** The {@link Dialog#getId() dialog-id} of the {@link #TYPE_ROOT root} dialog. */
  String DIALOG_ID_ROOT = "root";

  /** The {@link Dialog#getId() dialog-id} of the {@link #TYPE_PAGE page} dialog. */
  String DIALOG_ID_PAGE = "page";

  /** The {@link Dialog#getId() dialog-id} of the (default) {@link #TYPE_NAVIGATION navigation} dialog. */
  String DIALOG_ID_NAVIGATION = "nav";

  @Override
  String getTitle();

  /**
   * {@inheritDoc}
   *
   * The ID of a dialog should only contain ASCII letters, Latin digits, hyphens or underscores. It must NOT contain
   * ':', ';', '&', '?', '=', '/', '\\' or ' '.
   *
   * @see DialogConstants#DIALOG_ID_ROOT
   * @see DialogConstants#DIALOG_ID_PAGE
   * @see DialogConstants#DIALOG_ID_HOME
   */
  @Override
  String getId();

  /**
   * This method determines the type of this {@link Dialog}. There are predefined <code>TYPE_*</code> constants for
   * common types in {@link DialogConstants}. However, you can simply create additional custom types for your needs.
   *
   * @see DialogConstants#TYPE_MAIN
   * @see DialogConstants#TYPE_HEADER
   * @see DialogConstants#TYPE_FOOTER
   * @see DialogConstants#TYPE_NAVIGATION
   * @see DialogConstants#TYPE_SIDE
   * @see DialogConstants#TYPE_ROOT
   *
   * @return the type of this {@link Dialog}.
   */
  String getType();
}
