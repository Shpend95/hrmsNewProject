package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Constants;
import utils.DataBaseUtils;


import java.io.IOException;

import java.time.Duration;

public class LoginSteps extends CommonMethods {
    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() throws IOException, InterruptedException {
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/dashboard");

    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.usernameField.sendKeys(ConfigReader.read("userName"));
        loginPage.passwordField.sendKeys(ConfigReader.read("passWord"));
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        jsClick(loginPage.loginBtn);


    }

    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() throws IOException {
        Assert.assertTrue(dashboardPage.welcomeMessage.isDisplayed());
        System.out.println("You are now logged in");


    }


    @When("user enters invalid username and invalid password")
    public void user_enters_invalid_username_and_invalid_password() {
        sendText("random", loginPage.usernameField);
        sendText("randomly", loginPage.passwordField);

    }

    @Then("an error message should be displayed saying invalid credentials")
    public void an_error_message_should_be_displayed_saying_invalid_credentials() {
        Assert.assertTrue(loginPage.invalidCredentials.isDisplayed());
    }


    @When("user enters a username and leaves the password field empty")
    public void user_enters_a_username_and_leaves_the_password_field_empty() {
        sendText("random", loginPage.usernameField);
        sendText("", loginPage.passwordField);
    }

    @Then("an error message should be displayed saying Password is empty")
    public void an_error_message_should_be_displayed_saying_password_is_empty() {
        Assert.assertTrue(loginPage.passwordEmpty.isDisplayed());
    }


    @When("user enters a password and leaves the username field empty")
    public void user_enters_a_password_and_leaves_the_username_field_empty() {
        sendText("random", loginPage.passwordField);
        sendText("", loginPage.usernameField);
    }


    @Then("an error message should be displayed saying Username is required")
    public void an_error_message_should_be_displayed_saying_username_is_required() {
        Assert.assertTrue(loginPage.usernameEmpty.isDisplayed());
    }

    @When("user enters {string} value and {string} value")
    public void user_enters_value_and_value(String userName, String passWord) {
        sendText(userName, loginPage.usernameField);
        sendText(passWord, loginPage.passwordField);
    }


    @When("user enters {string}  and {string}")
    public void user_enters_and(String string, String string2) {
        sendText(string, loginPage.usernameField);
        sendText(string2, loginPage.passwordField);
    }


}
