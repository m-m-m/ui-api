/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.panel;

import io.github.mmm.ui.api.event.UiEvent;
import io.github.mmm.ui.api.event.action.UiAction;
import io.github.mmm.ui.api.event.action.UiActionCancel;
import io.github.mmm.ui.api.event.action.UiActionEdit;
import io.github.mmm.ui.api.event.action.UiActionReset;
import io.github.mmm.ui.api.event.action.UiActionSave;
import io.github.mmm.ui.api.widget.button.UiAbstractButton;
import io.github.mmm.ui.api.widget.button.UiButton;
import io.github.mmm.ui.api.widget.composite.UiCustomMutableComposite;

/**
 * {@link UiCustomMutableComposite Custom widget} for the {@link UiButtonPanel} of an
 * {@link io.github.mmm.ui.api.widget.value.UiCustomEditor editor}.
 *
 * @since 1.0.0
 */
public class UiCustomEditorButtonPanel extends UiCustomMutableComposite<UiAbstractButton, UiButtonPanel>
    implements UiButtonPanel {

  private final UiButton edit;

  private final UiButton save;

  private final UiButton reset;

  private final UiButton cancel;

  /**
   * The constructor.
   *
   * @param saveAction the {@link UiActionSave}.
   * @param resetAction the {@link UiActionReset}.
   * @param cancelAction the {@link UiActionCancel}.
   */
  public UiCustomEditorButtonPanel(UiActionSave saveAction, UiActionReset resetAction, UiAction cancelAction) {

    super(UiButtonPanel.of());
    UiActionEdit onEdit = this::onEdit;
    this.edit = UiButton.of(onEdit);
    this.delegate.addChild(this.edit);
    this.save = UiButton.of(saveAction);
    this.save.setVisible(false);
    this.delegate.addChild(this.save);
    this.reset = UiButton.of(resetAction);
    this.reset.setVisible(false);
    this.delegate.addChild(this.reset);
    this.cancel = UiButton.of(cancelAction);
    this.cancel.setVisible(false);
    this.delegate.addChild(this.cancel);
  }

  private void onEdit(UiEvent event) {

    setReadOnly(false);
  }

  @Override
  public void setReadOnly(boolean readOnly) {

    this.edit.setVisible(readOnly);
    this.save.setVisible(!readOnly);
    this.reset.setVisible(!readOnly);
    this.cancel.setVisible(!readOnly);
    super.setReadOnly(readOnly);
  }

}
