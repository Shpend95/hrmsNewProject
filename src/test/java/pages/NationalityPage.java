package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;


public class NationalityPage extends CommonMethods {


    @FindBy(xpath = "//a[@id='menu_admin_nationality']")
    public WebElement nationalityBtn;

    @FindBy(css = "[id='btnAdd']")
    public WebElement addBtn;

    @FindBy(css = "[name='nationality[name]']")
    public WebElement nationalityName;

    @FindBy(css = "[name='btnSave']")
    public WebElement SaveBtn;

    @FindBy(xpath = "//*[contains(text(),'Successfully Saved')]")
    public WebElement successMessage;


    @FindBy(xpath = "//*[@id='frmNationality']/fieldset/ol/li[1]/span")
    public WebElement Message;


    @FindBy(xpath = "//input[@id='dialogDeleteBtn']")
    public WebElement okDeleteBtn;

    @FindBy(xpath = "//input[@id='btnDelete']")
    public WebElement deleteBtn;


    public NationalityPage(){
        PageFactory.initElements(driver,this);
    }
}
