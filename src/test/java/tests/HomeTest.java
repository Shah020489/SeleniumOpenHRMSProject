package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.loginPage;
import testcomponents.BaseTest;

public class HomeTest extends BaseTest {

    loginPage login;
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        login = new loginPage(driver);
        homePage=login.enterValidLoginCredentialsInInputField();
        //login.clickLoginOption();
    }

    @Test
    public void verifyPageTitle(){
        homePage.checkPageTitle();
    }

    @Test
    public void verifyAboutUS(){
        homePage.verifyAboutLink();
    }

    @Test
    public void verifySupport(){
        homePage.verifySupportLink();
    }

    @Test
    public void verifyChangePassword(){
        homePage.verifyChangePasswordLink();
    }

    @Test
    public void clickOnLogOut(){
        homePage.verifyLogoutBtn();
    }



}
