/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype.bitmask;

/**
 * {@link BitValue} that encodes a a {@link Boolean} that unlike {@code boolean} may also be {@code null}. Therefore it
 * can not be encoded into a single bit using {@link BitFlag}.
 *
 * <pre>
 * private static final int SHIFT = 5;
 * public static final {@link BitValueBoolean} MY_BOOLEAN_VALUE = {@link BitValueBoolean}.{@link #ofBoolean(int) of}(SHIFT);
 *
 * // SHIFT is 5 so our int bits are xxxxxxxxxxxxxxxxxxxxxxxxxABxxxxx with A=1 -> Boolean is not null, B=Boolean value
 * // the x bits are free for other BitMasks
 * int bits = getBits();
 * Boolean booleanValue = getBooleanValue();
 * // set Boolean value
 * bits = MY_BOOLEAN_VALUE.setBoolean(bits, booleanValue);
 * // ...
 *
 * // get Boolean value
 * booleanValue = MY_BOOLEAN_VALUE.getBoolean(bits);
 * </pre>
 *
 * @see #ofBoolean(int)
 * @since 1.0.0
 */
public final class BitValueBoolean extends BitValue {

  /** {@link #getValue(int) Value} for {@code null}. */
  public static final int VALUE_BOOLEAN_NULL = 0;

  /** {@link #getValue(int) Value} for {@link Boolean#FALSE}. */
  public static final int VALUE_BOOLEAN_FALSE = 2;

  /** {@link #getValue(int) Value} for {@link Boolean#TRUE}. */
  public static final int VALUE_BOOLEAN_TRUE = 3;

  /**
   * The constructor.
   *
   * @param orMask the {@link #getSetMask() OR bit-mask}.
   * @param andMask the {@link #getClearMask() AND bit-mask}.
   */
  private BitValueBoolean(int orMask, int andMask, int shift) {

    super(orMask, andMask, shift, 3);
  }

  /**
   * @param bits the current bits representing an encoded state of multiple {@link BitMask}s.
   * @return the decoded {@link Boolean} value.
   */
  public Boolean getBoolean(int bits) {

    int value = getValue(bits);
    if (value == VALUE_BOOLEAN_TRUE) {
      return Boolean.TRUE;
    } else if (value == VALUE_BOOLEAN_FALSE) {
      return Boolean.FALSE;
    }
    return null;
  }

  /**
   * @param bits the current bits representing an encoded state of multiple {@link BitMask}s.
   * @param value the {@link Boolean} value to encode and set.
   * @return the new bits with the given {@link Boolean} value set.
   */
  public int setBoolean(int bits, Boolean value) {

    int encoded;
    if (value == null) {
      encoded = VALUE_BOOLEAN_NULL;
    } else if (value.booleanValue()) {
      encoded = VALUE_BOOLEAN_TRUE;
    } else {
      encoded = VALUE_BOOLEAN_FALSE;
    }
    return setValue(bits, encoded);
  }

  /**
   * @param shift the number of bits to shift the value to the left.
   * @return the {@link BitValueBoolean}.
   */
  public static BitValueBoolean ofBoolean(int shift) {

    int orMask = 3 << shift;
    return new BitValueBoolean(orMask, ~orMask, shift);
  }
}
