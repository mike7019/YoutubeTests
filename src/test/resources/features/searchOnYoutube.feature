Feature: Search and validation on Youtube

  Background:

  Scenario Outline: Heading to Youtube.com
    Given Mike was on the <website>
    Examples:
      | website                  |
      | https://www.youtube.com/ |

  Scenario Outline: Successful search and validation on the site
    When He searches for the song to listen
      | song   |
      | <song> |
    Then validates that the <song> is contained within the site
    Examples:
       | song                 |
       | Locked Out Of Heaven |