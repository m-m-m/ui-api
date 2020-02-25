/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype;

/**
 *
 */
public class UiValidState {

  private boolean setFocus;

  private int validCount;

  private int invalidCount;

  /**
   * The constructor.
   */
  public UiValidState() {

    super();
    this.validCount = 0;
    this.invalidCount = 0;
    this.setFocus = true;
  }

  /**
   * @return the number of successful validations.
   */
  public int getValidCount() {

    return this.validCount;
  }

  /**
   * @return the number of unsuccessful validations.
   */
  public int getInvalidCount() {

    return this.invalidCount;
  }

  /**
   * @return the total number of validation attempts.
   */
  public int getTotalCount() {

    return this.validCount + this.invalidCount;
  }

  /**
   * @return the success rate of the validation attempts (will be {@code 1} if 100% of the validations have been
   *         successful, {@code 0.5} for 50%, or {@code 0} if all validations failed).
   */
  public double getSuccessRate() {

    if (this.invalidCount == 0) {
      return 1;
    }
    int total = this.validCount + this.invalidCount;
    return this.validCount / total;
  }

  /**
   * @return {@code true} if valid (initial state), {@code false} otherwise (after {@link #notify(boolean)
   *         notify(false)} was called).
   */
  public boolean isValid() {

    return this.invalidCount == 0;
  }

  /**
   * Notifies about the result of a single validation.
   *
   * @param valid {@code true} for a successful validation, {@code false} otherwise (a validation failure occurred).
   */
  public void notify(boolean valid) {

    if (valid) {
      this.validCount++;
    } else {
      this.invalidCount++;
    }
  }

  /**
   * @return {@code true} if the focus should be set in the first invalid widget, {@code false} otherwise (after
   *         {@link #setFocussed()} was called).
   */
  public boolean isSetFocus() {

    return this.setFocus;
  }

  /**
   * Sets {@link #isSetFocus()} to {@code false}. Should be called after the focus has been set into the first focusable
   * widget that is invalid. May also be called initially after creating this {@link UiValidState} to prevent setting
   * the focus into the first invalid widget.
   */
  public void setFocussed() {

    this.setFocus = false;
  }

}
