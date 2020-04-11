/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import io.github.mmm.ui.api.attribute.AttributeReadId;

/**
 * A place {@link #getId() identifies} a {@link UiController} in combination with its {@link #getParameters()
 * parameters}. It allows to represent a specific state of the client that can be bookmarked and reopened at a later
 * point in time.<br>
 * <b>HINT:</b><br>
 * For each of your {@link UiController} you need to define an {@link #getId() ID}. To decouple your navigation from the
 * actual {@link UiController} implementations, it is recommended to define them as constants in a places class per
 * component or module. {@link UiController}s may have mandatory or optional {@link #get(String) parameters}. Therefore,
 * it is recommended to create {@code factory methods} for your {@link UiPlace}s in the places class defining the
 * constants that take the parameter values as properly typed arguments. This will make refactoring easier if parameters
 * need to be changed. For generic access to your parameters please also define <code>PARAMETER_*</code> constants in
 * your places class.
 *
 * <pre>
 * public final class ExamplePlaces {
 *
 *  private ExamplePlaces() {}
 *
 *  public static final String ID_ADDRESS = "address";
 *
 *  public static final String PARAMETER_ID = "id";
 *
 *  public static {@link UiPlace} placeAddress(long id) {
 *    return {@link UiPlace}.of(ID_ADDRESS, PARAMETER_ID, id);
 *  }
 *
 *  public static void navigateAddress(long id) {
 *    {@link UiPlace} place = placeAddress(id);
 *    {@link UiControllerManager}.{@link UiControllerManager#get() get()}.{@link UiControllerManager#navigateTo(UiPlace) navigateTo}(place);
 *  }
 *
 * </pre>
 *
 * @since 1.0.0
 */
public final class UiPlace implements AttributeReadId {

  /** The separator for {@link #getId() dialog-id} and its {@link #getParameters() parameters}. */
  public static final char SEPARATOR_STATE = ':';

  /** The separator used between {@link #getParameters() parameters}. */
  public static final char SEPARATOR_PARAMETER = ';';

  /** The separator for key and value of a {@link #get(String) parameter}. */
  public static final char SEPARATOR_VALUE = '=';

  /** The regex pattern used to assert {@link #get(String) parameter keys}. */
  public static final String PATTERN_KEY = "[^;:=&/]+";

  /** The regex pattern used to assert {@link #get(String) parameter values}. */
  public static final String PATTERN_VALUE = "[^;]*";

  /** @see UiController#PATTERN_DIALOG_ID */
  public static final String PATTERN_DIALOG_ID = UiController.PATTERN_DIALOG_ID;

  private final String id;

  private Map<String, String> parameters;

  /**
   * The constructor.
   *
   * @param id the {@link #getId() contoller ID}.
   */
  public UiPlace(String id) {

    this(id, null);
  }

  /**
   * The constructor.
   *
   * @param id the {@link #getId() contoller ID}.
   * @param parameters the {@link #getParameters() parameters}.
   */
  public UiPlace(String id, Map<String, String> parameters) {

    super();
    if (!id.matches(PATTERN_DIALOG_ID)) {
      throw new IllegalArgumentException(id);
    }
    this.id = id;
    if (parameters == null) {
      this.parameters = Collections.emptyMap();
    } else {
      this.parameters = Collections.unmodifiableMap(parameters);
    }
  }

  /**
   * @return the {@link UiController#getId() ID} of the {@link UiController}.
   */
  @Override
  public final String getId() {

    return this.id;
  }

  /**
   * @return the {@link Map} of parameters.
   */
  public Map<String, String> getParameters() {

    return this.parameters;
  }

  /**
   * This method determines if a {@link #get(String)} is present (!= null).
   *
   * @param key is the name of the parameter to test.
   * @return <code>true</code> if that parameter is present (NOT <code>null</code>), <code>false</code> otherwise.
   */
  public boolean has(String key) {

    // we do not accept null values as present parameters...
    return (get(key) != null);
  }

  /**
   * This method gets a parameter of this {@link UiPlace}.
   *
   * @param key is the name of the requested parameter.
   * @return the value of the requested parameter. Will be {@code null} if not set.
   */
  public String get(String key) {

    return this.parameters.get(key);
  }

  /**
   * This method gets a parameter of this {@link UiPlace}.
   *
   * @param key is the name of the requested parameter.
   * @return the value of the requested parameter. Will be {@code null} if not set.
   */
  public Integer getInt(String key) {

    String value = this.parameters.get(key);
    if (value == null) {
      return null;
    }
    try {
      return Integer.valueOf(value);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(key + "=" + value, e);
    }
  }

  /**
   * This method gets a parameter of this {@link UiPlace}.
   *
   * @param key is the name of the requested parameter.
   * @param defaultValue the default value to return if the parameter with the given {@code key} is not
   *        {@link #has(String) defined}.
   * @return the value of the requested parameter.
   */
  public int getInt(String key, int defaultValue) {

    String value = this.parameters.get(key);
    if (value == null) {
      return defaultValue;
    }
    try {
      return Integer.parseInt(value);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(key + "=" + value, e);
    }
  }

