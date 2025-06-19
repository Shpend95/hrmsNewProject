package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.CommonMethods;


import java.util.List;

public class EmployeeSearchSteps extends CommonMethods {
    public static String employeeID;
    public static String employeeName;

    @Then("user click on PIM option")
    public void user_click_on_pim_option() {
        dashboardPage.pimOption.click();
    }

    @When("user enter valid employee id")
    public void user_enter_valid_employee_id() throws InterruptedException {
        employeeSearchPage.idField.sendKeys("20369360");
        Thread.sleep(2000);
        String emp = employeeSearchPage.idField.getText();
        employeeID = emp;
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        employeeSearchPage.searchButton.click();
    }

    @Then("user is able to see the employee information")
    public void user_is_able_to_see_the_employee_information() {
        List<WebElement> listOfEmployeeNames = driver.findElements(By.xpath("//div[@id='tableWrapper']/table/tbody/tr"));
        for (WebElement element : listOfEmployeeNames) {
            if (element.getText().contains(employeeID)) {
                break;
            }
        }
    }

    @When("user enter valid employee name")
    public void user_enter_valid_employee_name() throws InterruptedException {
        getWait().until(ExpectedConditions.elementToBeClickable(employeeSearchPage.empNameSearchField));
        //sendJSExecutorText("arguments[0].value='ANNA Superhero';", employeeSearchPage.empNameSearchField);
        Thread.sleep(2000);
        String name = employeeSearchPage.empNameSearchField.getText();
        employeeName = name;


    }


}
