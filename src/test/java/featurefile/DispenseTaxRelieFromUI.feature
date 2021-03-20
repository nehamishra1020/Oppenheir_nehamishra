Feature: Governor to dispense TaxRelief from UI 

  @tag=Dispensetax
  Scenario: Dispense Tax Relief
    Given Navigate to the URL
    When Click on the Dispense Now in UI 
    Then Verify the text
    Then Close the browser
  