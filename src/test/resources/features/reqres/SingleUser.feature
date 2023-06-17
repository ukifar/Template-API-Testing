Feature: GET Single User
  @Tugas @Positive-Case
  Scenario Outline: Get single user with valid parameter id should success then return 200 response code
    Given Get single user with id <id>
    When Send request get single user
    Then Should return status code 200 OK
    And Response body id should be <id>
    And Validate json scheme single user with valid parameter id
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas @Negative-Case
  Scenario Outline: Get single user with exceed id should failed then return 404 response code
    Given Get single user with exceed id <id>
    When Send request get single user
    Then Should return status code 404 Not Found
    Examples:
      | id  |
      | 23  |
      | 739 |

  @Tugas @Negative-Case
  Scenario Outline: Get single user with invalid parameter should failed then return 404 response code
    Given Get single user with first name "<firstName>"
    When Send requests get single user
    Then Should return status code 404 Not Found
    Examples:
      | firstName |
      | Alphonso  |
