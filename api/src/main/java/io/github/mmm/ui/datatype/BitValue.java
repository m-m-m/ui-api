/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype;

/**
 * {@link RegularBitMask} for a {@link #getValue(int) value} of multiple bit of information.<br>
 *
 * @see BitValueBoolean
 * @since 1.0.0
 */
public class BitValue extends RegularBitMask {

  private final int maxValue;

  private final int shift;

  /**
   * The constructor.
   *
   * @param orMask the {@link #getSetMask() OR bit-mask}.
   * @param andMask the {@link #getClearMask() AND bit-mask}.
   */
  BitValue(int orMask, int andMask, int shift, int maxValue) {

    super(orMask, andMask);
    this.shift = shift;
    this.maxValue = maxValue;
  }

  @Override
  public int setFlag(int bits, boolean flag) {

    if (flag) {
      return (bits & this.clearMask) | this.setMask;
    } else {
      return bits & this.clearMask;
    }
  }

  @Override
  public int setValue(int bits, int value) {

    if ((value < 0) || (value > this.maxValue)) {
      throw new IllegalArgumentException(Integer.toString(value));
    }
    return (bits & this.clearMask) | (value << this.shift);
  }

  @Override
  public int getValue(int bits) {

    return (bits & ~this.clearMask) >> this.shift;
  }

  /**
   * @param valueBits the number of bits for the {@link #getValue(int) value}. Should be at least {@code 2}.
   * @param shift the number of bits to shift the value to the left.
   * @return the {@link BitValue}.
   */
  public static BitValue ofValue(int valueBits, int shift) {

    int maxValue = BitFlag.ofLsb(valueBits).getSetMask() - 1;
    int orMask = maxValue << shift;
    return new BitValue(orMask, ~orMask, shift, maxValue);
  }
}
