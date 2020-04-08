/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.datatype;

/**
 * Enum with the {@link io.github.mmm.ui.api.UiScreen#getType() types} of a {@link io.github.mmm.ui.api.UiScreen}.
 *
 * @since 1.0.0
 */
public enum UiScreenType {

  /** {@link io.github.mmm.ui.api.UiScreen#getType() Type} of a small display (e.g. smartphone). */
  SMALL,

  /** {@link io.github.mmm.ui.api.UiScreen#getType() Type} of a medium display (e.g. tablet). */
  MEDIUM,

  /** {@link io.github.mmm.ui.api.UiScreen#getType() Type} of a large display (e.g. PC or laptop). */
  LARGE

}
