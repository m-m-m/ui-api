/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.attribute;

/**
 * Interface to read {@link #getLanguage() language}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeReadLanguage {

  /**
   * @return the language of the content. Should be the <em>ISO 3166-1 alpha-2 code</em>. The case (upper/lower) should
   *         not be considered to be portable (officially upper-case is used, but the web with HTML is often using lower
   *         case). May be {@code null} if not set.
   */
  String getLanguage();

}
