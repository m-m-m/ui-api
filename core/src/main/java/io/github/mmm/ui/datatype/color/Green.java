/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype.color;

/**
 * This {@link ColorSegment} represents the <em>green</em> part of a {@link GenericColor color}.
 *
 * @see GenericColor#getGreen()
 * @see Color#getGreen()
 *
 * @since 1.0.0
 */
public class Green extends AbstractColorFactor<Green> {

  /**
   * The constructor.
   *
   * @param value is the {@link #getValue() value}.
   */
  public Green(double value) {

    super(value);
  }

  /**
   * The constructor.
   *
   * @param byteValue is the {@link #getValueAsByte() value given as byte}.
   */
  public Green(int byteValue) {

    super(byteValue);
  }

  /**
   * The constructor.
   *
   * @param value is the {@link #getValue() value} given as {@link #toFactorString() factor} or
   *        {@link #toPercentString() percent} {@link String}.
   */
  public Green(String value) {

    super(value);
  }

  @Override
  protected Green newInstance(double value) {

    return new Green(value);
  }

}
