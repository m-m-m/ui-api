/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype;

import io.github.mmm.ui.datatype.bitmask.BitMask;
import io.github.mmm.ui.datatype.bitmask.InverseBitFlag;
import io.github.mmm.ui.datatype.bitmask.InverseBitMask;

/**
 * {@link BitMask} constants for {@link io.github.mmm.ui.widget.UiWidget#setEnabled(boolean, BitMask)}.
 *
 * @since 1.0.0
 */
public interface UiEnabledFlags {

  /** @see InverseBitFlag#ANY */
  InverseBitMask ANY = InverseBitFlag.ANY;

  /** {@link InverseBitMask} used by default. */
  InverseBitMask DEFAULT = InverseBitFlag.B00;

  /**
   * {@link InverseBitMask} reserved for the {@link io.github.mmm.ui.widget.UiWidget#getParent() parent}. E.g. a virtual
   * {@link io.github.mmm.ui.widget.composite.UiComposite} may change its
   * {@link io.github.mmm.ui.widget.UiWidget#setVisible(boolean) visibility} by
   * {@link io.github.mmm.ui.widget.UiWidget#setVisible(boolean, BitMask) changing the visibility using this mask} for
   * of all its {@link io.github.mmm.ui.widget.composite.UiComposite#getChild(int) children}.
   */
  InverseBitMask PARENT = InverseBitFlag.B01;

  /**
   * {@link InverseBitMask} reserved for {@link io.github.mmm.ui.widget.UiWidget#setReadOnly(boolean) read-only} e.g. if
   * {@link io.github.mmm.ui.widget.input.UiInput input widgets} do not support read-only natively.
   */
  InverseBitMask READ_ONLY = InverseBitFlag.B02;

  /**
   * {@link InverseBitMask} reserved for authorization. Applications typically disable
   * {@link io.github.mmm.ui.widget.UiWidget widgets} (typically buttons), if the user does not have permissions to
   * invoke them for the current data. In such cases this {@link BitMask} shall be used. Please note for security the
   * backend service needs to also perform the authorization and fail if not permitted. The hiding or disabling of
   * widgets is only for usability.
   */
  InverseBitMask AUTHORIZATION = InverseBitFlag.B03;

  /** @see InverseBitFlag#ALL */
  InverseBitMask ALL = InverseBitFlag.ALL;
  //
  // /** {@link BitMask} for local flags (all except {@link #PARENT}). */
  // public static final BitMask LOCAL = ofInverseFlag(~PARENT.orMask);

}
