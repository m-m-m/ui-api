/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.datatype.bitmask;

/**
 *
 */
public abstract class RegularBitMask extends BitMask {

  /**
   * The constructor.
   *
   * @param orMask the {@link #getSetMask() OR bit-mask}.
   * @param andMask the {@link #getClearMask() AND bit-mask}.
   */
  protected RegularBitMask(int orMask, int andMask) {

    super(orMask, andMask);
  }

  @Override
  public final boolean isInverse() {

    return false;
  }

  @Override
  public boolean getFlag(int bits) {

    if (this.setMask == 0) {
      return bits != 0;
    }
    return ((bits & this.setMask) == this.setMask);
  }

  /**
   * @param valueBits the number of bits for the {@link #getValue(int) value}. Use {@code 1} for {@link BitFlag} and
   *        more for {@link BitValue}.
   * @param shift the number of bits to shift the value to the left.
   * @return the {@link RegularBitMask}.
   */
  public static RegularBitMask of(int valueBits, int shift) {

    if ((valueBits <= 0) || (valueBits >= 32)) {
      throw new IllegalArgumentException("valueBits=" + valueBits);
    }
    if ((shift < 0) || (shift >= 31)) {
      throw new IllegalArgumentException("shift=" + shift);
    }
    int bits = valueBits + shift;
    if (bits >= 32) {
      throw new IllegalArgumentException("bits=" + bits);
    }
    if (valueBits == 1) {
      return BitFlag.ofLsb(shift);
    } else {
      return BitValue.ofValue(valueBits, shift);
    }
  }

}
