package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;



public class LoginPage extends CommonMethods {

    @FindBy(id = "txtUsername")
    public WebElement usernameField;

    @FindBy(id="txtPassword")
    public WebElement passwordField;

    @FindBy(id="btnLogin")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[@id='spanMessage']")
    public WebElement invalidCredentials;

    @FindBy(xpath = "//span[contains(text(),'Password is Empty')]")
    public WebElement passwordEmpty;

    @FindBy(xpath = "//span[contains(text(),'Username cannot be empty')]")
    public WebElement usernameEmpty;


    public LoginPage(){
        PageFactory.initElements(driver,this);
        }
}
