Feature: Employee search related scenarios

  Background:
    #Given user is navigated to HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then user is successfully logged in
    When user click on PIM option


  @regression2
  Scenario: Search employee by id
    When user enter valid employee id
    And user clicks on search button
    Then user is able to see the employee information

  @regression2
  Scenario: Search employee by name
    When user enter valid employee name
    And user clicks on search button
    Then user is able to see the employee information

