package skyfoxapp.testcases.loginpagetest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CustomerSignupPage;
import pages.LoginPage;

public class NegativeLoginTest extends BaseTest {

    LoginPage loginpage;


    @BeforeClass
    public void openBrowser() {
        setUp();
        loginpage = new LoginPage(driver);
        loginpage.openLoginPageUrl();
    }

    @Parameters({"username", "password","expectedFailureMessage"})
    @Test(priority = 1)
    public void loginPageTest(String username, String password,String expectedFailureMessage) throws InterruptedException {
        loginpage.sendUsernamePassword(username, password);

        loginpage.clickEyeButton();
        loginpage.clickLoginButton();

        sleep();


        //validate url after clicking login button
        String actualUrl = loginpage.validateLoginUrl();
        Assert.assertEquals(actualUrl, loginpage.url, "Actual page url is not as expected");
        System.out.println(loginpage.url);

        //validate failure message
        String actualFailureMessage = loginpage.getActualMessageAfterInvalidLoginCredentials();
        System.out.println(actualFailureMessage);
        sleep();

        Assert.assertTrue(actualFailureMessage.contains(expectedFailureMessage),"Actual failure message does not match expected failure message." +
                "\nActual failure message: " + actualFailureMessage +
                "\nExpected failure message: "+expectedFailureMessage);
        sleep();

    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        tearDown();
    }
}