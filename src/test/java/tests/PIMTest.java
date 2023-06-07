package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AdminPage;
import pageobjects.HomePage;
import pageobjects.PIMPage;
import pageobjects.loginPage;
import testcomponents.BaseTest;

public class PIMTest extends BaseTest {

    loginPage login;
    HomePage homePage;

    PIMPage pimPage;



    @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        login = new loginPage(driver);
        homePage=login.enterValidLoginCredentialsInInputField();
        pimPage=homePage.clickOnPIMLink();
        //login.clickLoginOption();
    }

    @Test(priority = 1)
    public void validateTitle(){
    pimPage.pageTitle();
    }

    @Test(priority = 2)
    public void validateEmployeeLabel(){
        pimPage.validateEmployeeLabel();
    }

    @Test(priority = 3)
    public void validateAddUserTitle(){
        pimPage.validateUserLabel();
    }

    @Test(priority = 4)
    public void saveARecordPIM(){
        pimPage.addUserInPim();
    }

}
