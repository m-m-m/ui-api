/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.api.notify;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.Instant;
import java.util.Objects;

import io.github.mmm.base.exception.ApplicationException;
import io.github.mmm.nls.exception.TechnicalErrorUserException;

/**
 * A notification that for display as growl or popup.
 *
 * @since 1.0.0
 */
public class UiNotification {

  private final Instant timestamp;

  private final String message;

  private final UiSeverity severity;

  private final String title;

  private final String uuid;

  private final String traceId;

  private final String code;

  private final String details;

  /**
   * The constructor.
   *
   * @param timestamp the {@link #getTimestamp() timestamp}.
   * @param message the {@link #getMessage() message}.
   * @param severity the {@link #getSeverity() severity}.
   * @param title the optional {@link #getTitle() title}.
   * @param details the optional {@link #getDetails() details}.
   * @param uuid the optional {@link #getUuid() uuid}.
   * @param code the optional {@link #getCode() code}.
   * @param traceId the optional {@link #getTraceId() trace ID}.
   */
  protected UiNotification(Instant timestamp, String message, UiSeverity severity, String title, String details,
      String uuid, String code, String traceId) {

    super();
    Objects.requireNonNull(message, "message");
    Objects.requireNonNull(severity, "severity");
    this.timestamp = timestamp;
    this.message = message;
    this.severity = severity;
    if (title == null) {
      this.title = severity.getName();
    } else {
      this.title = title;
    }
    this.uuid = uuid;
    this.traceId = traceId;
    this.code = code;
    if (details == null) {
      this.details = "";
    } else {
      this.details = details;
    }
  }

  /**
   * @return the {@link Instant} when this notification has been created.
   */
  public Instant getTimestamp() {

    return this.timestamp;
  }

  /**
   * @return the {@link UiSeverity severity} of this notification.
   */
  public UiSeverity getSeverity() {

    return this.severity;
  }

  /**
   * @return the title to be displayed in the title-bar of the popup or growl window.
   */
  public String getTitle() {

    return this.title;
  }

  /**
   * @return id the optional ID correlating to this notification.
   * @see io.github.mmm.base.exception.ApplicationException#getUuid()
   */
  public String getUuid() {

    return this.uuid;
  }

  /**
   * @return code the optional code.
   * @see io.github.mmm.base.exception.ApplicationException#getCode()
   */
  public String getCode() {

    return this.code;
  }

  /**
   * @return the optional ID for tracing server invocations (e.g. using open-tracing).
   */
  public String getTraceId() {

    return this.traceId;
  }

  /**
   * @return the actual message describing the notification.
   */
  public String getMessage() {

    return this.message;
  }

  /**
   * @return the optional details.
   */
  public String getDetails() {

    return this.details;
  }

  @Override
  public String toString() {

    StringBuilder sb = new StringBuilder(this.message.length() + this.details.length() + 32);
    sb.append('[');
    sb.append(this.severity);
    sb.append("]:");
    sb.append(this.message);
    sb.append("\n[");
    sb.append(this.timestamp);
    sb.append(']');
    if (this.uuid != null) {
      sb.append('{');
      sb.append(this.uuid);
      sb.append('}');
    }
    if (this.code != null) {
      sb.append('<');
      sb.append(this.code);
      sb.append('>');
    }
    if (this.traceId != null) {
      sb.append('(');
      sb.append(this.traceId);
      sb.append(')');
    }
    sb.append(":\n");
    sb.append(this.details);
    return sb.toString();
  }

  /**
   * @param message the {@link #getMessage() message}.
   * @return the {@link UiNotification} with {@link UiSeverity#INFORMATION}.
   */
  public static UiNotification ofInfo(String message) {

    return ofInfo(message, null);
  }

  /**
   * @param message the {@link #getMessage() message}.
   * @param title the {@link #getTitle() title}.
   * @return the {@link UiNotification} with {@link UiSeverity#INFORMATION}.
   */
  public static UiNotification ofInfo(String message, String title) {

    return of(message, UiSeverity.INFORMATION, title);
  }

