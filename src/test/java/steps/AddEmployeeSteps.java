package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.*;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    public String expectedFN;
    public String expectedMN;
    public String expectedLN;
    public String employeeId;
    public String fn1;
    public String mn1;
    public String ln1;

    @When("user clicks on Add Employee option")
    public void user_clicks_on_add_employee_option() {
        dashboardPage.addEmployeeOption.click();
    }

    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
        sendText("TREPCA10", addEmployeePage.firstName);
        sendText("TORCIDA10", addEmployeePage.middleName);
        sendText("CHAMPION10", addEmployeePage.lastName);

        fn1 = addEmployeePage.firstName.getText();
        mn1 = addEmployeePage.middleName.getText();
        ln1 = addEmployeePage.lastName.getText();


    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        addEmployeePage.saveBtn.click();
    }

    @Then("employee is added successfully")
    public void employee_is_added_successfully() {
        System.out.println("ADDED SUCCESSFULLY");
        String query = "select emp_firstname,emp_middle_name,emp_lastname from hs_hr_employees where employee_id='" + employeeId + "'";

        List<Map<String, String>> data = DataBaseUtils.fetch(query);
        Map<String, String> oneRowMap = data.get(0);
        String actualFN = oneRowMap.get("emp_firstname");
        String actualMN = oneRowMap.get("emp_middle_name");
        String actualLN = oneRowMap.get("emp_lastname");

        Assert.assertEquals(fn1, actualFN);
        Assert.assertEquals(mn1, actualMN);
        Assert.assertEquals(ln1, actualLN);

    }


    @When("user enter {string} ,{string} and {string}")
    public void user_enter_and(String firstName, String middleName, String lastName) {
        sendText(firstName, addEmployeePage.firstName);
        sendText(middleName, addEmployeePage.middleName);
        sendText(lastName, addEmployeePage.lastName);

        expectedFN = firstName;
        expectedMN = middleName;
        expectedLN = lastName;
        employeeId = addEmployeePage.employeeID.getAttribute("value");

    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("ADDED SUCCESSFULLY");
        String query = "select emp_firstname,emp_middle_name,emp_lastname from hs_hr_employees where employee_id='" + employeeId + "'";

        List<Map<String, String>> data = DataBaseUtils.fetch(query);
        Map<String, String> oneRowMap = data.get(0);
        String actualFN = oneRowMap.get("emp_firstname");
        String actualMN = oneRowMap.get("emp_middle_name");
        String actualLN = oneRowMap.get("emp_lastname");

        Assert.assertEquals(expectedFN, actualFN);
        Assert.assertEquals(expectedMN, actualMN);
        Assert.assertEquals(expectedLN, actualLN);

    }


    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String fN, String mN, String lN) {
        sendText(fN, addEmployeePage.firstName);
        sendText(mN, addEmployeePage.middleName);
        sendText(lN, addEmployeePage.lastName);


    }

    @When("user enters firstname, middlename and lastname from data table and verifies it")
    public void user_enters_firstname_middlename_and_lastname_from_data_table_and_verifies_it
            (io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

        List<Map<String, String>> newEmployees = dataTable.asMaps();

        for (Map<String, String> employees : newEmployees) {
            String firstNameValue = employees.get("firstname");
            String middleNameValue = employees.get("middlename");
            String lastNameValue = employees.get("lastname");

            sendText(firstNameValue, addEmployeePage.firstName);
            sendText(middleNameValue, addEmployeePage.middleName);
            sendText(lastNameValue, addEmployeePage.lastName);

            click(addEmployeePage.saveBtn);
            Thread.sleep(2000);

            // to add multiple employees, I have to click on add employee btn again and again so it takes me back to add new employee

            click(dashboardPage.addEmployeeOption);
            Thread.sleep(2000);
        }


    }

    @When("user adds multiple employees from excel and validates them")
    public void user_adds_multiple_employees_from_excel_and_validates_them() throws InterruptedException {
        List<Map<String, String>> employeeData = ExcelReader.read();

        for (Map<String, String> employee : employeeData) {
            sendText(employee.get("firstName"), addEmployeePage.firstName);
            sendText(employee.get("middleName"), addEmployeePage.middleName);
            sendText(employee.get("lastName"), addEmployeePage.lastName);
            sendText(employee.get("Photograph"), addEmployeePage.photoGraph);

            // I have to click on checkbox if it is not selected
            if (!addEmployeePage.checkBox.isSelected()) {
                click(addEmployeePage.checkBox);
            }
            sendText(employee.get("Username"), addEmployeePage.username);
            sendText(employee.get("Password"), addEmployeePage.passwordUser);
            sendText(employee.get("confirmPassword"), addEmployeePage.confirmPasswordUser);

            if (!addEmployeePage.statusBtn.isEnabled()) {
                selectFromDropDown("Enabled", addEmployeePage.statusBtn);
            }

            click(addEmployeePage.saveBtn);
            Thread.sleep(2000);

            click(dashboardPage.addEmployeeOption);
            Thread.sleep(2000);

        }
        System.out.println("great");


    }


    @When("user enters firstname,middlename,lastname,ID and photo")
    public void user_enters_firstname_middlename_lastname_id_and_photo() {
        sendText("JACKSON", addEmployeePage.firstName);
        sendText("CONOR", addEmployeePage.middleName);
        sendText("KHABIB", addEmployeePage.lastName);
        sendText("347654009", addEmployeePage.employeeID);
        sendText("/Users/shpendpllana/Desktop/NYC.jpg", addEmployeePage.photoGraph);
    }

    @When("user clicks on create login details button")
    public void user_clicks_on_create_login_details_button() {
        jsClick(addEmployeePage.createLoginDetailsBtn);
    }

    @When("user enter username,password and confirms password and enables status")
    public void user_enter_username_password_and_confirms_password_and_enables_status() {
        sendText("ELONCHARLES900", addEmployeePage.username);
        sendText("hrm@HRM1231", addEmployeePage.passwordUser);
        sendText("hrm@HRM1231", addEmployeePage.confirmPasswordUser);


        if (!addEmployeePage.statusBtn.isEnabled()) {
            selectFromDropDown("Enabled", addEmployeePage.statusBtn);
        }

    }

    @When("user click on the save button")
    public void user_click_on_the_save_button() {
        addEmployeePage.saveBtn.click();
        //getJSExecutor().executeScript("arguments[0].scrollIntoView(true);", addEmployeePage.saveBtn);
    }

    @Then("the employee is created successfully with login credentials")
    public void the_employee_is_created_successfully_with_login_credentials() {


        WebElement ActualUserName = driver.findElement(By.xpath("//*[@id='personal_txtEmpFirstName']"));
        String actualUserName = ActualUserName.getText();


    }


}
