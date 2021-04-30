@navigateTo
Feature: The user should be able to navigate between modules and tabs
  Description: The purpose of this feature is to test the navigation functionality between modules and tabs

  Scenario: The user should be able to navigate between modules and tabs
    Given The user should be able to navigate to "module" "tab"
    Then The user should be on the "moduleName" "tabName" "title"

