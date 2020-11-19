/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to {@link #getId() read} the {@link #getId() ID}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeReadId {

  /**
   * This method gets the unique identifier of this object. <br>
   * <b>ATTENTION:</b><br>
   * In order to be compliant with all possible UI toolkit implementations, a valid ID has to fulfill ECMA-262, Section
   * 7.6. It is recommended to use IDs of the form {@code [a-zA-Z][a-zA-Z0-9_$]*}. Invalid IDs (e.g. containing colon,
   * hash or period) will cause complications with CSS selectors.
   *
   * @return the ID of this object.
   */
  String getId();

}
