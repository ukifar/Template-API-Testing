Feature: PUT Update User
  @Tugas @Positive-Case
  Scenario Outline: Put update user with valid json and id should success then return 200 response code
    Given Put update user with valid json and id <id>
    When Send put update user
    Then Status code should be 200 OK
    And Response body name was "Faruqi Rabbani" and job was "QA Engineer"
    And Validate put update user JSON Schema
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas @Negative-Case
  Scenario: Put update user with invalid json should failed then return 400 response code
    Given Put update user with valid id 2 and invalid json
    When Send put update user
    Then Status code should be 400 Bad Request

  @Tugas @Negative-Case
  Scenario: Put update user with blank name and job should failed then return 400 response code
    Given Put update user with empty name and job with id 2
    When Send put update user
    Then Status code should be 400 Bad Request
