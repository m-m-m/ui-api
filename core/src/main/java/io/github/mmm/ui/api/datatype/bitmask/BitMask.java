/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.datatype.bitmask;

/**
 * An {@link #getValue(int) value} and {@link #getFlag(int) flag} that can be encoded into a primitive {@code int}
 * value. By creating multiple disjunct {@link BitMask}s you can encode multiple smaller informations ( {@code boolean},
 * {@code Boolean}, {@link Enum}, {@code byte}, etc.) into a single {@code int} value.
 *
 * @since 1.0.0
 */
public abstract class BitMask {

  /** @see #getSetMask() */
  protected final int setMask;

  /** @see #getClearMask() */
  protected final int clearMask;

  /**
   * The constructor.
   *
   * @param setMask the {@link #getSetMask() bit-mask to set value}.
   * @param clearMask the {@link #getClearMask() bit-mask to clear value}.
   */
  protected BitMask(int setMask, int clearMask) {

    super();
    this.setMask = setMask;
    this.clearMask = clearMask;
  }

  /**
   * @return the bit-mask to set the value or flag bits.
   */
  public int getSetMask() {

    return this.setMask;
  }

  /**
   * @return the bit-mask to clear the value of flag bits.
   */
  public int getClearMask() {

    return this.clearMask;
  }

  /**
   * @return {@code true} if the bits are used with inverse logic, so to {@link #setFlag(int, boolean) set a flag}
   *         according bits are set to {@code 0} for {@code true} (instead of {@code 1}) and to {@code 1} for
   *         {@code false} (instead of {@code 0}), {@code false} otherwise. The inverse logic is helpful to combine
   *         multiple {@link InverseBitFlag}s with a logical AND in order to set an aggregated flag.
   */
  public abstract boolean isInverse();

  /**
   * @return {@code true} if this {@link BitMask} is only representing a single bit of information (a boolean flag),
   *         {@code false} otherwise (if a {@link #isBitValue() value}).
   * @see #setFlag(int, boolean)
   * @see #getFlag(int)
   */
  public final boolean isBitFlag() {

    return !isBitValue();
  }

  /**
   * @return {@code true} if this {@link BitMask} represents a value with multiple bits of information, {@code false}
   *         otherwise (if a {@link #isBitFlag() flag}).
   * @see #setValue(int, int)
   * @see #getValue(int)
   */
  public boolean isBitValue() {

    return false;
  }

  /**
   * @param bits the current bits representing an encoded state of multiple {@link BitMask}s.
   * @return {@code true} if this {@link BitMask} is current set in the bits, {@code false} otherwise.
   * @see #isBitFlag()
   */
  public abstract boolean getFlag(int bits);

  /**
   * @param bits the current bits representing an encoded state of multiple {@link BitMask}s.
   * @param flag {@code true} to set this {@link BitMask} in the bits, {@code false} to unset it.
   * @return the new bits with the {@link BitMask} set to the given {@code flag}.
   * @see #isBitFlag()
   */
  public abstract int setFlag(int bits, boolean flag);

  /**
   * @param bits the current bits representing an encoded state of multiple {@link BitMask}s.
   * @return the value extracted from the bits with this {@link BitMask}.
   * @see #isBitValue()
   */
  public abstract int getValue(int bits);

  /**
   * @param bits the current bits representing an encoded state of multiple {@link BitMask}s.
   * @param value the value to set in the bits according to this {@link BitMask}.
   * @return the new bits with the {@link BitMask} set to the given {@code flag}.
   * @see #isBitValue()
   */
  public abstract int setValue(int bits, int value);

}
