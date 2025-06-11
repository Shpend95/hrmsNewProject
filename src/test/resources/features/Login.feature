Feature: Login related scenarios

  @smoke
  Scenario: Valid admin login
   # Given user is navigated to HRMS application
    When user enters valid username and password
    And user cicks on login button
    Then user is successfully logged in

    @featureFileLogin
    Scenario: Valid admin login from feature file
      When user enters "admin" value and "Hum@nhrm123" value
      And user clicks on login button
      Then user is successfully logged in

      @dataDrivenFromFeatureFile
      Scenario Outline:Login multiple times
        When user enters "<username>" values and "<password>" values
        And user clicks on login button
        Then user is successfully logged in
        Examples:
        | username | password |
        |admin     |Hum@nhrm123|
        |admin     |Hum@nhrm123|
        |admin     |Hum@nhrm123|
