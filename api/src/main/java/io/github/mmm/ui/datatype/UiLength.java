/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype;

import java.util.Objects;

/**
 * {@link UiLength} represents a width or height of a {@link io.github.mmm.ui.widget.UiWidget}. Therefore it consists of
 * two parts:
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
 * <td>{@link UiLengthUnit#PIXEL}</td>
 * </tr>
 * <tr>
 * <td>100%</td>
 * <td>100.0</td>
 * <td>{@link UiLengthUnit#PERCENT}</td>
 * </tr>
 * <tr>
 * <td>0.8em</td>
 * <td>0.8</td>
 * <td>{@link UiLengthUnit#EM}</td>
 * </tr>
 * </table>
 *
 * @see UiLengthUnit#newLength(double)
 *
 * @since 1.0.0
 */
public class UiLength {

  private static final String AUTO = "auto";

  /** The empty {@link UiLength}. */
  public static final UiLength ZERO = new UiLength(0, UiLengthUnit.PIXEL);

  /** The maximum {@link UiLength}. */
  public static final UiLength MAX = new UiLength(Double.MAX_VALUE, UiLengthUnit.PIXEL);

  /** The full {@link UiLength} as "100%". */
  public static final UiLength FULL = new UiLength(100, UiLengthUnit.PERCENT);

  /** @see #getAmount() */
  private final double amount;

  /** @see #getUnit() */
  private final UiLengthUnit unit;

  /**
   * The constructor.
   *
   * @param value is the {@link #getAmount() value}.
   * @param unit is the {@link #getUnit() unit}.
   */
  public UiLength(double value, UiLengthUnit unit) {

    super();
    Objects.requireNonNull(unit, "unit");
    this.unit = unit;
    this.amount = value;
  }

  /**
   * The constructor.
   *
   * @param size is the {@link Object#toString() string representation} of the {@link UiLength} to create.
   */
  public UiLength(String size) {

    super();
    Objects.requireNonNull(size, "size");
    UiLengthUnit lengthUnit = null;
    double lengthAmount = 0;
    for (UiLengthUnit sizeUnit : UiLengthUnit.values()) {
      String unitString = sizeUnit.getKey();
      if (size.endsWith(unitString)) {
        lengthUnit = sizeUnit;
        String amountString = size.substring(0, size.length() - unitString.length());
        lengthAmount = Double.parseDouble(amountString);
      }
    }
    if ((lengthUnit == null) && !AUTO.equals(size)) {
      throw new IllegalArgumentException(size);
    }
    this.amount = lengthAmount;
    this.unit = lengthUnit;
  }

  /**
   * This method gets the value (amount) of this size. Is to be interpreted in the according {@link #getUnit() unit}.
   *
   * @return the actual value of this {@link UiLength}.
   */
  public double getAmount() {

    return this.amount;
  }

  /**
   * @return the {@link UiLengthUnit}.
   */
  public UiLengthUnit getUnit() {

    return this.unit;
  }

  /**
   * @param fullscreenLength the maximum length/width for fullscreen (100%).
   * @return the {@link #getAmount() amount} converted to {@link UiLengthUnit#PIXEL}.
   */
  public double toPixel(double fullscreenLength) {

    switch (this.unit) {
      case PIXEL:
        return this.amount;
      case EM:
        return this.amount * 16.0;
      case PERCENT:
        return (this.amount * fullscreenLength) / 100.0;
      default:
        throw new IllegalStateException(this.unit.toString());
    }
  }

  @Override
  public String toString() {

    if (this.unit == null) {
      return AUTO;
    }
    return Double.toString(this.amount) + this.unit.getKey();
  }

  /**
   * Creates a new {@link UiLength} with {@link UiLengthUnit#PERCENT}.
   *
   * @param amount is the {@link #getAmount() amount}.
   * @return the new {@link UiLength}.
   */
  public static UiLength ofPercent(double amount) {

    return UiLengthUnit.PERCENT.newLength(amount);
  }

  /**
   * Creates a new {@link UiLength} with {@link UiLengthUnit#PERCENT}.
   *
   * @param amount is the {@link #getAmount() amount}.
   * @return the new {@link UiLength}.
   */
  public static UiLength ofPixel(double amount) {

    return UiLengthUnit.PIXEL.newLength(amount);
  }

}
