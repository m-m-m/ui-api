/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.media;

import io.github.mmm.ui.attribute.AttributeManageMedia;
import io.github.mmm.ui.datatype.media.UiMedia;
import io.github.mmm.ui.widget.UiWidget;

/**
 * Abstract {@link UiWidget} for a media player.
 *
 * @since 1.0.0
 */
public abstract interface UiMediaWidget extends UiAbstractMediaWidget, AttributeManageMedia {

  /**
   * @return the {@link UiMedia} or {@code null} in not {@link #setMedia(UiMedia) set}.
   */
  UiMedia getMedia();

  /**
   * @param media the {@link UiMedia} to set and load.
   */
  void setMedia(UiMedia media);

}
