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

public class ActionsForCustomer extends BaseTest {
    LoginPage loginpage;
    CustomerSignupPage signuppage;
    PreventUnauthorizedActionsPage unauthorizedactionpage;

    @BeforeClass
    public void openBrowser() throws InterruptedException {
        setUp();
        loginpage = new LoginPage(driver);
        loginpage.openLoginPageUrl();

        signuppage = new CustomerSignupPage(driver);
        sleep();

        unauthorizedactionpage = new PreventUnauthorizedActionsPage(driver);
        sleep();
    }
    @Parameters({"username","password"})
    @Test
    public void customerSignupPageTest(String user_name,String pass) throws Exception {

        loginpage.sendUsernamePassword(user_name,pass);
        sleep();
        Assert.assertFalse(unauthorizedactionpage.UnavailbiltyOfScheduleButton());
        Assert.assertFalse(unauthorizedactionpage.UnavailbiltyOfRevenue());
        Assert.assertFalse(unauthorizedactionpage.UnavailbiltyOfProfileIcon());
    }
    @AfterClass
    public void closeBrowser() throws InterruptedException {
        tearDown();
    }
}
