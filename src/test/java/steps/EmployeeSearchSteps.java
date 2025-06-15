package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.CommonMethods;
import utils.Log;

public class EmployeeSearchSteps extends CommonMethods {

    @Then("user click on PIM option")
    public void user_click_on_pim_option() {
        dashboardPage.pimOption.click();
    }

    @When("user enter valid employee id")
    public void user_enter_valid_employee_id() {
        employeeSearchPage.idField.sendKeys("12345007");
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        employeeSearchPage.searchButton.click();
    }

    @Then("user is able to see the employee information")
    public void user_is_able_to_see_the_employee_information() {
        WebElement listOfEmp = driver.findElement(By.xpath("//div[@id='tableWrapper']/table/tbody"));
        ;
        Assert.assertTrue(listOfEmp.getText().contains("GHOST TRADER"));


    }

    @When("user enter valid employee name")
    public void user_enter_valid_employee_name() throws InterruptedException {
        Thread.sleep(3000);
        employeeSearchPage.empNameSearchField.clear();
        sendJSExecutorText("arguments[0].value='David Andria Steve';", employeeSearchPage.empNameSearchField);
        sendText("40817048",employeeSearchPage.idField);

    }


}
