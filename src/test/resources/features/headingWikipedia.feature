Feature: validating the Wikipedia Welcome header

  Scenario Outline: Heading to wikipedia.org
    Given Mike was on the <website>
    Examples:
      | website                                         |
      | https://es.wikipedia.org/wiki/Wikipedia:Portada |

  Scenario Outline: filling out the login form
    Then will see welcome <message> on screen
    Examples:
      | message     |
      | Bienvenidos |

