/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype.color;

/**
 * This {@link ColorSegment} represents the <em>chroma</em> of a {@link Color}. The chroma is a {@link AbstractColorFactor factor}
 * indicating the colorfulness relative to the brightness of a similarly illuminated white.
 *
 * @see GenericColor#getChroma()
 *
 * @since 1.0.0
 */
public class Chroma extends AbstractColorFactor<Chroma> {

  /**
   * The constructor.
   *
   * @param value is the {@link #getValue() value}.
   */
  public Chroma(double value) {

    super(value);
  }

  /**
   * The constructor.
   *
   * @param byteValue is the {@link #getValueAsByte() value given as byte}.
   */
  public Chroma(int byteValue) {

    super(byteValue);
  }

  /**
   * The constructor.
   *
   * @param value is the {@link #getValue() value} given as {@link #toFactorString() factor} or
   *        {@link #toPercentString() percent} {@link String}.
   */
  public Chroma(String value) {

    super(value);
  }

  @Override
  protected Chroma newInstance(double value) {

    return new Chroma(value);
  }

}
