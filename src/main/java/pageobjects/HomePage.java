package pageobjects;

import abstractcomponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends AbstractComponents {

    @FindBy(css = ".oxd-userdropdown-tab")
    WebElement userDropDown;

    @FindBy (xpath = "//a[.='About']")
    WebElement aboutLink;

    @FindBy(xpath = "//a[.='Support']")
    WebElement supportLink;

    @FindBy(xpath = "//a[.='Change Password']")
    WebElement chagePasswordLink;

    @FindBy(xpath = "//a[.='Logout']")
    WebElement logOutLink;


    @FindBy(xpath = "//a[.='Admin']")
    WebElement adminLink;

    @FindBy(xpath = "//a[.='PIM']")
    WebElement pimLink;


    WebDriver driver;
    HomePage homePage;
    loginPage loginPage;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver; // initiate the driver with the driver
        PageFactory.initElements(driver, this); // initialize the page factory elemenets.

    }

    public void setUserDropDown(){
        userDropDown.click();
    }

    public void setAboutLink(){
        setUserDropDown();
        aboutLink.click();
    }

    public void setLogOutLink(){
        setUserDropDown();
        logOutLink.click();
    }

    public void setchagePasswordLink(){

        chagePasswordLink.click();
    }

    public void setsupportLink(){
        supportLink.click();
    }

    public void verifySupportLink(){
        setUserDropDown();
        setsupportLink();
    }

    public void verifyAboutLink(){
        setUserDropDown();
        setAboutLink();
    }

    public void verifyChangePasswordLink(){
        setUserDropDown();
        setchagePasswordLink();
    }




    public void verifyLogoutBtn(){
        //loginPage.enterValidLoginCredentialsInInputField();
        setUserDropDown();
        setLogOutLink();
    }

    public void checkPageTitle(){

        String actualString= driver.getTitle();
        Assert.assertEquals(actualString,"OrangeHRM");
    }

    public AdminPage clickOnAdminLink(){
        adminLink.click();
        return new AdminPage(driver);
    }

    public PIMPage clickOnPIMLink(){
        pimLink.click();
        return new PIMPage(driver);
    }

}
