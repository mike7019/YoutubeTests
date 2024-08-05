Feature: validating the Wikipedia Welcome header

  Scenario Outline: Heading to wikipedia.org
    Given Mike was on the <website>
    Examples:
      | website                                         |
      | https://es.wikipedia.org/wiki/Wikipedia:Portada |

  Scenario Outline: searching and validating a keyword
    When he searches for <word> and scrolls down looking for <keyword>
    Then will validate the <keyword> on screen
    Examples:
      | word    | keyword       |
      | Sistema | Análisis CEEM |
