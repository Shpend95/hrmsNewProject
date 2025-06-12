Feature: Modifying leaves

  Background:
    Given user is logged in and on dashboard page
    When user cliks on leave button


    @newAssign @smoke
    Scenario:Assigning for leave
      When user clicks on assign leave button
      And user enters the name of employee,leave reason,dates and comments
      And user clicks on assign button
      Then user should see a successfully assingned message
