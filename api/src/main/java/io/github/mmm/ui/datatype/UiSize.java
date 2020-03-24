/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype;

import java.util.Objects;

/**
 * {@link UiSize} represents a width or height of a {@link io.github.mmm.ui.widget.UiWidget} or the size of a font.
 * Therefore it consists of two parts:
 * <ul>
 * <li>an {@link #getAmount() amount}</li>
 * <li>a {@link #getUnit() unit}</li>
 * </ul>
 *
 * Examples:
 * <table border="1">
 * <tr>
 * <th>{@link Object#toString() toString()}</th>
 * <th>{@link #getAmount()}</th>
 * <th>{@link #getUnit()}</th>
 * </tr>
 * <tr>
 * <td>12px</td>
 * <td>12.0</td>
 * <td>{@link UiSizeUnit#PIXEL}</td>
 * </tr>
 * <tr>
 * <td>100%</td>
 * <td>100.0</td>
 * <td>{@link UiSizeUnit#PERCENT}</td>
 * </tr>
 * <tr>
 * <td>0.8em</td>
 * <td>0.8</td>
 * <td>{@link UiSizeUnit#EM}</td>
 * </tr>
 * </table>
 *
 * @see UiSizeUnit#newSize(double)
 *
 * @since 1.0.0
 */
public class UiSize {

  private static final String STRING_AUTO = "auto";

  /** The auto {@link UiSize} (default). */
  public static final UiSize AUTO = new UiSize();

  /** The empty {@link UiSize}. */
  public static final UiSize ZERO = new UiSize(0, UiSizeUnit.PIXEL);

  /** The maximum {@link UiSize}. */
  public static final UiSize MAX = new UiSize(Double.MAX_VALUE, UiSizeUnit.PIXEL);

  /** The full {@link UiSize} as "100%". */
  public static final UiSize FULL = new UiSize(100, UiSizeUnit.PERCENT);

  /** @see #getAmount() */
  private final double amount;

  /** @see #getUnit() */
  private final UiSizeUnit unit;

  /**
   * The constructor.
   */
  private UiSize() {

    super();
    this.unit = null;
    this.amount = 0;
  }

  /**
   * The constructor.
   *
   * @param value is the {@link #getAmount() value}.
   * @param unit is the {@link #getUnit() unit}.
   */
  public UiSize(double value, UiSizeUnit unit) {

    super();
    Objects.requireNonNull(unit, "unit");
    this.unit = unit;
    this.amount = value;
  }

  /**
   * The constructor.
   *
   * @param size is the {@link Object#toString() string representation} of the {@link UiSize} to create.
   */
  private UiSize(String size) {

    super();
    Objects.requireNonNull(size, "size");
    UiSizeUnit newUnit = null;
    double newAmount = 0;
    for (UiSizeUnit sizeUnit : UiSizeUnit.values()) {
      String unitString = sizeUnit.getKey();
      if (size.endsWith(unitString)) {
        newUnit = sizeUnit;
        String amountString = size.substring(0, size.length() - unitString.length());
        newAmount = Double.parseDouble(amountString);
      }
    }
    if ((newUnit == null) && !STRING_AUTO.equals(size)) {
      throw new IllegalArgumentException(size);
    }
    this.amount = newAmount;
    this.unit = newUnit;
  }

  /**
   * This method gets the value (amount) of this size. Is to be interpreted in the according {@link #getUnit() unit}.
   *
   * @return the actual value of this {@link UiSize}.
   */
  public double getAmount() {

    return this.amount;
  }

  /**
   * @return the {@link UiSizeUnit}.
   */
  public UiSizeUnit getUnit() {

    return this.unit;
  }

  /**
   * @param fullscreenSize the maximum size for fullscreen (100%).
   * @return the {@link #getAmount() amount} converted to {@link UiSizeUnit#PIXEL}.
   */
  public double toPixel(double fullscreenSize) {

    switch (this.unit) {
      case PIXEL:
        return this.amount;
      case EM:
        return this.amount * 16.0;
      case PERCENT:
        return (this.amount * fullscreenSize) / 100.0;
      default:
        return fullscreenSize;
    }
  }

  /**
   * @return {@code true} if {@link #AUTO}, {@code false} otherwise.
   */
  public boolean isAuto() {

    return (this == AUTO);
  }

  @Override
  public String toString() {

    if (this.unit == null) {
      return STRING_AUTO;
    }
    return Double.toString(this.amount) + this.unit.getKey();
  }

  /**
   * @param size is the {@link Object#toString() string representation} of the size.
   * @return the new {@link UiSize}.
   */
  public static UiSize of(String size) {

    if (size == null) {
      return null;
    }
    if (STRING_AUTO.equals(size)) {
      return AUTO;
    }
    return new UiSize(size);
  }

  /**
   * Creates a new {@link UiSize} with {@link UiSizeUnit#PERCENT}.
   *
   * @param amount is the {@link #getAmount() amount}.
   * @return the new {@link UiSize}.
   */
  public static UiSize ofPercent(double amount) {

    return UiSizeUnit.PERCENT.newSize(amount);
  }

  /**
   * Creates a new {@link UiSize} with {@link UiSizeUnit#PERCENT}.
   *
   * @param amount is the {@link #getAmount() amount}.
   * @return the new {@link UiSize}.
   */
  public static UiSize ofPixel(double amount) {

    return UiSizeUnit.PIXEL.newSize(amount);
  }

  /**
   * @param size the {@link UiSize} to get. May be {@code null}.
   * @return the given {@link UiSize size} or {@link #AUTO} instead of {@code null}.
   */
  public static UiSize getSafe(UiSize size) {

    if (size == null) {
      return AUTO;
    }
    return size;
  }

}
