/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype.bitmask;

/**
 * {@link InverseBitMask} for a flag (a single bit as {@link #getValue(int) value}).
 * <table border="1">
 * <tr>
 * <th>{@link #setFlag(int, boolean) Flag}</th>
 * <th>{@link #getValue(int) Value}</th>
 * </tr>
 * <tr>
 * <td>{@code true}</td>
 * <td>0</td>
 * </tr>
 * <tr>
 * <td>{@code false}</td>
 * <td>1</td>
 * </tr>
 * </table>
 */
public class InverseBitFlag extends InverseBitMask {

  /**
   * {@link InverseBitFlag} to {@link #getFlag(int) test} if any flag is set. {@link #setFlag(int, boolean)
   * Modifications} will have no effect.
   */
  public static final InverseBitFlag ANY = of(0);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 0}. */
  public static final InverseBitFlag B00 = of(0x00000001);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 1}. */
  public static final InverseBitFlag B01 = of(0x00000002);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 2}. */
  public static final InverseBitFlag B02 = of(0x00000004);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 3}. */
  public static final InverseBitFlag B03 = of(0x00000008);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 4}. */
  public static final InverseBitFlag B04 = of(0x00000010);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 5}. */
  public static final InverseBitFlag B05 = of(0x00000020);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 6}. */
  public static final InverseBitFlag B06 = of(0x00000040);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 7}. */
  public static final InverseBitFlag B07 = of(0x00000080);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 8}. */
  public static final InverseBitFlag B08 = of(0x00000100);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 9}. */
  public static final InverseBitFlag B09 = of(0x00000200);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 10}. */
  public static final InverseBitFlag B10 = of(0x00000400);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 11}. */
  public static final InverseBitFlag B11 = of(0x00000800);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 12}. */
  public static final InverseBitFlag B12 = of(0x00001000);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 13}. */
  public static final InverseBitFlag B13 = of(0x00002000);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 14}. */
  public static final InverseBitFlag B14 = of(0x00004000);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 15}. */
  public static final InverseBitFlag B15 = of(0x00008000);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 16}. */
  public static final InverseBitFlag B16 = of(0x00010000);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 17}. */
  public static final InverseBitFlag B17 = of(0x00020000);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 18}. */
  public static final InverseBitFlag B18 = of(0x00040000);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 19}. */
  public static final InverseBitFlag B19 = of(0x00080000);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 20}. */
  public static final InverseBitFlag B20 = of(0x00100000);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 21}. */
  public static final InverseBitFlag B21 = of(0x00200000);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 22}. */
  public static final InverseBitFlag B22 = of(0x00400000);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 23}. */
  public static final InverseBitFlag B23 = of(0x00800000);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 24}. */
  public static final InverseBitFlag B24 = of(0x01000000);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 25}. */
  public static final InverseBitFlag B25 = of(0x02000000);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 26}. */
  public static final InverseBitFlag B26 = of(0x04000000);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 27}. */
  public static final InverseBitFlag B27 = of(0x08000000);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 28}. */
  public static final InverseBitFlag B28 = of(0x10000000);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 29}. */
  public static final InverseBitFlag B29 = of(0x20000000);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 30}. */
  public static final InverseBitFlag B30 = of(0x40000000);

  /** {@link InverseBitFlag} for {@link #ofLsb(int) LSB} {@code 31}. */
  public static final InverseBitFlag B31 = of(0x80000000);

  /**
   * {@link InverseBitFlag} for to {@link #getFlag(int) test} if all flags/bits are set. {@link #setFlag(int, boolean)
   * Modifications} set all bits to {@code 0} or {@code 1} (~1).
   */
  public static final InverseBitFlag ALL = of(-1);

  private static final InverseBitFlag[] BITS = { B00, B01, B02, B03, B04, B05, B06, B07, B08, B09, B10, B11, B12, B13,
  B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30, B31 };

  /**
   * The constructor.
   *
   * @param orMask the {@link #getSetMask() OR bit-mask}.
   * @param andMask the {@link #getClearMask() AND bit-mask}.
   */
  public InverseBitFlag(int orMask, int andMask) {

    super(orMask, andMask);
  }

  @Override
  public int setFlag(int bits, boolean flag) {

    if (flag) {
      return bits & this.clearMask;
    } else {
      return bits | this.setMask;
    }
  }

  @Override
  public int getValue(int bits) {

    if (getFlag(bits)) {
      return 0;
    }
    return 1;
  }

  @Override
  public int setValue(int bits, int value) {

    if (value == 0) {
      return bits & this.clearMask;
    } else if (value == 1) {
      return bits | this.setMask;
    } else {
      throw new IllegalArgumentException(Integer.toString(value));
    }
  }

  private static InverseBitFlag of(int orMask) {

    return new InverseBitFlag(orMask, ~orMask);
  }

  /**
   * @param bitNumber the index of the bit starting from the first least significant bit (LSB) as {@code 0}.
   * @return a {@link InverseBitFlag} with {@link #getSetMask() OR mask} set to {@code 1} shifted to the left by the
   *         given {@code bitNumber} ({@literal 1 << bitNumber}) and {@link #getClearMask() AND mask} set to the negation
   *         (~{@link #getSetMask()}).
   */
  public static InverseBitFlag ofLsb(int bitNumber) {

    if ((bitNumber < 0) || (bitNumber >= BITS.length)) {
      throw new IllegalArgumentException(Integer.toString(bitNumber));
    }
    return BITS[bitNumber];
  }

}
