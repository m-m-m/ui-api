/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.datatype.color;

/**
 * This {@link ColorSegment} is a {@link AbstractColorFactor factor} that represents the colorfulness of a stimulus relative to its own
 * brightness. <br>
 * <b>ATTENTION:</b><br>
 * The saturation has different definitions for {@link ColorModel#HSB} and {@link ColorModel#HSL}. Hence transformation
 * from other {@link ColorModel}s like {@link ColorModel#RGB} differs and will return different results for
 * {@link Saturation}.
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public class Saturation extends AbstractColorFactor<Saturation> {

  /**
   * The constructor.
   *
   * @param value is the {@link #getValue() value}.
   */
  public Saturation(double value) {

    super(value);
  }

  /**
   * The constructor.
   *
   * @param value is the {@link #getValue() value} given as {@link #toFactorString() factor} or
   *        {@link #toPercentString() percent} {@link String}.
   */
  public Saturation(String value) {

    super(value);
  }

  @Override
  protected Saturation newInstance(double value) {

    return new Saturation(value);
  }

  @Override
  public String toString() {

    return toPercentString();
  }

}
