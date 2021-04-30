@login
Feature: Login Functionality
  Description: The purpose of this feature is to test the Login functionality

  @positiveLogin
  Scenario Outline: The user should be able to login with valid credentials
    Then the user should be able to login with valid credentials "<username>" "<password>"
    Examples:
      | username        | password    |
      | User1           | UserUser123 |
      | salesmanager115 | UserUser123 |
      | storemanager85  | UserUser123 |

  @negativeLoginWithInvalidCredentials
  Scenario Outline: The user should NOT be able to login with invalid credentials
    Then the user should NOT be able to login with invalid credentials "<username>" "<password>"
    Examples:
      | username         | password         |
      | username         | invalid password |
      | invalid username | password         |

  @negativeLoginWithBlankCredentials
  Scenario Outline: The user should NOT be able to login with invalid credentials
    Then the user should NOT be able to login with blank credentials "<username>" "<password>"
    Examples:
      | username         | password         |
      | username         | blank password   |
      | blank username   | password         |