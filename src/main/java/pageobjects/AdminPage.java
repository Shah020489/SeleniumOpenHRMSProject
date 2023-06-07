package pageobjects;

import abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class AdminPage extends AbstractComponents {

    WebDriver driver;
    loginPage loginPage;
    HomePage homePage;
    AdminPage adminPage;


    String userName;
    String employeeName;

    @FindBy(xpath = "//a[.='Admin']")
    WebElement adminLink;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement addButton;

    @FindBy(css = "[placeholder='Type for hints...']")
    WebElement employeename;


    @FindBy(xpath = "//div[@class='oxd-form-row']/div[@class='oxd-grid-2 orangehrm-full-width-grid']/div[1]//div[@class='oxd-select-text oxd-select-text--active']")
    WebElement userRole;

    @FindBy(xpath = "//div[@class='oxd-form-row']//div[3]//div[@class='oxd-select-text oxd-select-text--active']")
    WebElement userStatus;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement username;

    @FindBy(css = ".user-password-cell .oxd-input")
    WebElement password;

    @FindBy(css = ".oxd-grid-2[data-v-9345d4ba] > div:nth-of-type(2) .oxd-input")
    WebElement confirmPassword;


    @FindBy(css = ".oxd-button--secondary")
    WebElement saveButton;

    @FindBy(css = ".oxd-text--h5")
    WebElement systemUser;

    @FindBy(xpath = "//div[@role='listbox']//div[3]")
    WebElement adminText;


    @FindBy(xpath = "(//i)[12]")
    WebElement status;

    @FindBy(css="button[type='submit']")
    WebElement saveBtn;




    public AdminPage(WebDriver driver) {
        super(driver); // this will add driver to super class constructor
        this.driver = driver; // initiate the driver with the driver
        PageFactory.initElements(driver, this); // initialize the page factory elemenets.
    }

    public void saveButton(){
        saveButton.click();
    }

    public void clickOnAdmin(){
        adminLink.click();
    }

    public void clickOnAddBtn(){
        addButton.click();
    }

    public void verifyAdminPageLabel(){
        String userLabel=systemUser.getText();
        Assert.assertEquals(userLabel,"System Users");
    }

    public void addANewUser() throws InterruptedException {
        clickOnAddBtn();

        userRole.click();

        selectOptionFromList(3);
        status.click();
        selectOptionFromList(2);

        username.sendKeys("Ahmed");
        password.sendKeys("admin123");
        confirmPassword.sendKeys("admin123");
        employeename.sendKeys("Suseetha A");
        Thread.sleep(10000);
        saveBtn.click();

    }


    void selectOptionFromList(int num){

        driver.findElement(By.xpath("//div[@role='listbox']//div["+num+"]")).click();
    }



}
