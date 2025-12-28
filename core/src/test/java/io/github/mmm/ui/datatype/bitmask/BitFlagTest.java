/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype.bitmask;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import io.github.mmm.ui.api.datatype.bitmask.BitFlag;

/**
 * Test of {@link BitFlag}.
 */
class BitFlagTest extends Assertions {

  /** Test of {@link BitFlag#ANY}. */
  @Test
  void testAny() {

    // arrange
    BitFlag any = BitFlag.ANY;

    // act + assert
    assertThat(any.getFlag(0)).isFalse();
    assertThat(any.getFlag(1)).isTrue();
    assertThat(any.getFlag(2)).isTrue();
    assertThat(any.getFlag(3)).isTrue();
    assertThat(any.getFlag(-1)).isTrue();

    assertThat(any.setFlag(0, true)).isEqualTo(0);
    assertThat(any.setFlag(1, true)).isEqualTo(1);
    assertThat(any.setFlag(-1, true)).isEqualTo(-1);
    assertThat(any.setFlag(0, false)).isEqualTo(0);
    assertThat(any.setFlag(1, false)).isEqualTo(1);
    assertThat(any.setFlag(-1, false)).isEqualTo(-1);
  }

  /** Test of {@link BitFlag#ALL}. */
  @Test
  void testAll() {

    // arrange
    BitFlag all = BitFlag.ALL;

    // act + assert
    assertThat(all.getFlag(0)).isFalse();
    assertThat(all.getFlag(1)).isFalse();
    assertThat(all.getFlag(2)).isFalse();
    assertThat(all.getFlag(3)).isFalse();
    assertThat(all.getFlag(-1)).isTrue();

    assertThat(all.setFlag(0, true)).isEqualTo(-1);
    assertThat(all.setFlag(1, true)).isEqualTo(-1);
    assertThat(all.setFlag(-1, true)).isEqualTo(-1);

    assertThat(all.setFlag(0, false)).isEqualTo(0);
    assertThat(all.setFlag(1, false)).isEqualTo(0);
    assertThat(all.setFlag(-1, false)).isEqualTo(0);
  }

  /** Test of {@link BitFlag#B01}. */
  @Test
  void testB01() {

    // arrange
    BitFlag b01 = BitFlag.B01;

    // act + assert
    assertThat(BitFlag.ofLsb(1)).isSameAs(b01);

    assertThat(b01.getFlag(0)).isFalse().isEqualTo(b01.getValue(0) == 1);
    assertThat(b01.getFlag(1)).isFalse().isEqualTo(b01.getValue(1) == 1);
    assertThat(b01.getFlag(2)).isTrue().isEqualTo(b01.getValue(2) == 1);
    assertThat(b01.getFlag(3)).isTrue().isEqualTo(b01.getValue(3) == 1);
    assertThat(b01.getFlag(4)).isFalse().isEqualTo(b01.getValue(4) == 1);

    assertThat(b01.setFlag(0, true)).isEqualTo(2).isEqualTo(b01.setValue(0, 1));
    assertThat(b01.setFlag(1, true)).isEqualTo(3).isEqualTo(b01.setValue(1, 1));
    assertThat(b01.setFlag(2, true)).isEqualTo(2).isEqualTo(b01.setValue(2, 1));
    assertThat(b01.setFlag(3, true)).isEqualTo(3).isEqualTo(b01.setValue(3, 1));
    assertThat(b01.setFlag(4, true)).isEqualTo(6).isEqualTo(b01.setValue(4, 1));

    assertThat(b01.setFlag(0, false)).isEqualTo(0).isEqualTo(b01.setValue(0, 0));
    assertThat(b01.setFlag(1, false)).isEqualTo(1).isEqualTo(b01.setValue(1, 0));
    assertThat(b01.setFlag(2, false)).isEqualTo(0).isEqualTo(b01.setValue(2, 0));
    assertThat(b01.setFlag(3, false)).isEqualTo(1).isEqualTo(b01.setValue(3, 0));
    assertThat(b01.setFlag(4, false)).isEqualTo(4).isEqualTo(b01.setValue(4, 0));
  }

  /** Test of {@link BitFlag#ofLsb(int)}. */
  @Test
  void testOfLsb() {

    int bitMask = 1;
    for (int i = 0; i < 32; i++) {
      BitFlag flag = BitFlag.ofLsb(i);
      assertThat(flag.getSetMask()).isEqualTo(bitMask);
      assertThat(flag.getClearMask()).isEqualTo(~bitMask);
      bitMask = bitMask << 1;
    }
  }

}
