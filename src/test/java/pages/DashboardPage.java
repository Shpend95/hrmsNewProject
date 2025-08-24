package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class DashboardPage extends CommonMethods {
    @FindBy(xpath = "//a[@id='menu_pim_viewPimModule']")
    public WebElement pimOption;

    @FindBy(xpath = "//a[@id='menu_pim_addEmployee']")
    public WebElement employeeListOption;

    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmployeeOption;

    @FindBy(id="welcome")
    public WebElement welcomeMessage;

    @FindBy(xpath = "//a[@id='menu_admin_viewAdminModule']")
    public WebElement adminBtn;




    public DashboardPage(){
        PageFactory.initElements(driver, this);
    }
}
