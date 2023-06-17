Feature: LOGIN User
  @Tugas @Positive-Case
  Scenario Outline: User login with registered email and password should success then return 200 response code
    Given User login with valid email and password
    When Send request post login user
    Then Should return status code 200
    And Response body token should be "<token>"
    And Validate json schema success login user
    Examples:
    |token|
    |QpwL5tke4Pnpja7X4     |

  @Tugas @Negative-Case
  Scenario Outline: User login with registered email and blank password should failed then return 400 response code
    Given User login with valid email and blank password
    When Send request post login user
    Then Should return status code 400
    And Response error body should be "<error>"
    And Validate json schema failed login user with registered email and blank password
    Examples:
      |error|
      |Missing password     |

  @Tugas @Negative-Case
  Scenario: User login with unregistered email and password should failed then return 400 response code
    Given User login with unregistered email and password
    When Send request post login user
    Then Should return status code 400
    And Validate json schema failed login user with unregistered email and password