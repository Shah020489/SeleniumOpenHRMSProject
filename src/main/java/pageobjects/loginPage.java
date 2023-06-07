package pageobjects;

import abstractcomponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utility.Utils;

public class loginPage extends AbstractComponents {
    WebDriver driver;

    String validUsername;

    String validPassword;

    String invalidUsername;

    String loginErrorMessage;

    @FindBy(name = "username")
    WebElement usernameTxt;

    @FindBy(name = "password")
    WebElement passwordTxt;

    @FindBy(css = ".oxd-text--h5")
    WebElement loginTitleTxt;

    @FindBy(xpath = "//section[@id='appointment']//h2")
    WebElement appointmentTitleTxt;

    @FindBy(css = ".oxd-alert-content-text")
    WebElement loginErrorTxt;

    @FindBy(css = ".oxd-button")
    WebElement loginBtn;



    public loginPage(WebDriver driver) {
        super(driver); // this will add driver to super class constructor
        this.driver = driver; // initiate the driver with the driver
        PageFactory.initElements(driver, this); // initialize the page factory elemenets.
    }

//    public void clickLoginOption() {
//        clickMenuButton();
//        selectOptionFromSideBar(3);
//    }

    public HomePage enterValidLoginCredentialsInInputField() {
        validUsername = Utils.getElementFromPropertiesFile("validUsername", "global");
        validPassword = Utils.getElementFromPropertiesFile("validPassword", "global");
        waitForWebElementToAppear(usernameTxt);
        usernameTxt.sendKeys(validUsername);
        waitForWebElementToAppear(passwordTxt);
        passwordTxt.sendKeys(validPassword);
        loginBtn();
        return new HomePage(driver);
    }

    public void enterInvalidLoginCredentialsInInputField() {
        invalidUsername = Utils.getElementFromPropertiesFile("invalidUsername", "global");
        validPassword = Utils.getElementFromPropertiesFile("validPassword", "global");
        waitForWebElementToAppear(usernameTxt);
        usernameTxt.sendKeys(invalidUsername);
        waitForWebElementToAppear(passwordTxt);
        passwordTxt.sendKeys(validPassword);

    }

    public void loginBtn() {
        loginBtn.click();
    }

    public void verifyLoginErrorMessage() {
        waitForWebElementToAppear(loginErrorTxt);
        loginErrorMessage = loginErrorTxt.getText();
        Assert.assertEquals(loginErrorMessage, "Invalid credentials");
    }

//    public Void verifyLoginPageTitle() {
//        waitForWebElementToAppear(loginTitleTxt);
//        getTitle = loginTitleTxt.getText();
//        Assert.assertEquals(getTitle, "Login");
//    }

    public void verifyMakeAppointmentPageTitle() {

        verifyAppointmentPageTitle();
    }

}

