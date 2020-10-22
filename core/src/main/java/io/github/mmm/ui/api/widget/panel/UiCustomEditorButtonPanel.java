/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.widget.panel;

import io.github.mmm.ui.api.attribute.AttributeWriteReadOnly;
import io.github.mmm.ui.api.event.UiEvent;
import io.github.mmm.ui.api.event.action.UiActionDiscard;
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

  private final UiButton discard;

  private final AttributeWriteReadOnly editor;

  /**
   * The constructor.
   *
   * @param saveAction the {@link UiActionSave}.
   * @param resetAction the {@link UiActionReset}.
   * @param discardAction the {@link UiActionDiscard}.
   * @param editor the editor widget implementing {@link AttributeWriteReadOnly}.
   */
  public UiCustomEditorButtonPanel(UiActionSave saveAction, UiActionReset resetAction, UiActionDiscard discardAction,
      AttributeWriteReadOnly editor) {

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
    this.discard = UiButton.of(discardAction);
    this.discard.setVisible(false);
    this.delegate.addChild(this.discard);
    this.editor = editor;
  }

  private void onEdit(UiEvent event) {

    this.editor.setReadOnly(false);
  }

  @Override
  public void setReadOnly(boolean readOnly) {

    this.edit.setVisible(readOnly);
    this.save.setVisible(!readOnly);
    this.reset.setVisible(!readOnly);
    this.discard.setVisible(!readOnly);
    super.setReadOnly(readOnly);
  }

  @Override
  public void setReadOnlyFixed(Boolean readOnlyFixed) {

    if (readOnlyFixed != null) {
      this.edit.setVisible(false);
      this.discard.setVisible(false);
    }
    super.setReadOnlyFixed(readOnlyFixed);
  }

}
