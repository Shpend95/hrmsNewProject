package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.logging.XMLFormatter;

public class EmployeeSearchPage extends CommonMethods {


    @FindBy(xpath = "//*[@id='empsearch_id']")
    public WebElement idField;

    @FindBy(xpath = "//input[@name='empsearch[employee_name][empName]']")
    public WebElement empNameSearchField;

    @FindBy(id = "searchBtn")
    public WebElement searchButton;

    public EmployeeSearchPage() {
        PageFactory.initElements(driver, this);
    }
}
