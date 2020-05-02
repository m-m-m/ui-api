/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test of {@link UiPlace}.
 */
public class UiPlaceTest extends Assertions {

  /**
   * Test of {@link UiPlace#parse(String)} without parameters.
   */
  @Test
  public void testParseWithoutParams() {

    String id = "my/dialog/id";
    UiPlace place = UiPlace.parse(id);
    assertThat(place.getId()).isEqualTo(id);
    assertThat(place.toString()).isEqualTo(id);
    assertThat(place.has("name")).isFalse();
    assertThat(place.get("name")).isNull();

    UiPlace copy = UiPlace.parse(place.toString());
    assertThat(copy).isEqualTo(place);
  }

  /**
   * Test of {@link UiPlace#parse(String)} with parameters.
   */
  @Test
  public void testParseWithParams() {

    String id = "myDialogId";
    String placeString = id + "?key1=value1&key2=&key3&key4=value4";
    UiPlace place = UiPlace.parse(placeString);
    assertThat(place.getId()).isEqualTo(id);
    assertThat(place.toString()).isEqualTo("myDialogId?key1=value1&key2=&key3=&key4=value4");
    assertThat(place.get("key1")).isEqualTo("value1");
    assertThat(place.get("key2")).isEmpty();
    assertThat(place.get("key3")).isEmpty();
    assertThat(place.get("key4")).isEqualTo("value4");
    assertThat(place.getParameters()).hasSize(4);

    UiPlace copy = UiPlace.parse(place.toString());
    assertThat(copy).isEqualTo(place);
  }

  /**
   * Test of {@link UiPlace#of(String)}.
   */
  @Test
  public void testOfWithoutParams() {

    String id = "myDialogId";
    UiPlace place = UiPlace.of(id);
    assertThat(place.getId()).isEqualTo(id);
    assertThat(place.toString()).isEqualTo(id);
    assertThat(place.has("name")).isFalse();
    assertThat(place.get("name")).isNull();

    UiPlace copy = UiPlace.parse(place.toString());
    assertThat(copy).isEqualTo(place);
  }

  /**
   * Test of {@link UiPlace#of(String, String, Object)}.
   */
  @Test
  public void testOfWith1Params() {

    String id = "myDialogId";
    UiPlace place = UiPlace.of(id, "name", null);
    assertThat(place.getId()).isEqualTo(id);
    assertThat(place.toString()).isEqualTo(id);
    assertThat(place.has("name")).isFalse();
    assertThat(place.get("name")).isNull();
    place = UiPlace.of(id, "name", "value");
    assertThat(place.getId()).isEqualTo(id);
    assertThat(place.has("name")).isTrue();
    assertThat(place.get("name")).isEqualTo("value");

    UiPlace copy = UiPlace.parse(place.toString());
    assertThat(copy).isEqualTo(place);
  }

  /**
   * Test of {@link UiPlace#of(String, String, Object, String, Object)}.
   */
  @Test
  public void testOfWith2Params() {

    String id = "placeId";
    UiPlace place = UiPlace.of(id, "key1", null, "key2", null);
    assertThat(place.getId()).isEqualTo(id);
    assertThat(place.toString()).isEqualTo(id);
    assertThat(place.getParameters()).isEmpty();
    place = UiPlace.of(id, "key1", null, "key2", "value2");
    assertThat(place.toString()).isEqualTo("placeId?key2=value2");
    assertThat(place.get("key2")).isEqualTo("value2");
    place = UiPlace.of(id, "key1", "value1", "key2", "value2");
    assertThat(place.toString()).isEqualTo("placeId?key1=value1&key2=value2");
    assertThat(place.get("key1")).isEqualTo("value1");
    assertThat(place.get("key2")).isEqualTo("value2");

    UiPlace copy = UiPlace.parse(place.toString());
    assertThat(copy).isEqualTo(place);
  }

  /**
   * Test of {@link UiPlace#of(String, String, Object, String, Object, String, Object)}.
   */
  @Test
  public void testOfWith3Params() {

    String id = "placeId";
    assertThat(UiPlace.of(id, "key1", null, "key2", null, "key3", null).toString()).isEqualTo(id);
    assertThat(UiPlace.of(id, "key1", "value1", "key2", null, "key3", null).toString())
        .isEqualTo("placeId?key1=value1");
    assertThat(UiPlace.of(id, "key1", null, "key2", "value2", "key3", null).toString())
        .isEqualTo("placeId?key2=value2");
    assertThat(UiPlace.of(id, "key1", null, "key2", null, "key3", "value3").toString())
        .isEqualTo("placeId?key3=value3");
    assertThat(UiPlace.of(id, "key1", "value1", "key2", "value2", "key3", null).toString())
        .isEqualTo("placeId?key1=value1&key2=value2");
    assertThat(UiPlace.of(id, "key1", "value1", "key2", null, "key3", "value3").toString())
        .isEqualTo("placeId?key1=value1&key3=value3");
    assertThat(UiPlace.of(id, "key1", null, "key2", "value2", "key3", "value3").toString())
        .isEqualTo("placeId?key2=value2&key3=value3");
    assertThat(UiPlace.of(id, "key1", "value1", "key2", "value2", "key3", "value3").toString())
        .isEqualTo("placeId?key1=value1&key2=value2&key3=value3");
  }

  /**
   * Test of {@link UiPlace#getInt(String)}.
   */
  @Test
  public void testGetIntWithoutDefault() {

    String id = "myDialogId";
    UiPlace place = UiPlace.of(id, "key1", Integer.valueOf(42), "key2", "two");
    assertThat(place.getId()).isEqualTo(id);
    assertThat(place.getInt("name")).isNull();
    assertThat(place.getInt("key1")).isEqualTo(42);
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      place.getInt("key2");
    });
    assertThat(exception).hasMessage("key2=two");
  }

  /**
   * Test of {@link UiPlace#getInt(String, int)}.
   */
  @Test
  public void testGetIntWithDefault() {

    String id = "myDialogId";
    UiPlace place = UiPlace.of(id, "key1", Integer.valueOf(42), "key2", "two");
    assertThat(place.getId()).isEqualTo(id);
    assertThat(place.getInt("key1", 99)).isEqualTo(42);
    assertThat(place.getInt("name", 99)).isEqualTo(99);
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      place.getInt("key2", 2);
    });
    assertThat(exception).hasMessage("key2=two");
  }
}
