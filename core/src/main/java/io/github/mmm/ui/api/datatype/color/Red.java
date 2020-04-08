/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.datatype.color;

/**
 * This {@link ColorSegment} represents the <em>red</em> part of a {@link GenericColor color}.
 *
 * @see Color#getRed()
 * @see GenericColor#getRed()
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public class Red extends AbstractColorFactor<Red> {

  /**
   * The constructor.
   *
   * @param value is the {@link #getValue() value}.
   */
  public Red(double value) {

    super(value);
  }

  /**
   * The constructor.
   *
   * @param value is the {@link #getValue() value} given as {@link #toFactorString() factor} or
   *        {@link #toPercentString() percent} {@link String}.
   */
  public Red(String value) {

    super(value);
  }

  /**
   * The constructor.
   *
   * @param byteValue is the {@link #getValueAsByte() value given as byte}.
   */
  public Red(int byteValue) {

    super(byteValue);
  }

  @Override
  protected Red newInstance(double value) {

    return new Red(value);
  }

}
