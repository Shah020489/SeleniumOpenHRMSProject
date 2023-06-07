package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AdminPage;
import pageobjects.HomePage;
import pageobjects.loginPage;
import testcomponents.BaseTest;

public class AdminTest extends BaseTest {

    loginPage login;
    AdminPage admin;
    HomePage homePage;

    LoginTest loginTest;


    @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        login = new loginPage(driver);
        homePage=login.enterValidLoginCredentialsInInputField();
        admin=homePage.clickOnAdminLink();
        //login.clickLoginOption();
    }

    @Test
    public void validateAdminPage(){
        admin.verifyAdminPageLabel();
    }

    @Test
    public void validateAddAUserScenario() throws InterruptedException {
        admin.addANewUser();
    }

}
