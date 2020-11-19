/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

import java.util.List;

/**
 * Interface to {@link #getSelections() read} the {@link #getSelections() multi-selection}.
 *
 * @param <V> type of the elements to select.
 * @since 1.0.0
 */
public abstract interface AttributeReadSelections<V> {

  /**
   * @return the selected element(s). If nothing is selected, the {@link List#isEmpty() empty} {@link List} is returned.
   *         For best UX a multi-selection is suggested to be managed by checkboxes in front of the elements that allow
   *         adding and removing them from the multi-selection. It can still be combined with
   *         {@link AttributeReadSelection#getSelection() single-selection} that highlights the element that has been
   *         clicked last. E.g. to remove or delete multiple elements from a list, the multi-selection can be used while
   *         the single-selection will be used to open the details of the last selected element in a master-details view
   *         or in a details popup.
   */
  List<V> getSelections();

}
