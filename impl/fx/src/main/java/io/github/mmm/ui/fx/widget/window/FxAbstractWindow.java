/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.window;

import java.util.ArrayList;
import java.util.List;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.UiEnabledFlags;
import io.github.mmm.ui.datatype.UiLength;
import io.github.mmm.ui.event.UiHideEvent;
import io.github.mmm.ui.event.UiShowEvent;
import io.github.mmm.ui.fx.widget.FxWidgetObject;
import io.github.mmm.ui.widget.UiRegularWidget;
import io.github.mmm.ui.widget.window.UiAbstractWindow;
import io.github.mmm.ui.widget.window.UiPopup;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Implementation of {@link UiAbstractWindow} using JavaFx {@link Stage}.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxAbstractWindow<W extends Stage> extends FxWidgetObject<W> implements UiAbstractWindow {

  /** The {@link Stage#getScene() scene}. */
  protected final Scene scene;

  /** The optional {@link ScrollPane} if {@link #isScrollable() scrollable}. */
  protected final ScrollPane scrollPane;

  /** The composite where to add children. */
  protected final VBox composite;

  /** @see #getChild(int) */
  protected final List<UiRegularWidget> children;

  private String id;

  /**
   * The constructor.
   *
   * @param context the {@link UiContext}.
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxAbstractWindow(UiContext context, W widget) {

    super(context, widget);
    this.children = new ArrayList<>();
    this.composite = new VBox();
    if (isScrollable()) {
      this.scrollPane = new ScrollPane(this.composite);
      this.scene = new Scene(this.scrollPane);
    } else {
      this.scrollPane = null;
      this.scene = new Scene(this.composite);
    }
    widget.setScene(this.scene);
  }

  @Override
  protected boolean isVisibleWithoutRoot() {

    return true;
  }

  /**
   * @return {@code true} to use a {@link ScrollPane} and allow the content to scroll, {@code false} otherwise.
   */
  protected boolean isScrollable() {

    return (this instanceof UiPopup);
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.widget.setOnHidden(this::onHidden);
    this.widget.setOnShown(this::onShown);
  }

  private void onHidden(WindowEvent event) {

    fireEvent(new UiHideEvent(this, getProgrammaticEventType() == UiHideEvent.TYPE));
  }

  private void onShown(WindowEvent event) {

    fireEvent(new UiShowEvent(this, getProgrammaticEventType() == UiShowEvent.TYPE));
  }

  @Override
  public W getWidget() {

    return this.widget;
  }

  @Override
  public String getId() {

    return this.id;
  }

  @Override
  public void setId(String id) {

    this.id = id;
  }

  @Override
  protected void setVisibleNative(boolean visible) {

    if (visible) {
      this.widget.show();
    } else {
      this.widget.hide();
    }
  }

  @Override
  public String getTitle() {

    String title = this.widget.getTitle();
    if (title == null) {
      title = "";
    }
    return title;
  }

  @Override
  public void setTitle(String title) {

    this.widget.setTitle(title);
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    for (UiRegularWidget child : this.children) {
      child.setEnabled(enabled, UiEnabledFlags.PARENT);
    }
  }

  /**
   * @return the offset for the composite if internal widgets are on top.
   */
  protected int getChildOffset() {

    return 0;
  }

  @Override
  public int getChildCount() {

    return this.children.size();
  }

  @Override
  public UiRegularWidget getChild(int index) {

    if ((index < 0) || (index >= this.children.size())) {
      return null;
    }
    return this.children.get(index);
  }

  @Override
  public int getChildIndex(UiRegularWidget child) {

    if (child == null) {
      return -1;
    }
    return this.children.indexOf(child);
  }

  @Override
  public void addChild(UiRegularWidget child, int index) {

    setParent(child, this);
    if (index == -1) {
      index = this.children.size();
    }
    this.composite.getChildren().add(index + getChildOffset(), getTopNode(child));
    this.children.add(index, child);
  }

  @Override
  public UiRegularWidget removeChild(int index) {

    UiRegularWidget child = this.children.remove(index);
    this.composite.getChildren().remove(index + getChildOffset());
    setParent(child, null);
    return child;
  }

  @Override
  public double getX() {

    return this.widget.getX();
  }

  @Override
  public void setX(double x) {

    this.widget.setX(x);
  }

  @Override
  public double getY() {

    return this.widget.getY();
  }

  @Override
  public void setY(double y) {

    this.widget.setY(y);
  }

  @Override
  public UiLength getWidth() {

    return UiLength.ofPixel(this.widget.getWidth());
  }

  @Override
  public void setWidth(UiLength width) {

    this.widget.setWidth(width.toPixel(Screen.getPrimary().getVisualBounds().getWidth()));
  }

  @Override
  public UiLength getHeight() {

    return UiLength.ofPixel(this.widget.getHeight());
  }

  @Override
  public void setHeight(UiLength height) {

    this.widget.setHeight(height.toPixel(Screen.getPrimary().getVisualBounds().getHeight()));
  }

  @Override
  public boolean isMaximized() {

    return this.widget.isMaximized();
  }

  @Override
  public void setMaximized(boolean maximized) {

    this.widget.setMaximized(maximized);
  }

  @Override
  public boolean isResizable() {

    return this.widget.isResizable();
  }

  @Override
  public void setResizable(boolean resizable) {

    this.widget.setResizable(resizable);
  }

  @Override
  public boolean isClosable() {

    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void setClosable(boolean closable) {

    // TODO Auto-generated method stub

  }

  @Override
  public boolean isMovable() {

    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void setMovable(boolean movable) {

    // TODO Auto-generated method stub

  }

  @Override
  protected final void doDispose() {

    setVisible(false);
    super.doDispose();
    this.widget.setOnHidden(null);
    this.widget.setOnShown(null);
  }

}
