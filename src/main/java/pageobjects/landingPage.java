package pageobjects;

import abstractcomponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Utils;

public class landingPage extends AbstractComponents {
    WebDriver driver;

    @FindBy(xpath = "//i[@class='el-icon-unlock']")
    WebElement forgotPasswordBtn;

    public landingPage(WebDriver driver) {
        super(driver); // this will add driver to super class constructor
        this.driver = driver; // initiate the driver with the driver
        PageFactory.initElements(driver, this); // initialize the page factory elemenets.
    }

    public void goTo() {
        driver.get(Utils.getElementFromPropertiesFile("url", "global"));
    }
}
