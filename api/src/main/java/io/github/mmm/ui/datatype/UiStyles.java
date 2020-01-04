/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.datatype;

/**
 * Container for styles.
 */
public interface UiStyles {

  /** The regular expression pattern for a single style. */
  String PATTERN_SINGLE = "[a-zA-Z][_a-zA-Z0-9-]*";

  /** The regular expression pattern for any number of {@link #get() styles}. */
  String PATTERN_MULTIPLE = "(" + PATTERN_SINGLE + ")?([ ]" + PATTERN_SINGLE + ")*";

  /**
   * This method gets the style(s) (also called style-name(s)) of this object. The style defines aspects for the
   * appearance (look & feel) of a UI element when displayed to the user. <br>
   * If you are familiar with web-technology just think of this as the <code>class</code> attribute of HTML elements
   * that are then configured via some cascading style sheet (CSS). <br>
   * The following situations can be distinguished:
   * <ul>
   * <li><b>no style</b><br>
   * The empty string is returned.</li>
   * <li><b>single style</b><br>
   * The name of that single style is returned. The result does NOT contain any whitespace.</li>
   * <li><b>multiple styles</b><br>
   * The list of individual styles are separated by whitespaces in the result.</li>
   * </ul>
   * Each individual style has to match {@link #PATTERN_SINGLE}. Any number of styles or in other words the result of
   * this has to match {@link #PATTERN_MULTIPLE}. The first style is called the {@link #getPrimary() primary style}.
   *
   * @return the style(s) of this object.
   */
  String get();

  /**
   *
   * @param styles the new {@link #get() styles}. Either a single style or a list of styles separated by whitespaces.
   *        Use the empty string to unset all styles.
   */
  void set(String styles);

  /**
   * @param style is the style to check.
   * @return {@code true} if the given {@code style} is present in the {@link #get() styles}, {@code false} otherwise.
   */
  boolean contains(String style);

  /**
   * @param style is the style to add. If this style is already contained in the {@link #get() styles}, this will have
   *        no effect.
   * @return {@code true} if the style has actually been added, {@code false} if it was already present before.
   */
  boolean add(String style);

  /**
   * @param style is the style to remove. If this style is not contained in the {@link #get() styles}, this will have no
   *        effect.
   * @return {@code true} if the given {@code style} has actually been removed, {@code false} otherwise (if it
   *         {@link #contains(String) was not present}).
   */
  boolean remove(String style);

  /**
   * @return the primary style of this widget. Will be {@code null} if not defined.
   */
  String getPrimary();

  /**
   * @param primaryStyle is the new value of {@link #getPrimary()}.
   */
  void setPrimary(String primaryStyle);

}
