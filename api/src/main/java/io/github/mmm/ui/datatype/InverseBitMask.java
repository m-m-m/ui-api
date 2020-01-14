/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype;

/**
 * {@link BitMask} with {@link #isInverse() inverse flag-logic} so for {@code false} a bit is set to {@code 1} and for
 * {@code true}
 */
public abstract class InverseBitMask extends BitMask {

  /**
   * The constructor.
   *
   * @param orMask the {@link #getSetMask() OR bit-mask}.
   * @param andMask the {@link #getClearMask() AND bit-mask}.
   */
  protected InverseBitMask(int orMask, int andMask) {

    super(orMask, andMask);
  }

  @Override
  public final boolean isInverse() {

    return true;
  }

  @Override
  public boolean getFlag(int bits) {

    if (this.setMask == 0) {
      return bits == 0;
    }
    return ((bits & this.setMask) != this.setMask);
  }

}
