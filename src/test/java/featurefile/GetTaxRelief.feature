Feature: Get Tax Relief 

  @gettax
  Scenario: Get Tax Relief
    Given Hit the Get API
    Then Status_code equals 200