  /**
   * @param message the question {@link #getMessage() message}.
   * @return the {@link UiNotification} with {@link UiSeverity#QUESTION}.
   */
  public static UiNotification ofQuestion(String message) {

    return of(message, UiSeverity.QUESTION);
  }

  /**
   * @param message the question {@link #getMessage() message}.
   * @param title the {@link #getTitle() title}.
   * @return the {@link UiNotification} with {@link UiSeverity#QUESTION}.
   */
  public static UiNotification ofQuestion(String message, String title) {

    return of(message, UiSeverity.QUESTION, title);
  }

  /**
   * @param message the {@link #getMessage() message}.
   * @return the {@link UiNotification} with {@link UiSeverity#WARNING}.
   */
  public static UiNotification ofWarning(String message) {

    return ofWarning(message, null);
  }

  /**
   * @param message the {@link #getMessage() message}.
   * @param title the {@link #getTitle() title}.
   * @return the {@link UiNotification} with {@link UiSeverity#WARNING}.
   */
  public static UiNotification ofWarning(String message, String title) {

    return of(message, UiSeverity.WARNING, title);
  }

  /**
   * @param message the {@link #getMessage() message}.
   * @return the {@link UiNotification} with {@link UiSeverity#ERROR}.
   */
  public static UiNotification ofError(String message) {

    return of(message, UiSeverity.ERROR);
  }

  /**
   * @param error the {@link Throwable} that occurred.
   * @return the new {@link UiNotification}.
   */
  public static UiNotification of(Throwable error) {

    return of(error, UiSeverity.ERROR);
  }

  /**
   * @param error the {@link Throwable} that occurred.
   * @param severity the {@link #getSeverity() severity} use {@link #of(Throwable)} for {@link UiSeverity#ERROR} so only
   *        {@link UiSeverity#WARNING} or a custom severity might make sense here.
   * @return the new {@link UiNotification}.
   */
  public static UiNotification of(Throwable error, UiSeverity severity) {

    return of(error, severity, null, null);
  }

  /**
   * @param error the {@link Throwable} that occurred.
   * @param severity the {@link #getSeverity() severity} use {@link #of(Throwable)} for {@link UiSeverity#ERROR} so only
   *        {@link UiSeverity#WARNING} or a custom severity might make sense here.
   * @param title the {@link #getTitle() title}.
   * @param traceId the optional {@link #getTraceId() trace ID}.
   * @return the new {@link UiNotification}.
   */
  public static UiNotification of(Throwable error, UiSeverity severity, String title, String traceId) {

    StringWriter sw = new StringWriter(256);
    error.printStackTrace(new PrintWriter(sw));
    String details = sw.toString();
    String id;
    String code;
    if (error instanceof ApplicationException) {
      ApplicationException appError = (ApplicationException) error;
      id = appError.getUuid().toString();
      code = appError.getCode();
    } else {
      id = null;
      code = TechnicalErrorUserException.CODE;
    }
    return of(error.getLocalizedMessage(), severity, title, details, id, code, traceId);
  }

  /**
   * @param message the {@link #getMessage() message}.
   * @param severity the {@link #getSeverity() severity}.
   * @return the new {@link UiNotification}.
   */
  public static UiNotification of(String message, UiSeverity severity) {

    return of(message, severity, null, null, null, null, null);
  }

  /**
   * @param message the {@link #getMessage() message}.
   * @param severity the {@link #getSeverity() severity}.
   * @param title the {@link #getTitle() title}.
   * @return the new {@link UiNotification}.
   */
  public static UiNotification of(String message, UiSeverity severity, String title) {

    return of(message, severity, title, null, null, null, null);
  }

  /**
   * @param message the {@link #getMessage() message}.
   * @param severity the {@link #getSeverity() severity}.
   * @param title the {@link #getTitle() title}.
   * @param details the {@link #getDetails() details}.
   * @param id the {@link #getUuid() id}.
   * @param code the {@link #getCode() code}.
   * @param traceId the optional {@link #getTraceId() trace ID}.
   * @return the new {@link UiNotification}.
   */
  public static UiNotification of(String message, UiSeverity severity, String title, String details, String id,
      String code, String traceId) {

    return new UiNotification(Instant.now(), message, severity, title, details, id, code, traceId);
  }

}
