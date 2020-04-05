/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype;

/**
 * This enum contains the available units for size measures.
 *
 * @since 1.0.0
 */
// absolute units 1in = 2.54cm = 25.4mm = 72pt = 12pc
// for font-size ~ 1em = 12pt = 16px = 100%
public enum UiSizeUnit {

  /** Unit for pixels. */
  PIXEL("px", "pixel"),

  /** Unit for percent, relative to the parent container. At topmost the entire window. */
  PERCENT("%", "percent"),

  /** Unit for <em>em</em> meaning a factor relative to the current font-size. */
  EM("em", "font-size");

  /** @see #getArgb() */
  private final String key;

  /** @see #toString() */
  private final String title;

  /**
   * The constructor.
   *
   * @param value - see {@link #getArgb()}.
   * @param title - see {@link #toString()}.
   */
  private UiSizeUnit(String value, String title) {

    this.key = value;
    this.title = title;
  }

  /**
   * @return the shorthand key of this unit.
   */
  public String getKey() {

    return this.key;
  }

  /**
   * @return the display title of this unit (long form).
   */
  public String getTitle() {

    return this.title;
  }

  /**
   * Creates a new {@link UiSize} with this {@link UiSizeUnit} as {@link UiSize#getUnit() unit}.
   *
   * @param amount is the {@link UiSize#getAmount() amount}.
   * @return the new {@link UiSize}.
   */
  public UiSize newSize(double amount) {

    return new UiSize(amount, this);
  }

  @Override
  public String toString() {

    return this.key;
  }

}
