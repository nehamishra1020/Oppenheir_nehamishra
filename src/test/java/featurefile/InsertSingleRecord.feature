Feature: Insert Record

  @tag1
  Scenario: Single entry in Hero Record
    Given Post the API
    When Provide Valid details
    Then Status_code equals 202
   