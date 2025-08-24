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

import static io.restassured.RestAssured.given;

public class AddEmployeeSteps extends CommonMethods {

    public String expectedFN;
    public String expectedMN;
    public String expectedLN;
    public String employeeId;
    public String token;

    @When("user is logged in successfully")
    public void user_is_logged_in_successfully() {
        loginPage.usernameField.sendKeys(ConfigReader.read("userName"));
        loginPage.passwordField.sendKeys(ConfigReader.read("passWord"));
        jsClick(loginPage.loginBtn);
        Assert.assertTrue(dashboardPage.welcomeMessage.isDisplayed());
    }
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        waitForElementToBeClickable(dashboardPage.pimOption);
       dashboardPage.pimOption.click();
    }
    @When("user clicks on the Add Employee option")
    public void user_clicks_on_the_add_employee_option() {
        dashboardPage.addEmployeeOption.click();
        getWait();

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

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        addEmployeePage.saveBtn.click();
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

        prepareRequest = given().header(Constants.HEADER_CONTENT_TYPE_KEY, Constants.HEADER_CONTENT_TYPE_VALUE).body(
                "{\"email\": \"adminplana@gmail.com\",\n" +
                        "  \"password\": \"string95\"}"
        );
        response = prepareRequest.when().post(Constants.GENERATE_TOKEN_URI);
        response.then().assertThat().statusCode(200);
        token = "Bearer " + response.jsonPath().getString("token");

        prepareRequest=given().header(Constants.HEADER_CONTENT_TYPE_KEY, Constants.HEADER_CONTENT_TYPE_VALUE).header(
                Constants.HEADER_AUTHORIZATION_KEY, token).queryParam("employee_id", employeeId);

        response = prepareRequest.when().get(Constants.GET_ONE_EMPLOYEE_URI);
        response.prettyPrint();

        response.then().assertThat().statusCode(200);

        String temporaryID = response.jsonPath().getString("employee.employee_id");
        Assert.assertEquals(employeeId,temporaryID);


    }


    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
        sendText("ALICA", addEmployeePage.firstName);
        sendText("MIRA", addEmployeePage.middleName);
        sendText("YELLO", addEmployeePage.lastName);
    }

    @Then("employee is added successfully")
    public void employee_is_added_successfully() {
        System.out.println("ADDED SUCCESSFULLY");
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
        sendText("KHAMZAT", addEmployeePage.firstName);
        sendText("CHIMAEV", addEmployeePage.middleName);
        sendText("CHAMP", addEmployeePage.lastName);
        sendText("321345654", addEmployeePage.employeeID);
        sendText("/Users/shpendpllana/Desktop/PANDA.jpeg", addEmployeePage.photoGraph);
    }

    @When("user clicks on create login details button")
    public void user_clicks_on_create_login_details_button() {
        jsClick(addEmployeePage.createLoginDetailsBtn);
    }

    @When("user enter username,password and confirms password and enables status")
    public void user_enter_username_password_and_confirms_password_and_enables_status() {
        sendText("THEWOLF", addEmployeePage.username);
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
