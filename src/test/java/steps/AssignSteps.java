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
        Log.startTestCase("here we goooo, this is assign steps");
        loginPage.usernameField.sendKeys(ConfigReader.read("userName"));
        loginPage.passwordField.sendKeys(ConfigReader.read("passWord"));
        jsClick(loginPage.loginBtn);
        Thread.sleep(2000);
    }

    @When("user cliks on leave button")
    public void user_cliks_on_leave_button() {
        jsClick(assignPage.leaveBtn);
    }

    @When("user clicks on assign leave button")
    public void user_clicks_on_assign_leave_button() {
        jsClick(assignPage.assignLeaveButton);
    }

    @When("user enters the name of employee,leave reason,dates and comments")
    public void user_enters_the_name_of_employee_leave_reason_dates_and_comments() throws InterruptedException {
        sendText("shpend kosova pllana1", assignPage.employeeName);
        selectFromDropDown(assignPage.leaveType, "Personal Time");
        jsClick(assignPage.fromDate);
        Thread.sleep(2000);
        List<WebElement> dates = driver.findElements(By.xpath("//*[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for (WebElement date : dates) {
            if (date.getText().contains("24")) {
                date.click();
                break;
            }
        }
        jsClick(assignPage.toDate);
        Thread.sleep(2000);

        List<WebElement> toDates = driver.findElements(By.xpath("//*[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for (WebElement toDate : toDates) {
           if(toDate.getText().contains("30")){
               toDate.click();
               break;
           }
        }
        Thread.sleep(2000);

        sendText("i will be back", assignPage.enterComment);


    }

    @When("user clicks on assign button")
    public void user_clicks_on_assign_button() throws InterruptedException {
        jsClick(assignPage.assignBtn);
        Thread.sleep(2000);
        jsClick(assignPage.okButton);
    }

    @Then("user should see a successfully assingned message")
    public void user_should_see_a_successfully_assingned_message() {
        WebElement message = getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Successfully Assigned')]")));
        Assert.assertTrue(message.isDisplayed());
        System.out.println("good ");

    }

}
