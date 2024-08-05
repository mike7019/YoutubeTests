Feature: filling the form on Youtube

  Background:

  Scenario Outline: Heading to Youtube.com
    Given Mike was on the <website>
    Examples:
      | website                  |
      | https://www.youtube.com/ |

  Scenario: filling out the login form
    When He attemps to sign in
    Then will see the code request message on screen
