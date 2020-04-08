/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.attribute;

/**
 * Interface to read {@link #getMimetype() mimetype}.
 *
 * @since 1.0.0
 */
public abstract interface AttributeReadMimetype {

  /** Supported {@link #getMimetype() mimetype} for video: {@value} */
  String MIMETYPE_VIDEO_MP4 = "video/mp4";

  /** Supported {@link #getMimetype() mimetype} for video: {@value} */
  String MIMETYPE_VIDEO_OGG = "video/ogg";

  /** Supported {@link #getMimetype() mimetype} for audio: {@value} */
  String MIMETYPE_AUDIO_OGG = "audio/ogg";

  /** Supported {@link #getMimetype() mimetype} for audio: {@value} */
  String MIMETYPE_AUDIO_MPEG = "audio/mpeg";

  /** Supported {@link #getMimetype() mimetype} for image: {@value} */
  String MIMETYPE_IMAGE_PNG = "image/png";

  /**
   * @return the mimetype of the content (e.g. {@link #MIMETYPE_VIDEO_MP4 video/mp4} , {@link #MIMETYPE_AUDIO_OGG
   *         audio/ogg}, {@link #MIMETYPE_IMAGE_PNG image/png}, "application/pdf", "text/plain").
   */
  String getMimetype();

}
