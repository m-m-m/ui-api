/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype;

/**
 *
 */
public class UiFlagMode {

  /** {@link UiFlagMode} to {@link #isSet(long) check} if any flag is set. */
  public static final UiFlagMode ANY = new UiFlagMode(0);

  /** {@link UiFlagMode} used by default. */
  public static final UiFlagMode DEFAULT = new UiFlagMode(1);

  /**
   * {@link UiFlagMode} reserved for the {@link io.github.mmm.ui.widget.UiWidget#getParent() parent}. E.g. a virtual
   * composite may change its {@link io.github.mmm.ui.widget.UiWidget#isVisible() visibility} by changing the visibility
   * of its children using this mode.
   */
  public static final UiFlagMode PARENT = new UiFlagMode(2);

  /** {@link UiFlagMode} reserved for toggling view/edit mode. */
  public static final UiFlagMode EDIT = new UiFlagMode(4);

  /**
   * {@link UiFlagMode} reserved for authorization. Applications typically hide {@link io.github.mmm.ui.widget.UiWidget
   * widgets} (especially buttons) if the user does not have a general permission to invoke the underlying action. Also
   * widgets get disabled, if the user does not have permissions to invoke them for the current data. In such cases this
   * {@link UiFlagMode} shall be used. Please note for security the backend service needs to also perform the
   * authorization and fail if not permitted. The hiding or disabling of widgets is only for usability.
   */
  public static final UiFlagMode AUTHORIZATION = new UiFlagMode(8);

  /** {@link UiFlagMode} to {@link #set(long, boolean) set} all flags at once. */
  public static final UiFlagMode ALL = new UiFlagMode(-1);

  /** {@link UiFlagMode} for local flags (all except {@link #PARENT}). */
  public static final UiFlagMode LOCAL = new UiFlagMode(~PARENT.mask);

  private final long mask;

  /**
   * The constructor.
   *
   * @param mask the {@link #getMask() bit-mask}.
   */
  public UiFlagMode(long mask) {

    super();
    this.mask = mask;
  }

  /**
   * @return the bit-mask of this flag mode. Typically only a single bit shall be set.
   */
  public long getMask() {

    return this.mask;
  }

  /**
   * @param status the current status.
   * @param flag {@code true} to set this {@link UiFlagMode} in the status, {@code false} to unset it.
   * @return the new status with the {@link UiFlagMode} set to the given {@code flag}.
   */
  public long set(long status, boolean flag) {

    if (flag) {
      return status & ~this.mask;
    } else {
      return status | this.mask;
    }
  }

  /**
   * @param status the current status.
   * @return {@code true} if this {@link UiFlagMode} is current set in the status, {@code false} otherwise.
   */
  public boolean isSet(long status) {

    return ((status | this.mask) == status);
  }

}
