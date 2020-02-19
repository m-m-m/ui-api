/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.widget.attribute;

import io.github.mmm.ui.widget.UiWidget;

/**
 * {@link UiWidget} that has an {@link #getAutocomplete() autocompletion} (config).
 *
 * @since 1.0.0
 */
public interface UiWidgetWithAutocomplete extends UiWidget {

  /** {@link #getAutocomplete() Autocomplete} turned off. */
  String AUTOCOMPLETE_OFF = "off";

  /**
   * {@link #getAutocomplete() Autocomplete} for the <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-username">username</a>
   * (login).
   */
  String AUTOCOMPLETE_USERNAME = "username";

  /**
   * {@link #getAutocomplete() Autocomplete} for a <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-new-password">new
   * password</a> (during account registration).
   */
  String AUTOCOMPLETE_NEW_PASSWORD = "new-password";

  /**
   * {@link #getAutocomplete() Autocomplete} for the <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-current-password">current
   * password</a> (during login).
   */
  String AUTOCOMPLETE_CURRENT_PASSWORD = "current-password";

  /**
   * {@link #getAutocomplete() Autocomplete} for the <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-given-name">given
   * name</a> (first name) of a person.
   */
  String AUTOCOMPLETE_GIVEN_NAME = "given-name";

  /**
   * {@link #getAutocomplete() Autocomplete} for the <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-family-name">family
   * name</a> (last name) of a person.
   */
  String AUTOCOMPLETE_FAMILY_NAME = "family-name";

  /**
   * {@link #getAutocomplete() Autocomplete} for the <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-organization-title">organization
   * title</a> (job title) of a person.
   */
  String AUTOCOMPLETE_JOB_TITLE = "organization-title";

  /**
   * {@link #getAutocomplete() Autocomplete} for the <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-honorific-prefix">honorific
   * prefix</a> (prefix or title) of a person.
   */
  String AUTOCOMPLETE_HONORIFIC_PREFIX = "honorific-prefix";

  /**
   * {@link #getAutocomplete() Autocomplete} for the <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-nickname">nickname</a>
   * (e.g. pseudonym) of a person.
   */
  String AUTOCOMPLETE_NICKNAME = "nickname";

  /**
   * {@link #getAutocomplete() Autocomplete} for a <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-country">alpha-2
   * country code</a>.
   */
  String AUTOCOMPLETE_COUNTRY_CODE = "country";

  /**
   * {@link #getAutocomplete() Autocomplete} for a <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-country-name">country
   * name</a>.
   */
  String AUTOCOMPLETE_COUNTRY_NAME = "country-name";

  /**
   * {@link #getAutocomplete() Autocomplete} for a <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-language">language
   * code</a> (locale).
   */
  String AUTOCOMPLETE_LANGUAGE_CODE = "language";

  /**
   * {@link #getAutocomplete() Autocomplete} for a <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-postal-code">postal
   * code</a> (ZIP).
   */
  String AUTOCOMPLETE_POSTAL_CODE = "postal-code";

  /**
   * {@link #getAutocomplete() Autocomplete} for a <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-street-address">street
   * address</a>.
   */
  String AUTOCOMPLETE_STREET = "street-address";

  /**
   * {@link #getAutocomplete() Autocomplete} for an <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-organization">organization</a>
   * (company name).
   */
  String AUTOCOMPLETE_ORGANIZATION = "organization";

  /**
   * {@link #getAutocomplete() Autocomplete} for an <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-url">URL</a>.
   */
  String AUTOCOMPLETE_URL = "url";

  /**
   * {@link #getAutocomplete() Autocomplete} for an <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-email">E-mail
   * address</a>.
   */
  String AUTOCOMPLETE_EMAIL = "email";

  /**
   * {@link #getAutocomplete() Autocomplete} for a <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-tel">telephone
   * number</a>.
   */
  String AUTOCOMPLETE_TELEPHONE = "tel";

  /**
   * {@link #getAutocomplete() Autocomplete} for an <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-impp">instant
   * messaging and presence protocol</a>.
   */
  String AUTOCOMPLETE_IMPP = "impp";

  /**
   * {@link #getAutocomplete() Autocomplete} for the <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-bday">birthday</a>.
   */
  String AUTOCOMPLETE_BIRTHDAY = "bday";

  /**
   * {@link #getAutocomplete() Autocomplete} for the
   * <a href= "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-sex">sex</a>
   * (gender).
   */
  String AUTOCOMPLETE_SEX = "sex";

  /**
   * {@link #getAutocomplete() Autocomplete} for a <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-transaction-currency">transaction
   * currency</a>.
   */
  String AUTOCOMPLETE_TX_CURRENCY = "transaction-currency";

  /**
   * {@link #getAutocomplete() Autocomplete} for a <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-transaction-amount">transaction
   * amount</a>.
   */
  String AUTOCOMPLETE_TX_AMOUNT = "transaction-amount";

  /**
   * {@link #getAutocomplete() Autocomplete} for a <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-cc-number">credit-card
   * number</a>.
   */
  String AUTOCOMPLETE_CC_NUMBER = "cc-number";

  /**
   * {@link #getAutocomplete() Autocomplete} for a <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-cc-exp">credit-card
   * expiry date</a>.
   */
  String AUTOCOMPLETE_CC_EXPIRY = "cc-exp";

  /**
   * {@link #getAutocomplete() Autocomplete} for a <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-cc-csc">credit-card
   * security code</a>.
   */
  String AUTOCOMPLETE_CC_CSC = "cc-csc";

  /**
   * {@link #getAutocomplete() Autocomplete} for a <a href=
   * "https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#attr-fe-autocomplete-cc-type">credit-card
   * type</a>.
   */
  String AUTOCOMPLETE_CC_TYPE = "cc-type";

  /**
   * @return the autocompletion configuration of this widget.
   */
  String getAutocomplete();

  /**
   * @param autocomplete is the new value of {@link #getAutocomplete()}.
   */
  void setAutocomplete(String autocomplete);

  /**
   * Disables autocompletion entirely by {@link #setAutocomplete(String) setting} to {@link #AUTOCOMPLETE_OFF}.
   */
  default void setAutocompleteOff() {

    setAutocomplete(AUTOCOMPLETE_OFF);
  }

}
