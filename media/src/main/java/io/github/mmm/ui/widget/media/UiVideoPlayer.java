/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.media;

import io.github.mmm.ui.attribute.AttributeWriteImage;
import io.github.mmm.ui.widget.UiNativeWidget;

/**
 * This is the interface for a {@link UiMediaWidget media-player widget} that plays videos (movies). <br>
 * <b>NOTE:</b><br>
 * This widget is just the video-screen itself without controls. For simple usage see {@link UiMediaPlayer}.
 *
 * @since 1.0.0
 */
public interface UiVideoPlayer extends UiMediaWidget, AttributeWriteImage, UiNativeWidget {

  // nothing to add...

}
