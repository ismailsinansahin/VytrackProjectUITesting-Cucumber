@dashboard
  Feature: The user should be able to use Dashboard page efficiently
    Description: The purpose of this feature is to test the Dashboard page functionality

  Background:
    Given The user should be login as a "Store Manager"
    Given The user should be able to navigate to "Dashboards" "Dashboard"
    Then The user should be on the "Dashboards" "Dashboard" "Dashboard"

    Scenario Outline: Quick Launchpad functionality
      When The user click on "<shortcut>"
      Then The user should be on the "<moduleName>" "<tabName>" "<title>"
      Examples:
        | shortcut      | moduleName | tabName       | title         |
        | Accounts      | Customers  | Accounts      | Accounts      |
        | Contacts      | Customer   | Contacts      | Contacts      |
        | Opportunities | Sales      | Opportunities | Opportunities |