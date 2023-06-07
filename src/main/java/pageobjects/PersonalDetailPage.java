package pageobjects;

import abstractcomponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PersonalDetailPage extends AbstractComponents {

    WebDriver driver;


    public PersonalDetailPage(WebDriver driver) {
        super(driver);
        this.driver = driver; // initiate the driver with the driver
        PageFactory.initElements(driver, this); // initialize the page factory elemenets.

    }

    public void pageTitle(){
        String actualString=driver.getTitle();
        Assert.assertEquals(actualString,"OrangeHRM");
    }




}
