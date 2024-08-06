Feature: Testing the account creation

  Scenario Outline: Heading to wikipedia.org
    Given Mike was on the <website>
    Examples:
      | website                                         |
      | https://es.wikipedia.org/wiki/Wikipedia:Portada |

  Scenario Outline: filling out the login form
    When he attempts to create the account
    Then will validate the captcha popup with <message>
    Examples:
      | message             |
      | Please fill out this field. |