  @Override
  public int hashCode() {

    return Objects.hash(this.id, this.parameters);
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if ((obj == null) || (getClass() != UiPlace.class)) {
      return false;
    }
    UiPlace other = (UiPlace) obj;
    return Objects.equals(this.id, other.id) && Objects.equals(this.parameters, other.parameters);
  }

  @Override
  public String toString() {

    if (this.parameters == null) {
      return this.id;
    } else {
      StringBuilder buffer = new StringBuilder(this.id);
      char separator = SEPARATOR_STATE;
      for (Entry<String, String> entry : this.parameters.entrySet()) {
        String key = entry.getKey();
        assert (key.matches(PATTERN_KEY));
        String value = entry.getValue();
        if (value != null) {
          assert (value.matches(PATTERN_VALUE));
          buffer.append(separator);
          separator = SEPARATOR_PARAMETER;
          buffer.append(key);
          buffer.append(SEPARATOR_VALUE);
          buffer.append(value);
        }
      }
      return buffer.toString();
    }
  }

  /**
   * This is the inverse operation of {@link #toString()}.
   *
   * @param place is the string-representation of the {@link UiPlace} to create.
   * @return the according {@link UiPlace}.
   */
  public static UiPlace parse(String place) {

    int stateIndex = place.indexOf(SEPARATOR_STATE);
    if (stateIndex < 0) {
      // myDialogId
      return new UiPlace(place);
    } else {
      // myDialogId:key1=value1;key2=;key3;key4=value4
      // value2 and value3 are both the empty string.
      String id = place.substring(0, stateIndex);
      Map<String, String> parameters = new LinkedHashMap<>();
      int start = stateIndex + 1;
      int length = place.length();
      while (start < length) {
        int end = place.indexOf(SEPARATOR_PARAMETER, start);
        if (end < 0) {
          end = length;
        }
        // key=value
        String key;
        String value;
        int equalsIndex = place.indexOf(SEPARATOR_VALUE, start);
        if ((equalsIndex < 0) || (equalsIndex > end)) {
          key = place.substring(start, end);
          value = "";
        } else {
          key = place.substring(start, equalsIndex);
          value = place.substring(equalsIndex + 1, end);
        }
        parameters.put(key, value);
        start = end + 1;
      }
      return new UiPlace(id, parameters);
    }
  }

  /**
   * @param id is the {@link #getId() controller ID}.
   * @return the new {@link UiPlace}.
   */
  public static UiPlace of(String id) {

    return new UiPlace(id);
  }

  /**
   * @param id is the {@link #getId() controller ID}.
   * @param key the {@link #has(String) parameter key}.
   * @param value the {@link #get(String) parameter value}.
   * @return the new {@link UiPlace}.
   */
  public static UiPlace of(String id, String key, Object value) {

    if (value == null) {
      return new UiPlace(id);
    }
    return new UiPlace(id, Collections.singletonMap(key, value.toString()));
  }

  /**
   * @param id is the {@link #getId() controller ID}.
   * @param key1 the first {@link #has(String) parameter key}.
   * @param value1 the fist {@link #get(String) parameter value}.
   * @param key2 the second {@link #has(String) parameter key}.
   * @param value2 the second {@link #get(String) parameter value}.
   * @return the new {@link UiPlace}.
   */
  public static UiPlace of(String id, String key1, Object value1, String key2, Object value2) {

    if (value2 == null) {
      return of(id, key1, value1);
    } else if (value1 == null) {
      return of(id, key2, value2);
    } else {
      Map<String, String> parameters = new HashMap<>();
      parameters.put(key1, value1.toString());
      parameters.put(key2, value2.toString());
      return new UiPlace(id, parameters);
    }
  }

  /**
   * @param id is the {@link #getId() controller ID}.
   * @param key1 the first {@link #has(String) parameter key}.
   * @param value1 the fist {@link #get(String) parameter value}.
   * @param key2 the second {@link #has(String) parameter key}.
   * @param value2 the second {@link #get(String) parameter value}.
   * @param key3 the third {@link #has(String) parameter key}.
   * @param value3 the third {@link #get(String) parameter value}.
   * @return the new {@link UiPlace}.
   */
  public static UiPlace of(String id, String key1, Object value1, String key2, Object value2, String key3,
      Object value3) {

    if (value3 == null) {
      return of(id, key1, value1, key2, value2);
    } else if (value2 == null) {
      return of(id, key1, value1, key3, value3);
    } else if (value1 == null) {
      return of(id, key2, value2, key3, value3);
    } else {
      Map<String, String> parameters = new HashMap<>();
      parameters.put(key1, value1.toString());
      parameters.put(key2, value2.toString());
      parameters.put(key3, value3.toString());
      return new UiPlace(id, parameters);
    }
  }

}