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

public class NationalitySteps extends CommonMethods {

    public static String nationName = "KOSOVAALBANIA";
    public static String existingNation = "Barbadian";


    @Given("user is logged in and on Admin Page")
    public void user_is_logged_in_and_on_admin_page() {
        loginPage.usernameField.sendKeys(ConfigReader.read("userName"));
        loginPage.passwordField.sendKeys(ConfigReader.read("passWord"));
        jsClick(loginPage.loginBtn);
        jsClick(dashboardPage.adminBtn);
    }

    @Given("user navigates to nationality creation form")
    public void user_navigates_to_nationality_creation_form() throws InterruptedException {
        jsClick(nationalityPage.nationalityBtn);


    }

    @When("user enters the name of nationality")
    public void user_enters_the_name_of_nationality() throws InterruptedException {
        Thread.sleep(2000);
        jsClick(nationalityPage.addBtn);
        sendText(nationName, nationalityPage.nationalityName);

    }


    @When("user clicks on save button after entering the nationality")
    public void user_clicks_on_save_button_after_entering_the_nationality() {
        jsClick(nationalityPage.SaveBtn);
    }

    @Then("user should see a successfully saved message on the screen")
    public void user_should_see_a_successfully_saved_message_on_the_screen() throws InterruptedException {
        WebElement message = getWait().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Successfully Saved')]")));

        Assert.assertTrue(message.getText().contains("Successfully Saved"));


    }

    @When("user enters the name of existing nationality")
    public void user_enters_the_name_of_existing_nationality() throws InterruptedException {
        Thread.sleep(2000);
        jsClick(nationalityPage.addBtn);
        sendText(nationName, nationalityPage.nationalityName);
    }

    @When("user clicks on the save button")
    public void user_clicks_on_the_save_button() {
        jsClick(nationalityPage.SaveBtn);
    }

    @Then("user should see a error message on the screen")
    public void user_should_see_a_error_message_on_the_screen() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//*[@id='frmNationality']/fieldset/ol/li[1]/span")));
        Assert.assertTrue(nationalityPage.Message.isDisplayed());
    }


    @When("user selects the nationality")
    public void user_selects_the_nationality() {

        List<WebElement> nationalities = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
        for (WebElement n : nationalities) {
            WebElement nationalityLink = n.findElement(By.xpath(".//td[2]/a"));
            String nationality = nationalityLink.getText();

            if (nationality.equals(existingNation)) {
                WebElement checkbox = n.findElement(By.xpath(".//td[1]/input[@type='checkbox']"));
                checkbox.click();
                break;
            }
        }

    }

    @When("user clicks on delete button")
    public void user_clicks_on_delete_button() {
        nationalityPage.deleteBtn.click();
    }

    @When("user clicks on Ok button")
    public void user_clicks_on_ok_button() throws InterruptedException {
        getWait().until(ExpectedConditions.elementToBeClickable(nationalityPage.okDeleteBtn));
        jsClick(nationalityPage.okDeleteBtn);
    }

    @Then("user should see a successfully deleted message on the screen")
    public void user_should_see_a_successfully_deleted_message_on_the_screen() throws InterruptedException {
        WebElement message = getWait().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Successfully Deleted')]")));

        Assert.assertTrue(message.getText().contains("Successfully Deleted"));


    }


    @When("user leaves the nationality field empty")
    public void user_leaves_the_nationality_field_empty() {
        jsClick(nationalityPage.addBtn);
        sendText("", nationalityPage.nationalityName);
    }

    @Then("a warning should be displayed stating required")
    public void a_warning_should_be_displayed_stating_required() {
        Assert.assertTrue(nationalityPage.requiredMessage.isDisplayed());
    }


}
