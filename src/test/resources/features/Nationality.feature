Feature: Modifying nationalities

  Background:
    Given user is logged in and on Admin Page
    When user navigates to nationality creation form

  @addNationality @regression
  Scenario: Adding a new nationality and verify success message
    When user enters the name of nationality
    And user clicks on save button after entering the nationality
    Then user should see a successfully saved message on the screen

  @existingNationality @regression
  Scenario:Add an existing nationality and verify error
    When user enters the name of existing nationality
    And user clicks on the save button
    Then user should see a error message on the screen

    @deleteNationality @regression
    Scenario: Deleting an existing nationality
      When user selects the nationality
      And user clicks on delete button
      And user clicks on Ok button
      Then user should see a successfully deleted message on the screen






