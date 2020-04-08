/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.spi;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import io.github.mmm.ui.api.datatype.UiStyles;
import io.github.mmm.ui.spi.UiStylesImpl;

/**
 * Test of {@link UiStylesImpl}.
 */
public class UiStylesImplTest extends Assertions {

  /** Test of {@link UiStylesImpl#add(String)} and of {@link UiStylesImpl#remove(String)}. */
  @Test
  public void testStyles() {

    UiStyles styles = new UiStylesImpl();
    assertThat(styles.toString()).isEmpty();
    String style1 = "my-class1";
    styles.add(style1);
    checkStyles(styles, style1);
    styles.remove(style1);
    assertThat(styles.toString()).isEmpty();
    styles.add(style1);
    checkStyles(styles, style1);
    String style2 = "class2";
    styles.add(style2);
    checkStyles(styles, style1, style2);
    String style3 = "some_class3";
    styles.add(style3);
    checkStyles(styles, style1, style2, style3);
    styles.remove(style2);
    checkStyles(styles, style1, style3);
    styles.add(style2);
    checkStyles(styles, style1, style3, style2);
    styles.remove(style1);
    checkStyles(styles, style3, style2);
    styles.add(style1);
    checkStyles(styles, style3, style2, style1);
    styles.remove(style3);
    checkStyles(styles, style2, style1);
    styles.add(style3);
    checkStyles(styles, style2, style1, style3);
    assertThat(styles.toString()).isEqualTo("class2 my-class1 some_class3");
  }

  private void checkStyles(UiStyles styles, String... expectedStyles) {

    StringBuilder sb = new StringBuilder();
    assertThat(styles.contains("undefined-style_that_never-exists")).isFalse();
    for (String expectedStyle : expectedStyles) {
      assertThat(styles.contains(expectedStyle)).isTrue();
      if (sb.length() > 0) {
        sb.append(' ');
      }
      sb.append(expectedStyle);
    }
    assertThat(styles.get()).isEqualTo(sb.toString()).isEqualTo(styles.toString());
  }

}
