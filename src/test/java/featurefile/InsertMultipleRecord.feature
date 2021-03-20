Feature: Insert Record

  @tag=Multiple
  Scenario: Multiple entry in Hero Record
    Given Post the API
    When Provide Valid  multiple details
    Then Status_code equals 200
    Then response contains IsLogin equals "true"