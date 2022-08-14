package skyfoxapp.testcases.preventunauthorizedactions;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CustomerSignupPage;
import pages.LoginPage;
import pages.PreventUnauthorizedActionsPage;

public class ActionsForAdmin extends BaseTest {
    LoginPage loginpage;
    PreventUnauthorizedActionsPage unauthorizedactionpage;
    @BeforeClass
    public void openBrowser() throws InterruptedException {
        setUp();
        loginpage = new LoginPage(driver);
        loginpage.openLoginPageUrl();

        unauthorizedactionpage = new PreventUnauthorizedActionsPage(driver);
        sleep();
    }
    @Parameters({"username", "password"})
    @Test
    public void actionsForAdmin(String username, String password) throws InterruptedException {
        loginpage.sendUsernamePassword(username,password);
        loginpage.clickLoginButton();
        Thread.sleep(3000);
        Thread.sleep(3000);
        Thread.sleep(3000);

        Assert.assertTrue(unauthorizedactionpage.availabiltyOfschedulebutton());
        Assert.assertTrue(unauthorizedactionpage.availabiltyOfsRevenue());
        Assert.assertTrue(unauthorizedactionpage.availabiltyOfProfileIcon());
    }
    @AfterClass
    public void closeBrowser() throws InterruptedException {

        tearDown();
    }
}
