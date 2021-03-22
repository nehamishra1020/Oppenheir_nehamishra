Feature: Insert Record

  @Multiple
  Scenario: Multiple entry in Hero Record
    Given Post the API
    When Provide Valid  multiple details
    Then Status_code equals 202
   