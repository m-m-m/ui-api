/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget;

import io.github.mmm.event.EventSource;
import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.UiFlagMode;
import io.github.mmm.ui.datatype.UiStyles;
import io.github.mmm.ui.event.UiEvent;
import io.github.mmm.ui.event.UiEventListener;
import io.github.mmm.ui.widget.composite.UiComposite;

/**
 * Interface for an adapter to a physical <em>widget</em> of the underlying native widget toolkit. Anything displayed on
 * the UI <br>
 * A widget is any object of the UI (user interface) and may be atomic or {@link UiComposite composite}. <br>
 * {@link UiNativeWidget Native widgets} can be {@link UiContext#create(Class) created} via {@link UiContext} that has
 * implementations for all supported toolkits (technically via {@link io.github.mmm.ui.factory.UiWidgetFactoryNative}).
 * This way you can decide which native toolkit you like to use just by configuration and dependencies. <br>
 * If you want to make your UI code portable even for toolkits such as SWT, you need to make proper use of
 * {@link #dispose()} for all {@link UiWidget}s that are no longer needed what is generally a good idea. Further for
 * toolkits such as web (via TeaVM) there are strict limitations for the client-side code.<br>
 * <b>ATTENTION:</b><br>
 * A {@link UiWidget} can only be used once in a client application. Even if you want to have the exact same button
 * twice on the screen you need to create two distinct instances. <br>
 * <br>
 * For advanced usage see also {@link io.github.mmm.ui.widget.custom.UiCustomWidget}.
 *
 * @since 1.0.0
 */
public interface UiWidget extends EventSource<UiEvent, UiEventListener> {

  /** Use this character to compose hierarchical {@link #getId() IDs}. */
  String ID_SEPARATOR = "_";

  /**
   * This method gets the unique identifier of this object. <br>
   * <b>ATTENTION:</b><br>
   * In order to be compliant with all possible UI toolkit implementations, a valid ID has to fulfill ECMA-262, Section
   * 7.6. It is recommended to use IDs of the form <code>[a-zA-Z][a-zA-Z0-9_$]*</code>. Invalid IDs (e.g. containing
   * colon, hash or period) are not accepted to prevent you from later having problems with CSS selectors.
   *
   * @see #ID_SEPARATOR
   *
   * @return the ID of this object.
   */
  String getId();

  /**
   * This method set the {@link #getId() ID} of this object. Use this method to give the object a meaningful identifier
   * after creation. <br>
   * <b>ATTENTION:</b><br>
   * See JavaDoc of {@link #getId()} for the syntax constraints of IDs.
   *
   * @param id is the new {@link #getId() ID} for the object.
   */
  void setId(String id);

  /**
   * @return the owning {@link UiContext}.
   */
  UiContext getContext();

  /**
   * @return the {@link UiStyles} of this widget. Use to add or remove custom styles.
   */
  UiStyles getStyles();

  /**
   * @return {@code true} if enabled, {@code false} if disabled (end-user cannot interact with this widget or its
   *         children).
   */
  default boolean isEnabled() {

    return isEnabled(null);
  }

  /**
   * @param flagMode the {@link UiFlagMode} to check the enabled state of. May be {@code null} to check all modes
   *        including the {@link #getParent() parent} widget.
   * @return {@code true} if enabled, {@code false} if disabled (end-user cannot interact with this widget or its
   *         children).
   */
  boolean isEnabled(UiFlagMode flagMode);

  /**
   * @param enabled the new {@link #isEnabled() enabled state}. Use {@code true} to enable and {@code false} to disable
   *        this widget.
   */
  default void setEnabled(boolean enabled) {

    setEnabled(enabled, UiFlagMode.DEFAULT);
  }

  /**
   * @param enabled the new {@link #isEnabled() enabled state}. Use {@code true} to enable and {@code false} to disable
   *        this widget.
   * @param flagMode the {@link UiFlagMode} to modify.
   */
  void setEnabled(boolean enabled, UiFlagMode flagMode);

  /**
   * @return {@code true} if visible, {@code false} if hidden.
   * @see #isVisible(UiFlagMode)
   */
  default boolean isVisible() {

    return isVisible(null);
  }

  /**
   * @param flagMode the {@link UiFlagMode} to check the visibility of. May be {@code null} to check all modes including
   *        the {@link #getParent() parent} widget.
   * @return {@code true} if visible, {@code false} if hidden.
   */
  boolean isVisible(UiFlagMode flagMode);

  /**
   * @param visible {@code true} to show this widget (in case its parent is also visible), {@code false} to hide this
   *        widget.
   * @see #isVisible()
   */
  default void setVisible(boolean visible) {

    setVisible(visible, UiFlagMode.DEFAULT);
  }

  /**
   * @param visible {@code true} to show this widget (in case its parent is also visible), {@code false} to hide this
   *        widget.
   * @param flagMode the {@link UiFlagMode} to modify.
   * @see #isVisible()
   */
  void setVisible(boolean visible, UiFlagMode flagMode);

  /**
   * @return the parent of this widget or {@code null} if not attached to the UI or if this is a root widget (e.g.
   *         {@link io.github.mmm.ui.widget.window.UiMainWindow}).
   */
  UiComposite<?> getParent();

  /**
   * This method disposes this widget. It is detached from the UI and resources are deallocated. A disposed widget can
   * not be used or displayed anymore.
   */
  void dispose();

  /**
   * @return {@code true} if this widget has already been {@link #dispose() disposed} and became useless, {@code false}
   *         otherwise.
   */
  boolean isDisposed();

}
