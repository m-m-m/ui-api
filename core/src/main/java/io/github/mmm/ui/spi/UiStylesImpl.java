/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.spi;

import java.util.Objects;

import io.github.mmm.ui.api.datatype.UiStyles;

/**
 * Implementation of {@link UiStyles}.
 */
public class UiStylesImpl implements UiStyles {

  private String styles;

  /**
   * The constructor.
   */
  public UiStylesImpl() {

    super();
    this.styles = "";
  }

  private static boolean isEmpty(String value) {

    if (value == null) {
      return true;
    }
    return value.isEmpty();
  }

  @Override
  public final String get() {

    return this.styles;
  }

  @Override
  public final void set(String styles) {

    if (styles == null) {
      styles = "";
    }
    if (this.styles.equals(styles)) {
      return;
    }
    this.styles = styles;
    onStylesChanged();
  }

  /**
   * Triggered whenever the {@link #get() styles} changed.
   */
  protected void onStylesChanged() {

  }

  @Override
  public final boolean contains(String style) {

    if (isEmpty(style)) {
      return false;
    }
    return (getIndexOfStyle(style) >= 0);
  }

  private int getIndexOfStyle(String style) {

    int length = style.length();
    int index = this.styles.indexOf(style);
    while (index >= 0) {
      boolean validStart = true;
      int end = index + length;
      if (index > 0) {
        if (this.styles.charAt(index - 1) != ' ') {
          validStart = false;
        }
      }
      if (validStart) {
        if ((end == this.styles.length()) || (this.styles.charAt(end) == ' ')) {
          return index;
        }
      }
      index = this.styles.indexOf(style, end);
    }
    return -1;
  }

  @Override
  public final boolean add(String style) {

    Objects.requireNonNull(style, "style");
    assert (style.matches(PATTERN_SINGLE));
    if (!contains(style)) {
      if (isEmpty(this.styles)) {
        this.styles = style;
      } else {
        this.styles = this.styles + " " + style;
      }
      onStylesChanged();
      return true;
    }
    return false;
  }

  @Override
  public final boolean remove(String style) {

    if (isEmpty(style)) {
      assert false;
      return false;
    }
    assert (!style.contains(" "));
    int startIndex = getIndexOfStyle(style);
    if (startIndex >= 0) {
      int endIndex = startIndex + style.length();
      if (startIndex == 0) {
        if (endIndex < this.styles.length()) {
          // also remove separating space after style-name
          endIndex++;
        }
      } else {
        // also remove leading space before style-name
        startIndex--;
      }
      this.styles = this.styles.substring(0, startIndex) + this.styles.substring(endIndex);
      onStylesChanged();
      return true;
    }
    return false;
  }

  @Override
  public final String getPrimary() {

    if (isEmpty(this.styles)) {
      return null;
    } else {
      int index = this.styles.indexOf(' ');
      if (index >= 0) {
        return this.styles.substring(0, index);
      } else {
        return this.styles;
      }
    }
  }

  @Override
  public final void setPrimary(String primaryStyle) {

    Objects.requireNonNull(primaryStyle, "primaryStyle");
    assert (primaryStyle.matches(PATTERN_SINGLE)) : primaryStyle;
    if (this.styles.isEmpty()) {
      this.styles = primaryStyle;
    } else {
      int startIndex = getIndexOfStyle(primaryStyle);
      if (startIndex == 0) {
        // it is already the primary style - nothing to do...
        return;
      }
      StringBuilder buffer = new StringBuilder(primaryStyle);
      if (startIndex > 0) {
        // the primaryStyle is an existing style but NOT the primary style. We have to move it to the start.
        int endIndex = startIndex + primaryStyle.length();
        if (endIndex < this.styles.length()) {
          // also remove separating space after style-name
          endIndex++;
        }
        buffer.append(' ');
        buffer.append(this.styles.substring(0, startIndex));
        buffer.append(this.styles.substring(endIndex));
      } else {
        // the primaryStyle is a new style - we have to replace the current primary style.
        int index = this.styles.indexOf(' ');
        if (index >= 0) {
          buffer.append(' ');
          buffer.append(this.styles.substring(index + 1));
        } else {
          // nothing to do...
        }
      }
      this.styles = buffer.toString();
    }
    onStylesChanged();
  }

  @Override
  public final String toString() {

    return this.styles;
  }

}
