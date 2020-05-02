/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.controller;

/**
 * Node in the navigation history containing the {@link #getPlace() place}.
 *
 * @since 1.0.0
 */
public class UiControllerHistoryNode {

  private final UiPlace place;

  private UiControllerHistoryNode previous;

  private UiControllerHistoryNode next;

  /**
   * The constructor.
   *
   * @param value the initial {@link #getPlace() value}.
   */
  public UiControllerHistoryNode(UiPlace value) {

    super();
    this.place = value;
  }

  /**
   * @return the value (element) stored in this {@link UiControllerHistoryNode}.
   */
  public UiPlace getPlace() {

    return this.place;
  }

  /**
   * @return the previous node. Will be {@code null} if this is the first node.
   */
  public UiControllerHistoryNode getPrevious() {

    return this.previous;
  }

  /**
   * @param previous new value of {@link #getPrevious()}.
   */
  public void setPrevious(UiControllerHistoryNode previous) {

    this.previous = previous;
  }

  /**
   * @return the next node. Will be {@code null} if this is the last node.
   */
  public UiControllerHistoryNode getNext() {

    return this.next;
  }

  /**
   * @param next new value of {@link #getNext()}.
   */
  public void setNext(UiControllerHistoryNode next) {

    this.next = next;
  }

}
