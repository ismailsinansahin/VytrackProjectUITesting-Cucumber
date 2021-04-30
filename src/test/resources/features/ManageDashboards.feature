@manageDashboards
Feature: The user should be able to use Manage Dashboard page efficiently
  Description: The purpose of this feature is to test the Manage Dashboard page functionality

  Background:
    Given The user should be login as a "Store Manager"
    Given The user should be able to navigate to "Dashboards" "Dashboard"
    Then The user should be on the "Dashboards" "Manage Dashboards" "Dashboard"

  Scenario: The user should be on the Manage Dashboards page
    Then The user should be able to see the "Dashboards/" as a page name
