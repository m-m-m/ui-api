/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.UiStyles;
import io.github.mmm.ui.widget.UiWidget;
import javafx.collections.ObservableList;
import javafx.css.Styleable;
import javafx.scene.Node;

/**
 * Implementation of {@link UiWidget} for JavaFx {@link Styleable}.
 *
 * @param <W> type of {@link #getNativeWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxWidgetStyleable<W extends Styleable> extends FxWidgetObject<W> implements FxStyleableWidget<W> {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param nativeWidget the {@link #getNativeWidget() JavaFx widget}.
   */
  public FxWidgetStyleable(UiContext context, W nativeWidget) {

    super(context, nativeWidget);
  }

  /**
   * @param widget the {@link UiWidget}.
   * @return the {@link #getNativeWidget() containing} JavaFx {@link Node}.
   */
  @Override
  protected Node getNode(UiWidget widget) {

    return ((FxWidgetNode<?>) widget).nativeWidget;
  }

  @Override
  protected UiStyles createStyles() {

    return new Styles(this.nativeWidget.getStyleClass());
  }

  private static class Styles implements UiStyles {

    private final ObservableList<String> styles;

    private Styles(ObservableList<String> styles) {

      super();
      this.styles = styles;
    }

    @Override
    public String get() {

      StringBuilder sb = new StringBuilder();
      String separator = "";
      for (String style : this.styles) {
        sb.append(separator);
        sb.append(style);
        separator = " ";
      }
      return sb.toString();
    }

    @Override
    public void set(String styles) {

      this.styles.clear();
      this.styles.addAll(styles.split(" "));
    }

    @Override
    public boolean add(String style) {

      if (this.styles.contains(style)) {
        return false;
      }
      return this.styles.add(style);
    }

    @Override
    public boolean remove(String style) {

      return this.styles.remove(style);
    }

    @Override
    public boolean contains(String style) {

      return this.styles.contains(style);
    }

    @Override
    public String getPrimary() {

      if (this.styles.isEmpty()) {
        return null;
      }
      return this.styles.get(0);
    }

    @Override
    public void setPrimary(String primaryStyle) {

      int index = this.styles.indexOf(primaryStyle);
      if (index == 0) {
        return;
      } else if (index > 0) {
        this.styles.remove(index);
      }
      this.styles.add(0, primaryStyle);
    }

  }

}