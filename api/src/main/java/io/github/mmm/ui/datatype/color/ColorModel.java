/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype.color;

/**
 * This enum contains the available {@link ColorModel}s supported by {@link GenericColor}. Please note that a color
 * typically has four {@link ColorSegment segments} where only three of them are specific for the {@link ColorModel} and
 * the fourth is {@link Alpha} (opacity). So for each of these {@link ColorModel}s there is a notation with and without
 * {@link Alpha}. E.g. "rgb(255, 255, 255)" is the same as "rgba(255, 255, 255, 1.0)".
 *
 * @see GenericColor#invert(ColorModel)
 * @see GenericColor#toString(ColorModel)
 * @since 1.0.0
 */
public enum ColorModel {

  /**
   * The indicator for the RGB color model, where RGB stands for the components {@link Red}, {@link Green}, and
   * {@link Blue}.
   */
  RGB(ColorSegmentType.RED, ColorSegmentType.GREEN, ColorSegmentType.BLUE),

  /**
   * The indicator for the HSB color model, where HSB stands for the components {@link Hue}, {@link Saturation}, and
   * {@link Brightness}.
   */
  HSB(ColorSegmentType.HUE, ColorSegmentType.SATURATION_HSB, ColorSegmentType.BRIGHTNESS),

  /**
   * The indicator for the HSV color model. This is the same as {@link #HSB} with the only difference that
   * {@link Brightness} is named <em>value</em>.
   */
  HSV(ColorSegmentType.HUE, ColorSegmentType.SATURATION_HSB, ColorSegmentType.BRIGHTNESS),

  /**
   * The indicator for the HSL color model, where HSL stands for the components {@link Hue}, {@link Saturation}, and
   * {@link Lightness}.
   */
  HSL(ColorSegmentType.HUE, ColorSegmentType.SATURATION_HSL, ColorSegmentType.LIGHTNESS);

  private final ColorSegmentType s1;

  private final ColorSegmentType s2;

  private final ColorSegmentType s3;

  private ColorModel(ColorSegmentType s1, ColorSegmentType s2, ColorSegmentType s3) {

    this.s1 = s1;
    this.s2 = s2;
    this.s3 = s3;
  }

  /**
   * @return the {@link ColorSegmentType} of the first {@link ColorSegment} of this {@link ColorModel}. E.g.
   *         {@link ColorSegmentType#RED} for {@link #RGB}.
   */
  public ColorSegmentType getFirst() {

    return this.s1;
  }

  /**
   * @return the {@link ColorSegmentType} of the second {@link ColorSegment} of this {@link ColorModel}. E.g.
   *         {@link ColorSegmentType#SATURATION_HSL} for {@link #HSL}.
   */
  public ColorSegmentType getSecond() {

    return this.s2;
  }

  /**
   * @return the {@link ColorSegmentType} of the first {@link ColorSegment} of this {@link ColorModel}. E.g.
   *         {@link ColorSegmentType#BRIGHTNESS} for {@link #HSB}.
   */
  public ColorSegmentType getThird() {

    return this.s3;
  }

}
