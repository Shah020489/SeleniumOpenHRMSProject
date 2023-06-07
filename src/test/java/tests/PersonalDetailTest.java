package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.PIMPage;
import pageobjects.PersonalDetailPage;
import pageobjects.loginPage;
import testcomponents.BaseTest;

public class PersonalDetailTest extends BaseTest {



    loginPage login;
    HomePage homePage;
    PIMPage pimPage;

    PersonalDetailPage personalDetailPage;



    @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        login = new loginPage(driver);
        homePage=login.enterValidLoginCredentialsInInputField();
        pimPage=homePage.clickOnPIMLink();
        personalDetailPage=pimPage.addUserInPim();

    }

    @Test
    public void personalDetailTitle(){
        personalDetailPage.pageTitle();
    }



}
