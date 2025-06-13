package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.w3c.dom.DOMConfiguration;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Log;

import java.io.IOException;

public class LoginSteps extends CommonMethods {


    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {
        launchBrowser();
        Log.startTestCase("here is the beggining of test case");

    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.usernameField.sendKeys(ConfigReader.read("userName"));
        loginPage.passwordField.sendKeys(ConfigReader.read("passWord"));

    }

    @When("user cicks on login button")
    public void user_cicks_on_login_button() {
        jsClick(loginPage.loginBtn);
    }

    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() throws IOException {
        Assert.assertTrue(dashboardPage.welcomeMessage.isDisplayed());




    }
}
