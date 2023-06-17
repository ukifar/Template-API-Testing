Feature: DELETE User
  @Tugas @Positive-Case
  Scenario Outline: Delete user with valid parameter should success then return 204 response code
    Given Delete user with valid id <id>
    When Send delete user
    Then Status code should be 204 No Content
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas @Negative-Case
  Scenario Outline: Delete user with invalid parameter should failed then return 400 response code
    Given Delete user with invalid id "<id>"
    When Send delete user
    Then Status code should be 400 Bad Request
    Examples:
      | id     |
      | JVytUX |
      | $%^*%* |