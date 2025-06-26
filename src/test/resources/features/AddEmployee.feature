Feature: Adding employees using different techniques

  Background:
   #Given user is navigated to HRMS application   # this is called and executed in Hooks as pre condition
    When user enters valid username and password
    And user clicks on login button
    Then user is successfully logged in
    When user click on PIM option
    When user clicks on Add Employee option


  @addemployee @regression @UIDT
  Scenario: Adding an employee in HRMS system
    When user enters firstname and middlename and lastname
    And user clicks on save button
    Then employee is added successfully


  @valuesFromFF @regression
  Scenario: Adding employee from feature file
    When user enter "DONALD" ,"J" and "TRUMP"
    And user clicks on save button
    Then employee added successfully

  @DataDrivenTesting @regression
  Scenario Outline: Adding employees using data driven testing
    When user enters "<firstname>" and "<middlename>" and "<lastname>"
    And user clicks on save button
    Then employee added successfully
    Examples:
      | firstname | middlename | lastname |
      | Eric      | Adams      | Junior   |
      | DAVID     | Michael    | JR       |
      | Manual    | Ramirez    | Sr       |
      | Paul      | Nune       | Sr       |
      | Cristiano | Messi      | BS       |

  @DataTableHead @regression
  Scenario: Adding multiple employees using data table
    When user enters firstname, middlename and lastname from data table and verifies it
      | firstname | middlename | lastname |
      | Sara      | Alfredo    | Xeni     |
      | Alexa     | SM         | Marun    |
      | Tia       | Myself     | Lorad    |
      | Mia       | Lori       | Ricos    |

  @excelData @regression
  Scenario: Adding employees from excel file
    When user adds multiple employees from excel and validates them


  @createLoginDetails @regression
  Scenario: Adding employee and creating login details
    When user enters firstname,middlename,lastname,ID and photo
    And user clicks on create login details button
    And user enter username,password and confirms password and enables status
    And user click on the save button
    Then the employee is created successfully with login credentials




