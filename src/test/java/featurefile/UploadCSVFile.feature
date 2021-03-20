Feature: Upload the CSV file to UI 

  @uploadfile
  Scenario: Upload CSV with data
    Given Navigate to the URL
    When Click on the upload button
    Then Upload the CSV file
    Then Close the browser
  