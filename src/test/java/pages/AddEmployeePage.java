package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;
import utils.PageInitializer;

public class AddEmployeePage extends CommonMethods {

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id="middleName")
    public WebElement middleName;

    @FindBy(name = "lastName")
    public WebElement lastName;

    @FindBy(id = "employeeId")
    public WebElement employeeID;

    @FindBy(id = "photofile")
    public WebElement photoGraph;

    @FindBy(id = "btnSave")
    public WebElement saveBtn;

    @FindBy(id="chkLogin")
    public WebElement checkBox;

    @FindBy(id="user_name")
    public WebElement username;

    @FindBy(id="user_password")
    public WebElement passwordUser;

    @FindBy(id="re_password")
    public WebElement confirmPasswordUser;

    @FindBy(xpath = "//select[@id='status']")
    public WebElement statusBtn;

    @FindBy(xpath = "//*[@name='chkLogin']")
    public WebElement createLoginDetailsBtn;




    public AddEmployeePage (){
        PageFactory.initElements(driver,this);
    }

}
