@addEmployeeOnly
Feature: Adding employees using different techniques

  Background:
   #Given user is navigated to HRMS application   # this is called and executed in Hooks as pre condition
    When user is logged in successfully
    And user clicks on PIM option
    And user clicks on the Add Employee option


  @addemployee @regression
  Scenario: Adding an employee in HRMS system
    When user enters firstname and middlename and lastname
    And user clicks on save button
    Then employee is added successfully


  @valuesFromFF @regression
  Scenario: Adding employee from feature file
    When user enter "Selenium" ,"API" and "SQL"
    And user clicks on save button
    Then employee added successfully

  @DataDrivenTesting @regression
  Scenario Outline: Adding employees using data driven testing
    When user enters "<firstname>" and "<middlename>" and "<lastname>"
    And user clicks on save button
    Then employee added successfully
    Examples:
      | firstname | middlename | lastname |
      | Shpend      | N/A      | Pllana   |
      | POST  | Singer      | Malone       |
      | Syntax   | School     | Technologies       |
      | Chazz   | Actor        | Paliminteri       |
      | Khamzat | UFC       | Chimaev       |

  @DataTableHead @regression
  Scenario: Adding multiple employees using data table
    When user enters firstname, middlename and lastname from data table and verifies it
      | firstname | middlename | lastname |
      | Aurora      | Aole    | Light     |
      | Alex     | Fighter         | Pereira    |
      | Fedor      | Beast     | Emelianenko    |
      | Lorik       | Soccer       | Cana    |

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




