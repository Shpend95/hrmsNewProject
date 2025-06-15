package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Log;

import java.util.List;

public class AssignSteps extends CommonMethods {
    @Given("user is logged in and on dashboard page")
    public void user_is_logged_in_and_on_dashboard_page() throws InterruptedException {
        loginPage.usernameField.sendKeys(ConfigReader.read("userName"));
        loginPage.passwordField.sendKeys(ConfigReader.read("passWord"));
        jsClick(loginPage.loginBtn);
        Thread.sleep(2000);
    }

    @Given("user clicks on leave button")
    public void user_clicks_on_leave_button() {
        jsClick(assignPage.leaveBtn);
    }

    @When("user clicks on assign leave button")
    public void user_clicks_on_assign_leave_button() {
        jsClick(assignPage.assignLeaveButton);
    }

    @When("user enters the name of employee,leave reason,dates and comments")
    public void user_enters_the_name_of_employee_leave_reason_dates_and_comments() throws InterruptedException {
        sendText("ICT GHOST TRADER", assignPage.employeeName);
        selectFromDropDown(assignPage.leaveType, "Sick Leave.");
        jsClick(assignPage.fromDate);
        Thread.sleep(2000);
        List<WebElement> dates = driver.findElements(By.xpath("//*[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for (WebElement date : dates) {
            if (date.getText().contains("16")) {
                date.click();
                break;
            }
        }
        jsClick(assignPage.toDate);
        Thread.sleep(2000);

        List<WebElement> toDates = driver.findElements(By.xpath("//*[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for (WebElement toDate : toDates) {
            if (toDate.getText().contains("16")) {
                toDate.click();
                break;
            }
        }
        Thread.sleep(2000);


        selectFromDropDown("half_day", assignPage.leaveDuration);
        selectFromDropDown(assignPage.PMorAm, "Afternoon");

        sendText("I need to rest, AND maybe nap", assignPage.enterComment);


    }

    @When("user clicks on assign button")
    public void user_clicks_on_assign_button() throws InterruptedException {
        assignPage.assignBtn.click();
        Thread.sleep(1000);

        getJSExecutor().executeScript("arguments[0].scrollIntoView(true);",assignPage.okButton);

       // getWait().until(ExpectedConditions.elementToBeClickable(assignPage.okButton)).click();
    }

    @Then("user should see a successfully assigned message")
    public void user_should_see_a_successfully_assigned_message() throws InterruptedException {
        WebElement message = getWait().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Successfully Assigned')]")));
        Assert.assertTrue(message.isDisplayed());


    }

}


