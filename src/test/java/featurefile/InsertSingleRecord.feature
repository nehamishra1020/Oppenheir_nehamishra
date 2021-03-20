Feature: Insert Record

  @tag=Single
  Scenario: Single entry in Hero Record
    Given Post the API
    When Provide Valid details
    Then Status_code equals 200
    Then response contains IsLogin equals "true"