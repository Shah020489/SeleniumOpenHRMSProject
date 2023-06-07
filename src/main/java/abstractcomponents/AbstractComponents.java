package abstractcomponents;

import java.time.Duration;
import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


// This page is to store all the methods and variables that are to be repeatedly used in the program
public class AbstractComponents {

    ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
    //create ExtentReports and attach reporter(s)
    ExtentReports extent = new ExtentReports();

    WebDriver driver;

    public String getTitle;

    JavascriptExecutor javaScriptExecutor;

    @FindBy(xpath = "//a[@id='menu-toggle']")
    WebElement menuBtn;

    @FindBy(css = ".oxd-text--h6")
    WebElement DashboardTitleTxt;

    public final Logger LOGGER = LoggerFactory.getLogger(AbstractComponents.class);

    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        javaScriptExecutor = (JavascriptExecutor) driver;
    }

    public void clickMenuButton() {
        waitForWebElementToAppear(menuBtn);
        waitForWebElementToClickable(menuBtn);
        menuBtn.click();
    }

    public void waitForWebElementToAppear(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(32));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public void waitForWebElementToClickable(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }

    public void scrollToElement(WebElement webElement) {
        waitForWebElementToAppear(webElement);
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    /**
     * This method is used to select the option from the sidebar menu
     * @param Option Click from sidebar 1 for CURA Healthcare || 2 for Home || 3 for Login
     */
    public void selectOptionFromSideBar(int Option) {
        WebElement sideBarOption = driver.findElement(By.xpath("//nav[@id='sidebar-wrapper']//ul//li[" + Option + "]"));
        waitForWebElementToAppear(sideBarOption);
        waitForWebElementToClickable(sideBarOption);
        sideBarOption.click();
    }

    public void verifyAppointmentPageTitle() {
        waitForWebElementToAppear(DashboardTitleTxt);
        getTitle = DashboardTitleTxt.getText();
        Assert.assertEquals(getTitle, "Dashboard");
    }


    @BeforeTest(alwaysRun = true)
    public void startReport(String OS, String browser) {

        extent.attachReporter(htmlReporter);
    }

    @AfterTest
    public void flush() {
        //to write or update test information to reporter
        extent.flush();
    }
}
