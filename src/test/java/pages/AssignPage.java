package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AssignPage extends CommonMethods {

    @FindBy(xpath = "//*[@id='menu_leave_assignLeave']")
    public WebElement assignLeaveButton;

    @FindBy(xpath = "//*[@id='menu_leave_viewLeaveModule']")
    public WebElement leaveBtn;


    @FindBy(xpath = "//*[@name='assignleave[txtEmployee][empName]']")
    public WebElement employeeName;

    @FindBy(xpath = "//select[@name='assignleave[txtLeaveType]']")
    public WebElement leaveType;

    @FindBy(xpath = "//*[@id='assignleave_txtFromDate']")
    public WebElement fromDate;

    @FindBy(xpath = "//*[@id='assignleave_txtToDate']")
    public WebElement toDate;

    @FindBy(xpath = "//*[@id='assignleave_txtComment']")
    public WebElement enterComment;

    @FindBy(xpath = "//*[@id='assignBtn']")
    public WebElement assignBtn;

    @FindBy(id="confirmOkButton")
    public WebElement okButton;

    @FindBy(id = "assignleave_duration_duration")
    public WebElement leaveDuration;

   @FindBy(id = "assignleave_duration_ampm")
   public WebElement PMorAm;





    public AssignPage() {
        PageFactory.initElements(driver, this);
    }
}
