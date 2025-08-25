@loginOnly
Feature: Login related scenarios

  @smoke
  Scenario: Valid admin login
   # Given user is navigated to HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then user is successfully logged in


  @smoke
  Scenario: Invalid login credentials
    When user enters invalid username and invalid password
    And user clicks on login button
    Then an error message should be displayed saying invalid credentials

  @smoke
  Scenario: Password missing
    When user enters a username and leaves the password field empty
    And user clicks on login button
    Then an error message should be displayed saying Password is empty

  @smoke
  Scenario: Username missing
    When user enters a password and leaves the username field empty
    And user clicks on login button
    Then an error message should be displayed saying Username is required

  @featureFileLogin @smoke
  Scenario: Valid admin login from feature file
    When user enters "admin" value and "Hum@nhrm123" value
    And user clicks on login button
    Then user is successfully logged in

  @dataDrivenFromFeatureFile @smoke
  Scenario Outline:Login multiple times
    When user enters "<username>"  and "<password>"
    And user clicks on login button
    Then user is successfully logged in
    Examples:
      | username | password    |
      | admin    | Hum@nhrm123 |
      | admin    | Hum@nhrm123 |
      | admin    | Hum@nhrm123 |




