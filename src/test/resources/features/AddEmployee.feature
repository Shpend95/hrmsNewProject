Feature: Adding employees using different techniques

  Background:
   #Given user is navigated to HRMS application   # this is called and executed in Hooks as pre condition
    When user enters valid username and password
    And user clicks on login button
    Then user is successfully logged in
    When user click on PIM option
    When user clicks on Add Employee option


  @addemployee
  Scenario: Adding an employee in HRMS system
    When user enters firstname and middlename and lastname
    And user clicks on save button
    Then employee added successfully


  @valuesFromFF
  Scenario: Adding employee from feature file
    When user enter "shpend" ,"kosova" and "pllana"
    And user clicks on save button
    Then employee added successfully

  @DataDrivenTesting
  Scenario Outline: Adding employees using data driven testing
    When user enters "<firstname>" and "<middlename>" and "<lastname>"
    And user clicks on save button
    Then employee added successfully
    Examples:
      | firstname | middlename | lastname |
      | Mike      | Tyson      | Junior   |
      | Sam       | Tiko         | JR       |
      | Matt      | LS         | Sr       |
      | Paul      | PP         | Sr       |
      | Lionel    | MS         | BS       |

   @DataTableHead
   Scenario: Adding multiple employees using data table
     When user enters firstname, middlename and lastname from data table and verifies it
     |firstname | middlename | lastname|
     |Alex      | MS         | Xeni    |
     |Alexa     | SM         | Marun   |
     |Sabora    | MJ         | Lorad   |
     |Fabio     | LR         | Ricos   |

   @excelData
   Scenario: Adding employees from excel file
     When user adds multiple employees from excel and validates them


  @createLoginDetails
  Scenario: Adding employee and creating login details
    When user enters firstname,middlename,lastname,ID and photo
    And user clicks on create login details button
    And user enter username,password and confirms password and enables status
    And user click on the save button
    Then the employee is created successfully with login credentials

