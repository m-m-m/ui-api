/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.tvm.widget.input;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.widget.input.UiComboBox;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiComboBox}.
 *
 * @since 1.0.0
 */
@SuppressWarnings("rawtypes")
public class TvmFactoryComboBoxDataList implements UiSingleWidgetFactoryNative<UiComboBox> {

  @Override
  public Class<UiComboBox> getType() {

    return UiComboBox.class;
  }

  @Override
  public UiComboBox create(UiContext context) {

    return new TvmComboBoxDataList(context);
  }

}
