Feature: GET Single Resource
  @Tugas @Positive-Case
  Scenario Outline: Get single resource with valid parameter id should success then return 200 response code
    Given Get single resource with id <id>
    When Send request get single resource
    Then Should return status code 200 OK
    And Response body id should be <id>
    And Validate json scheme single resource with valid parameter id
    Examples:
      | id |
      | 2  |

  @Tugas @Negative-Case
  Scenario Outline: Get single resource with exceed id should failed then return 404 response code
    Given Get single resource with exceed id <id>
    When Send request get single resource
    Then Should return status code 404 Not Found
    Examples:
      | id |
      | 23 |