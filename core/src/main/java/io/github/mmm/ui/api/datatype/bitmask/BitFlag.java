/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.datatype.bitmask;

/**
 * {@link RegularBitMask} for a flag (a single bit as {@link #getValue(int) value}).
 * <table border="1">
 * <tr>
 * <th>{@link #setFlag(int, boolean) Flag}</th>
 * <th>{@link #getValue(int) Value}</th>
 * </tr>
 * <tr>
 * <td>{@code true}</td>
 * <td>1</td>
 * </tr>
 * <tr>
 * <td>{@code false}</td>
 * <td>0</td>
 * </tr>
 * </table>
 *
 * @see #ofLsb(int)
 * @since 1.0.0
 */
public final class BitFlag extends RegularBitMask {

  /**
   * {@link BitFlag} to {@link #getFlag(int) test} if any flag is set. {@link #setFlag(int, boolean) Modifications} will
   * have no effect.
   */
  public static final BitFlag ANY = of(0);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 0}. */
  public static final BitFlag B00 = of(0x00000001);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 1}. */
  public static final BitFlag B01 = of(0x00000002);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 2}. */
  public static final BitFlag B02 = of(0x00000004);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 3}. */
  public static final BitFlag B03 = of(0x00000008);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 4}. */
  public static final BitFlag B04 = of(0x00000010);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 5}. */
  public static final BitFlag B05 = of(0x00000020);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 6}. */
  public static final BitFlag B06 = of(0x00000040);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 7}. */
  public static final BitFlag B07 = of(0x00000080);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 8}. */
  public static final BitFlag B08 = of(0x00000100);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 9}. */
  public static final BitFlag B09 = of(0x00000200);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 10}. */
  public static final BitFlag B10 = of(0x00000400);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 11}. */
  public static final BitFlag B11 = of(0x00000800);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 12}. */
  public static final BitFlag B12 = of(0x00001000);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 13}. */
  public static final BitFlag B13 = of(0x00002000);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 14}. */
  public static final BitFlag B14 = of(0x00004000);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 15}. */
  public static final BitFlag B15 = of(0x00008000);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 16}. */
  public static final BitFlag B16 = of(0x00010000);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 17}. */
  public static final BitFlag B17 = of(0x00020000);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 18}. */
  public static final BitFlag B18 = of(0x00040000);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 19}. */
  public static final BitFlag B19 = of(0x00080000);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 20}. */
  public static final BitFlag B20 = of(0x00100000);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 21}. */
  public static final BitFlag B21 = of(0x00200000);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 22}. */
  public static final BitFlag B22 = of(0x00400000);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 23}. */
  public static final BitFlag B23 = of(0x00800000);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 24}. */
  public static final BitFlag B24 = of(0x01000000);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 25}. */
  public static final BitFlag B25 = of(0x02000000);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 26}. */
  public static final BitFlag B26 = of(0x04000000);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 27}. */
  public static final BitFlag B27 = of(0x08000000);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 28}. */
  public static final BitFlag B28 = of(0x10000000);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 29}. */
  public static final BitFlag B29 = of(0x20000000);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 30}. */
  public static final BitFlag B30 = of(0x40000000);

  /** {@link BitFlag} for {@link #ofLsb(int) LSB} {@code 31}. */
  public static final BitFlag B31 = of(0x80000000);

  /**
   * {@link BitFlag} for to {@link #getFlag(int) test} if all flags/bits are set. {@link #setFlag(int, boolean)
   * Modifications} set all bits to {@code 0} or {@code 1} (~1).
   */
  public static final BitFlag ALL = of(-1);

  private static final BitFlag[] BITS = { B00, B01, B02, B03, B04, B05, B06, B07, B08, B09, B10, B11, B12, B13, B14,
  B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30, B31 };

  /**
   * The constructor.
   *
   * @param setMask the {@link #getSetMask() bit-mask to set value}.
   * @param clearMask the {@link #getClearMask() bit-mask to clear value}.
   */
  private BitFlag(int setMask, int clearMask) {

    super(setMask, clearMask);
  }

  @Override
  public int setFlag(int bits, boolean flag) {

    if (flag) {
      return bits | this.setMask;
    } else {
      return bits & this.clearMask;
    }
  }

  @Override
  public int getValue(int bits) {

    if (getFlag(bits)) {
      return 1;
    }
    return 0;
  }

  @Override
  public int setValue(int bits, int value) {

    if (value == 1) {
      return bits | this.setMask;
    } else if (value == 0) {
      return bits & this.clearMask;
    } else {
      throw new IllegalArgumentException(Integer.toString(value));
    }
  }

  private static BitFlag of(int setMask) {

    return new BitFlag(setMask, ~setMask);
  }

  /**
   * @param bitNumber the index of the bit starting from the first least significant bit (LSB) as {@code 0}.
   * @return a {@link BitFlag} with {@link #getSetMask() OR mask} set to {@code 1} shifted to the left by the given
   *         {@code bitNumber} ({@literal 1 << bitNumber}) and {@link #getClearMask() AND mask} set to the negation
   *         (~{@link #getSetMask()}).
   */
  public static BitFlag ofLsb(int bitNumber) {

    if ((bitNumber < 0) || (bitNumber >= BITS.length)) {
      throw new IllegalArgumentException(Integer.toString(bitNumber));
    }
    return BITS[bitNumber];
  }

  /**
   * ATTENTION: This method is only for very specific custom cases. Typically you should prefer using one of the
   * predefined constants of this class or {@link #ofLsb(int)}.
   *
   * @param setMask the {@link #getSetMask() bit-mask to set value}.
   * @param clearMask the {@link #getClearMask() bit-mask to clear value}.
   * @return the new {@link BitFlag}.
   */
  public static BitFlag ofSpecial(int setMask, int clearMask) {

    return new BitFlag(setMask, clearMask);
  }

}
