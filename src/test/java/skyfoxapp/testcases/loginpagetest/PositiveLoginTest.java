package skyfoxapp.testcases.loginpagetest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

public class PositiveLoginTest extends BaseTest {

    LoginPage loginpage;

    @BeforeClass
    public void openBrowser() {
        setUp();
        loginpage = new LoginPage(driver);
        loginpage.openLoginPageUrl();
    }

    @Parameters({"username", "password"})
    @Test(priority = 1)
    public void loginPageTest(String username, String password) throws InterruptedException {
        loginpage.sendUsernamePassword(username,password);

        loginpage.clickEyeButton();
        loginpage.clickLoginButton();
        sleep();

        //validate url after clicking login button

        String actualUrl = loginpage.validateLoginUrl();
        Assert.assertNotEquals(actualUrl, loginpage.url, "Login failed");

    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {

        tearDown();
    }
}
