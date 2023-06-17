Feature: GET List User
  @Tugas @Positive-Case
  Scenario Outline: Get list users with valid parameter page should success then return 200 response code
    Given Get list users with valid parameter page <page>
    When Send get lists users
    Then Status code should be 200 OK
    And Response body page should be page <page>
    And Validate get list user JSON Schema
    Examples:
      | page |
      | 1    |
      | 2    |

  @Tugas @Negative-Case
  Scenario Outline: Get list users with invalid parameter should failed then return 404 response code
    Given Get list users with page "<page>"
    When Send get lists users
    Then Should return status code 404 Not Found
    Examples:
      | page      |
      | 1adsf1341 |
      | !$#asd    |