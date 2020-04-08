/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.spi.range;

import io.github.mmm.base.number.NumberType;
import io.github.mmm.base.range.AbstractRange;
import io.github.mmm.base.range.WritableRange;
import io.github.mmm.validation.Validator;

/**
 * Implementation of {@link WritableRange} for {@link io.github.mmm.ui.api.widget.input.UiNumericInput}.
 *
 * @param <V> type of the contained values.
 * @since 1.0.0
 * @see io.github.mmm.ui.api.widget.input.UiNumericInput#getRange()
 */
public class NumericRange<V extends Number> extends AbstractRange<V> implements WritableRange<V> {

  private final NumberType<V> type;

  private V min;

  private V minValidator;

  private V max;

  private V maxValidator;

  /**
   * The constructor.
   *
   * @param type the {@link NumberType}.
   */
  public NumericRange(NumberType<V> type) {

    super();
    this.type = type;
  }

  @Override
  public V getMin() {

    if (this.min == null) {
      return this.minValidator;
    }
    return this.min;
  }

  @Override
  public void setMin(V min) {

    this.min = min;
  }

  @Override
  public V getMax() {

    if (this.max == null) {
      return this.maxValidator;
    }
    return this.max;
  }

  @Override
  public void setMax(V max) {

    this.max = max;
  }

  /**
   * @param validator the {@link Validator} to apply.
   */
  public void setValidator(Validator<? super V> validator) {

    if (validator != null) {
      this.minValidator = this.type.valueOf((Number) validator.getMin());
      this.maxValidator = this.type.valueOf((Number) validator.getMax());
    } else {
      this.minValidator = null;
      this.maxValidator = null;
    }
  }

}
