/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import io.github.mmm.base.exception.DuplicateObjectException;
import io.github.mmm.base.exception.ObjectNotFoundException;
import io.github.mmm.ui.api.attribute.AttributeReadId;

/**
 * A place {@link #getId() identifies} a {@link UiController} in combination with its {@link #getParameters()
 * parameters}. It allows to represent a specific state of the client that can be bookmarked and reopened at a later
 * point in time.<br>
 * <b>HINT:</b><br>
 * For each of your {@link UiController} you need to define an {@link #getId() ID}. To decouple your navigation from the
 * actual {@link UiController} implementations, it is recommended to define them as constants in a places class per
 * component or module. {@link UiController}s may have mandatory or optional {@link #getParameter(String) parameters}.
 * Therefore, it is recommended to create {@code factory methods} for your {@link UiPlace}s in the places class defining
 * the constants that take the parameter values as properly typed arguments. This will make refactoring easier if
 * parameters need to be changed. For generic access to your parameters please also define <code>PARAMETER_*</code>
 * constants in your places class.
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

  /** The separator for key and value of a {@link #getParameter(String) parameter}. */
  public static final char SEPARATOR_VALUE = '=';

  /** The regex pattern used to assert {@link #getParameter(String) parameter keys}. */
  public static final String PATTERN_KEY = "[^;:=&/]+";

  /** The regex pattern used to assert {@link #getParameter(String) parameter values}. */
  public static final String PATTERN_VALUE = "[^;]*";

  /** @see UiController#PATTERN_DIALOG_ID */
  public static final String PATTERN_DIALOG_ID = UiController.PATTERN_DIALOG_ID;

  private final String dialogId;

  private Map<String, String> parameters;

  /**
   * The constructor.
   *
   * @param dialogId - see {@link #getId()}.
   */
  public UiPlace(String dialogId) {

    this(dialogId, null);
  }

  /**
   * The constructor.
   *
   * @param dialogId - see {@link #getId()}.
   * @param parameters - see {@link #getParameters()}.
   */
  protected UiPlace(String dialogId, Map<String, String> parameters) {

    super();
    if (!dialogId.matches(PATTERN_DIALOG_ID)) {
      throw new IllegalArgumentException(dialogId);
    }
    this.dialogId = dialogId;
    if (parameters == null) {
      this.parameters = null;
    } else {
      this.parameters = Collections.unmodifiableMap(parameters);
    }
  }

  /**
   * @return the {@link UiController#getId() ID} of the {@link UiController}.
   */
  @Override
  public final String getId() {

    return this.dialogId;
  }

  /**
   * @return the parameterMap
   */
  protected Map<String, String> getParameters() {

    return this.parameters;
  }

  /**
   * This method determines if a {@link #getParameter(String)} is present (!= null).
   *
   * @param key is the name of the parameter to test.
   * @return <code>true</code> if that parameter is present (NOT <code>null</code>), <code>false</code> otherwise.
   */
  public boolean hasParameter(String key) {

    // we do not accept null values as present parameters...
    return (getParameter(key) != null);
  }

  /**
   * This method gets a parameter of this {@link UiPlace}.
   *
   * @param key is the name of the requested parameter.
   * @return the value of the requested parameter. Will be <code>null</code> if NOT set.
   */
  public String getParameter(String key) {

    String value = null;
    if (this.parameters != null) {
      value = this.parameters.get(key);
    }
    return value;
  }
  //
  // /**
  // * This method gets a typed parameter of this {@link DialogPlace}.
  // *
  // * @param <T> is the generic type of the desired parameter value.
  // *
  // * @param key is the name of the requested parameter.
  // * @param type is the desired type of the parameter
  // * @return the value of the requested parameter converted to the given <code>type</code>. Will be <code>null</code>
  // if
  // * NOT set.
  // */
  // public <T> T getParameter(String key, Class<T> type) {
  //
  // String value = getParameter(key);
  // if (value == null) {
  // return null;
  // }
  // if ((type != String.class) && (value.isEmpty())) {
  // return null;
  // }
  // return getValueConverter().convert(value, this.dialogId + "@" + key, type);
  // }

  @Override
  public int hashCode() {

    return Objects.hash(this.dialogId, this.parameters);
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
    return Objects.equals(this.dialogId, other.dialogId) && Objects.equals(this.parameters, other.parameters);
  }

  @Override
  public String toString() {

    if (this.parameters == null) {
      return this.dialogId;
    } else {
      StringBuilder buffer = new StringBuilder(this.dialogId);
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
      String dialogId = place.substring(0, stateIndex);
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
      return new UiPlace(dialogId, parameters);
    }
  }

  /**
   * Creates a {@link Map} with the given parameter.
   *
   * @param key is the {@link #getParameter(String) name of the parameter}.
   * @param value is the {@link #getParameter(String) value of the parameter}.
   * @return a new {@link Map} with the given parameter.
   */
  protected static Map<String, String> newParameter(String key, Object value) {

    return newParameter(key, value, true);
  }

  /**
   * Creates a {@link Map} with the given parameter.
   *
   * @param key is the {@link #getParameter(String) name of the parameter}.
   * @param value is the {@link #getParameter(String) value of the parameter}. May be <code>null</code> if
   *        <code>required</code> is <code>false</code>. Then an empty {@link Map} is returned. Use the empty
   *        {@link String} instead of <code>null</code> to prevent this.
   * @param required - if <code>false</code> the given <code>value</code> may be <code>null</code>, <code>true</code> if
   *        the parameter is required and an exception shall be thrown if <code>value</code> is <code>null</code>.
   * @return a new {@link Map} with the given parameter.
   */
  protected static Map<String, String> newParameter(String key, Object value, boolean required) {

    Map<String, String> parameters = new HashMap<>();
    return addParameter(parameters, key, value, required);
  }

  /**
   * Adds the given parameter to the given {@link Map}.
   *
   * @param parameters is the map with the current parameters.
   * @param key is the {@link #getParameter(String) name of the parameter}.
   * @param value is the {@link #getParameter(String) value of the parameter}.
   * @return the given <code>parameters</code> {@link Map}.
   */
  protected static Map<String, String> addParameter(Map<String, String> parameters, String key, Object value) {

    return addParameter(parameters, key, value, true);
  }

  /**
   * Adds the given parameter to the given {@link Map}.
   *
   * @param parameters is the map with the current parameters.
   * @param key is the {@link #getParameter(String) name of the parameter}.
   * @param value is the {@link #getParameter(String) value of the parameter}. May be <code>null</code> for generic
   *        usage with optional parameter. Then the given {@link Map} is returned unchanged. Use the empty
   *        {@link String} instead of <code>null</code> to prevent this.
   * @param required - if <code>false</code> the given <code>value</code> may be <code>null</code>, <code>true</code> if
   *        the parameter is required and an exception shall be thrown if <code>value</code> is <code>null</code>.
   * @return the given <code>parameters</code> {@link Map}.
   */
  protected static Map<String, String> addParameter(Map<String, String> parameters, String key, Object value,
      boolean required) {

    Objects.requireNonNull(key, "key");
    if (parameters.containsKey(key)) {
      throw new DuplicateObjectException(value, key, parameters.get(key));
    }
    if (value != null) {
      parameters.put(key, value.toString());
    } else if (required) {
      throw new ObjectNotFoundException("value", key);
    }
    return parameters;
  }

}