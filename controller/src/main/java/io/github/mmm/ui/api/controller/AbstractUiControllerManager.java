/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;

import io.github.mmm.base.exception.DuplicateObjectException;
import io.github.mmm.base.exception.ObjectNotFoundException;
import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.api.widget.composite.UiMutableSingleComposite;

/**
 * Implementation of {@link UiControllerManager}.
 *
 * @since 1.0.0
 */
public abstract class AbstractUiControllerManager implements UiControllerManager {

  private final Map<String, AbstractUiController<?>> id2controllerMap;

  private final Map<String, AbstractUiController<?>> type2controllerMap;

  private UiPlace currentPlace;

  /**
   * The constructor.
   */
  @SuppressWarnings("rawtypes")
  public AbstractUiControllerManager() {

    super();
    this.id2controllerMap = new HashMap<>();
    this.type2controllerMap = new HashMap<>();
    ServiceLoader<AbstractUiController> serviceLoader = ServiceLoader.load(AbstractUiController.class);
    for (AbstractUiController<?> controller : serviceLoader) {
      register(controller);
    }
  }

  private void register(AbstractUiController<?> controller) {

    String id = controller.getId();
    AbstractUiController<?> existing = this.id2controllerMap.put(id, controller);
    if (existing != null) {
      throw new DuplicateObjectException(controller, id, existing);
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public <W extends UiWidget> AbstractUiController<W> getController(String id) {

    return (AbstractUiController<W>) this.id2controllerMap.get(id);
  }

  @Override
  public <W extends UiWidget> AbstractUiController<W> getRequiredController(String id) {

    AbstractUiController<W> controller = getController(id);
    if (controller == null) {
      throw new ObjectNotFoundException("UiController", id);
    }
    return controller;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <W extends UiWidget> UiController<W> getCurrentDialog(String type) {

    return (UiController<W>) this.type2controllerMap.get(type);
  }

  @Override
  public UiPlace getCurrentPlace() {

    return this.currentPlace;
  }

  @Override
  public void navigateTo(UiPlace place) {

    // TODO
    Objects.requireNonNull(place, "place");
    navigateRecursive(place, null);
    this.currentPlace = place;
  }

  /**
   * @param place the {@link UiPlace}.
   * @param slot the optional {@link UiControllerSlot}.
   * @return the {@link AbstractUiController} that has been {@link AbstractUiController#show(UiPlace, UiControllerSlot)
   *         shown}.
   */
  @SuppressWarnings({ "rawtypes", "unchecked" })
  protected AbstractUiController<UiWidget> navigateRecursive(UiPlace place, UiControllerSlot slot) {

    String id;
    if (slot == null) {
      id = place.getId();
    } else {
      id = slot.getId();
    }
    AbstractUiController<UiWidget> controller = getRequiredController(id);
    UiControllerSlot parentSlot = controller.show(place, slot);
    if (parentSlot != null) {
      AbstractUiController<UiWidget> parentController = navigateRecursive(place, parentSlot);
      UiMutableSingleComposite uiSlot = parentController.getSlot(parentSlot.getSlot());
      uiSlot.setChild(controller.getView());
    }
    return controller;
  }

}
