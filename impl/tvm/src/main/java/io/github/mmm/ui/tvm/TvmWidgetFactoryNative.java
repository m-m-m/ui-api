/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm;

import java.util.HashMap;
import java.util.Map;

import org.teavm.jso.JSBody;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.factory.UiWidgetFactoryNative;
import io.github.mmm.ui.tvm.widget.button.TvmFactoryButton;
import io.github.mmm.ui.tvm.widget.input.TvmFactoryCheckbox;
import io.github.mmm.ui.tvm.widget.input.TvmFactoryTextInput;
import io.github.mmm.ui.tvm.widget.panel.TvmFactoryVerticalPanel;
import io.github.mmm.ui.widget.UiNativeWidget;

/**
 *
 */
public class TvmWidgetFactoryNative implements UiWidgetFactoryNative {

  private final Map<Class<?>, UiSingleWidgetFactoryNative<?>> factoryMap;

  /**
   * The constructor.
   */
  public TvmWidgetFactoryNative() {

    super();
    this.factoryMap = new HashMap<>();
    registerFactory(new TvmFactoryButton());
    registerFactory(new TvmFactoryCheckbox());
    registerFactory(new TvmFactoryTextInput());
    registerFactory(new TvmFactoryVerticalPanel());
  }

  private void registerFactory(UiSingleWidgetFactoryNative<?> factory) {

    UiSingleWidgetFactoryNative<?> duplicate = this.factoryMap.putIfAbsent(factory.getWidgetInterface(), factory);
    if (duplicate != null) {
      throw new IllegalStateException("Duplicate factory " + factory.getClass().getName() + " and "
          + duplicate.getClass().getName() + " for " + factory.getWidgetInterface().getName());
    }
  }

  @Override
  public <W extends UiNativeWidget> W create(Class<W> widgetInterface, boolean required, UiContext context) {

    UiSingleWidgetFactoryNative<?> factory = this.factoryMap.get(widgetInterface);
    if (factory == null) {
      if (!required) {
        return null;
      }
      log(widgetInterface.getName());
      throw new UnsupportedOperationException(widgetInterface.getName());
    }
    return (W) factory.create(context);
  }

  @JSBody(params = { "message" }, script = "console.log(message)")
  public static native void log(String message);

}
