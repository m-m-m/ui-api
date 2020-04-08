/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.datatype.color;

/**
 * This {@link Enum} contains the available types of the {@link ColorSegment segments} of a {@link Color}.
 *
 * @since 1.0.0
 */
public enum ColorSegmentType {

  /** Type of {@link ColorSegment} for {@link Red}. */
  RED,

  /** Type of {@link ColorSegment} for {@link Green}. */
  GREEN,

  /** Type of {@link ColorSegment} for {@link Blue}. */
  BLUE,

  /** Type of {@link ColorSegment} for {@link Hue}. */
  HUE,

  /** Type of {@link ColorSegment} for {@link Saturation} in {@link ColorModel#HSB}. */
  SATURATION_HSB,

  /** Type of {@link ColorSegment} for {@link Saturation} in {@link ColorModel#HSL}. */
  SATURATION_HSL,

  /** Type of {@link ColorSegment} for {@link Brightness}. */
  BRIGHTNESS,

  /** Type of {@link ColorSegment} for {@link Lightness}. */
  LIGHTNESS,

  /** Type of {@link ColorSegment} for {@link Alpha}. */
  ALPHA

}
