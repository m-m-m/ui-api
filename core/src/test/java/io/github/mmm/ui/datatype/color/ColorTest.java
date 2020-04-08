/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype.color;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import io.github.mmm.base.text.CaseHelper;
import io.github.mmm.ui.api.datatype.color.Alpha;
import io.github.mmm.ui.api.datatype.color.Color;

/**
 * Test of {@link Color}.
 */
public class ColorTest extends Assertions {

  /**
   * Positive tests of {@link Color} for legal RGB values.
   */
  @Test
  public void testRgbColor() {

    // int step = 1;
    // for speed and performance increase step...
    int step = 7;
    for (int i = 0; i <= 0xFFFFFF; i = i + step) {
      int rgba = i | 0xFF000000;
      Color color = new Color(rgba);
      Integer integer = Integer.valueOf(rgba);
      assertThat(integer).isEqualTo(color.getArgb());

      // test string representation
      String colorString = color.toString();
      String hex = CaseHelper.toUpperCase(Integer.toString(i, 16));
      while (hex.length() < 6) {
        hex = "0" + hex;
      }
      assertThat("#" + hex).isEqualTo(colorString).isEqualTo(color.toString());
      checkColorGeneric(color, colorString);
    }
  }

  /**
   * Positive tests of {@link Color} for legal RGBA values.
   */
  @Test
  public void testRgbaColor() {

    for (int i = 0; i <= 0xFF; i++) {
      int rgba = (i << 24) | 0x1F2F3F;
      Color color = new Color(rgba);
      Integer rgbaInteger = Integer.valueOf(rgba);
      assertThat(rgbaInteger).isEqualByComparingTo(color.getArgb());
      assertThat(i).isEqualTo(color.getAlpha());
      assertThat(0x1F).isEqualTo(color.getRed());
      assertThat(0x2F).isEqualTo(color.getGreen());
      assertThat(0x3F).isEqualTo(color.getBlue());

      // test string representation
      String colorString = color.toString();
      if (i == 255) {
        assertThat("#1F2F3F").isEqualTo(colorString);
      } else {
        assertThat("rgba(31,47,63," + i / 255.0 + ")").isEqualTo(colorString);
      }

      checkColorGeneric(color, colorString);
    }
  }

  /**
   * Performs generic checks on the given {@link Color}.
   *
   * @param color is the {@link Color} to test.
   * @param colorString is the expected {@link Color#toString() string representation} of the {@link Color}.
   */
  private void checkColorGeneric(Color color, String colorString) {

    // test copy from RGBA values
    Color copy = new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    assertThat(color).isEqualTo(copy);
    // test copy from String representation
    copy = Color.of(colorString);
    assertThat(color).isEqualTo(copy);
    // test copy from RGBA String representation
    String rgbString = "rgba(" + color.getRed() + "," + color.getGreen() + ", " + color.getBlue() + ","
        + new Alpha(color.getAlpha()) + ")";
    copy = Color.of(rgbString);
    assertThat(color).isEqualTo(copy);
    // // test copy from HSBA values
    // copy = Color.fromHsba(color.getHue(), color.getSaturationHsb(), color.getBrightness(),
    // color.getAlphaRate());
    // assertEquals(color, copy);
    // // test copy from HSLA values
    // copy = Color.fromHsla(color.getHue(), color.getSaturationHsl(), color.getLightness(),
    // color.getAlphaRate());
    // // assertEquals(color, copy);
    // if (!color.equals(copy)) {
    // System.out.println(color + " -> " + copy);
    // }
  }
}
