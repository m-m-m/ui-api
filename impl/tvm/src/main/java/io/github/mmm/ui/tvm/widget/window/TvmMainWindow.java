/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.window;

import org.teavm.jso.JSObject;
import org.teavm.jso.browser.Screen;
import org.teavm.jso.browser.Window;
import org.teavm.jso.dom.html.HTMLBodyElement;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.UiLength;
import io.github.mmm.ui.tvm.widget.menu.TvmMenuBar;
import io.github.mmm.ui.tvm.widget.panel.TvmVerticalPanel;
import io.github.mmm.ui.widget.UiRegularWidget;
import io.github.mmm.ui.widget.menu.UiMenuBar;
import io.github.mmm.ui.widget.window.UiMainWindow;

/**
 * Implementation of {@link UiMainWindow} for TeaVM.
 *
 * @since 1.0.0
 */
public class TvmMainWindow extends TvmAbstractWindow<Window> implements UiMainWindow {

  private final HTMLBodyElement body;

  private final TvmVerticalPanel content;

  private TvmMenuBar menuBar;

  private String id;

  private String title;

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public TvmMainWindow(UiContext context) {

    this(context, Window.current());
  }

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public TvmMainWindow(UiContext context, Window widget) {

    super(context, widget);
    this.body = widget.getDocument().getBody();
    this.content = new TvmVerticalPanel(context);
    setParent(this.content, this);
    this.body.appendChild(this.content.getTopWidget());
    this.title = "";
  }

  @Override
  protected boolean isVisibleWithoutRoot() {

    return true;
  }

  @Override
  public JSObject getTopWidget() {

    return this.body;
  }

  @Override
  public String getTitle() {

    return this.title;
  }

  @Override
  public void setTitle(String title) {

    if (title == null) {
      title = "";
    }
    this.title = title;
    this.widget.getDocument().getHead().setTitle(title);
  }

  @Override
  public double getX() {

    return this.widget.getScreenX();
  }

  @Override
  public double getY() {

    return this.widget.getScreenY();
  }

  @Override
  public void setX(double x) {

    // moving browser window is not supported
  }

  @Override
  public void setY(double y) {

    // moving browser window is not supported
  }

  @Override
  public UiLength getWidth() {

    return UiLength.ofPixel(this.widget.getOuterWidth());
  }

  @Override
  public void setWidth(UiLength width) {

    Screen screen = this.widget.getScreen();
    int w = (int) width.toPixel(screen.getAvailWidth());
    this.widget.resizeTo(w, this.widget.getOuterHeight());
  }

  @Override
  public UiLength getHeight() {

    return UiLength.ofPixel(this.widget.getOuterHeight());
  }

  @Override
  public void setHeight(UiLength height) {

    Screen screen = this.widget.getScreen();
    int h = (int) height.toPixel(screen.getAvailHeight());
    this.widget.resizeTo(this.widget.getOuterWidth(), h);
  }

  @Override
  public boolean isResizable() {

    return true;
  }

  @Override
  public void setResizable(boolean resizable) {

  }

  @Override
  public boolean isMovable() {

    return true;
  }

  @Override
  public void setMovable(boolean movable) {

  }

  @Override
  public boolean isClosable() {

    return true;
  }

  @Override
  public void setClosable(boolean closable) {

  }

  @Override
  public boolean isMaximized() {

    Screen screen = this.widget.getScreen();
    int widthLeft = screen.getAvailWidth() - this.widget.getOuterWidth();
    int heigthLeft = screen.getAvailHeight() - this.widget.getOuterHeight();
    return (widthLeft == 0) && (heigthLeft == 0);
  }

  @Override
  public void setMaximized(boolean maximized) {

    Screen screen = this.widget.getScreen();
    this.widget.resizeTo(screen.getAvailWidth(), screen.getAvailHeight());
  }

  @Override
  public int getChildCount() {

    return this.content.getChildCount();
  }

  @Override
  public UiRegularWidget getChild(int index) {

    return this.content.getChild(index);
  }

  @Override
  public int getChildIndex(UiRegularWidget child) {

    return this.content.getChildIndex(child);
  }

  @Override
  public void addChild(UiRegularWidget child, int index) {

    this.content.addChild(child, index);
  }

  @Override
  public UiRegularWidget removeChild(int index) {

    return this.content.removeChild(index);
  }

  @Override
  public String getId() {

    return this.id;
  }

  @Override
  public void setId(String id) {

    this.body.setAttribute("id", id);
  }

  @Override
  protected void setVisibleNative(boolean visible) {

    // hiding browser window is odd (bad UX) and therefore unsupported
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    // TODO Auto-generated method stub

  }

  @Override
  protected void setReadOnlyNative(boolean readOnly) {

  }

  @Override
  public UiMenuBar getMenuBar() {

    if (this.menuBar == null) {
      this.menuBar = new TvmMenuBar(this.context);
      insertFirst(this.body, this.menuBar.getTopWidget());
    }
    return this.menuBar;
  }

  @Override
  public boolean isWindowPositionAbsolute() {

    return false;
  }

}
