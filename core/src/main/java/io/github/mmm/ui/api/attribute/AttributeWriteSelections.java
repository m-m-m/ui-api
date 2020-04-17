/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Interface to {@link #getSelections() read} and {@link #setSelections(Collection) write} a {@link #getSelections()
 * multi-selection}.
 *
 * @param <V> type of the elements to select.
 * @since 1.0.0
 */
public abstract interface AttributeWriteSelections<V> extends AttributeReadSelections<V> {

  /**
   * @param selection is the {@link Collection} of elements to select.
   * @see #getSelections()
   */
  void setSelections(Collection<V> selection);

  /**
   * @param element the selement to add to the current selection.
   * @see #setSelections(Collection)
   */
  default void addSelection(V element) {

    if (element == null) {
      return;
    }
    List<V> selections = getSelections();
    if (selections.isEmpty()) {
      setSelections(Collections.singletonList(element));
    } else if (!selections.contains(element)) {
      selections.add(element);
      setSelections(selections);
    }
  }

  /**
   * @param elements the {@link Collection} of elements to add to the current selection.
   * @see #setSelections(Collection)
   */
  default void addSelections(Collection<V> elements) {

    if ((elements == null) || elements.isEmpty()) {
      return;
    }
    List<V> selections = getSelections();
    if (selections.isEmpty()) {
      setSelections(elements);
    } else {
      Set<V> set = new HashSet<>(selections.size() + elements.size());
      set.addAll(selections);
      set.addAll(elements);
      setSelections(set);
    }
  }

}
