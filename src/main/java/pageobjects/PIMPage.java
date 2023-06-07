package pageobjects;

import abstractcomponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PIMPage extends AbstractComponents {

    WebDriver driver;

    @FindBy(xpath = "(//h6[normalize-space()='Add User'])[1]")
    WebElement addUserLabel;

    @FindBy(xpath = "(//h5[normalize-space()='Employee Information'])[1]")
    WebElement employeeLabel;

    @FindBy(xpath = "(//button[normalize-space()='Add'])[1]")
    WebElement addBtn;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement userName;

    @FindBy(xpath = "//input[@placeholder='Middle Name']")
    WebElement middleUser;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastUser;


    @FindBy (xpath = "//button[normalize-space()='Cancel']")
    WebElement cancelBtn;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveBtn;



    public PIMPage(WebDriver driver) {
        super(driver);
        this.driver = driver; // initiate the driver with the driver
        PageFactory.initElements(driver, this); // initialize the page factory elemenets.
    }

    public void pageTitle(){
        String actualString=driver.getTitle();
        Assert.assertEquals(actualString,"OrangeHRM");
    }

    public void validateUserLabel(){
        //addBtn.click();
       String userLabel= addUserLabel.getText();
       Assert.assertEquals(userLabel,"Add User");
    }

    public void validateEmployeeLabel(){
        String userLabel= employeeLabel.getText();
        Assert.assertEquals(userLabel,"Employee Information");
    }

    public PersonalDetailPage addUserInPim(){
        addBtn.click();
        waitForWebElementToAppear(userName);
        userName.sendKeys("Ahmed");
        middleUser.sendKeys("Ali");
        lastUser.sendKeys("Khan");
        saveBtn.click();
        return new PersonalDetailPage(driver);
    }






}
