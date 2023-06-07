package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.loginPage;
import testcomponents.BaseTest;

public class LoginTest extends BaseTest {

    loginPage login;

    @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        login = new loginPage(driver);
        //login.clickLoginOption();
    }

    @Test(priority = 1)
    public void verifyThatTheLoginPageIsDisplayedWhenTheUserClickLoginOption() {

        //login.verifyLoginPageTitle();
    }

    @Test(priority = 2)
    public void verifyTheUserEntersValidUsernameAndPasswordThenClickTheLoginButton() {
        login.enterValidLoginCredentialsInInputField();
        //login.loginBtn();
        login.verifyMakeAppointmentPageTitle();

    }

    @Test(priority = 3)
    public void verifyTheUserEntersInvalidUsernameAndPasswordThenClickTheLoginButton() {
        login.enterInvalidLoginCredentialsInInputField();
        login.loginBtn();
        login.verifyLoginErrorMessage();
    }


}
