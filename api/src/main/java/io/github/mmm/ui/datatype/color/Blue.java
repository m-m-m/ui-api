/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype.color;

/**
 * This {@link ColorSegment} represents the <em>blue</em> part of a {@link GenericColor color}.
 *
 * @see Color#getBlue()
 * @see GenericColor#getBlue()
 *
 * @since 1.0.0
 */
public class Blue extends AbstractColorFactor<Blue> {

  /**
   * The constructor.
   *
   * @param value is the {@link #getValue() value}.
   */
  public Blue(double value) {

    super(value);
  }

  /**
   * The constructor.
   *
   * @param byteValue is the {@link #getValueAsByte() value given as byte}.
   */
  public Blue(int byteValue) {

    super(byteValue);
  }

  /**
   * The constructor.
   *
   * @param value is the {@link #getValue() value} given as {@link #toFactorString() factor} or
   *        {@link #toPercentString() percent} {@link String}.
   */
  public Blue(String value) {

    super(value);
  }

  @Override
  protected Blue newInstance(double value) {

    return new Blue(value);
  }

}
