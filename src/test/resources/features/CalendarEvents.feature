@calendarEvents
Feature: Calendar Events Page Functionality
  Description: The purpose of this feature is to test the Calendar Events Page functionality

  Background:
    Given The user should be login as a "Store Manager"
    Given The user should be able to navigate to "Activities" "Calendar Events"
    Then The user should be on the "Activities" "Calendar Events" "Calendar Events"

  Scenario: The user should be see the correct options on the Calendar Events Page
    Then The user should be able to see the "Activities/ " as a page name
    And The user should be able to see the default page number as "1"
    And The user should be able to see the default view per page number as "25"
