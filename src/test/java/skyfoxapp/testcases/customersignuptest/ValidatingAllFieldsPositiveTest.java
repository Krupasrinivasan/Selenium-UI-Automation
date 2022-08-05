package skyfoxapp.testcases.customersignuptest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CustomerSignupPage;
import pages.LoginPage;

public class ValidatingAllFieldsPositiveTest extends BaseTest {
    LoginPage loginpage;
    CustomerSignupPage signuppage;

    @BeforeClass
    public void openBrowser() throws InterruptedException {
        setUp();
        loginpage = new LoginPage(driver);
        loginpage.openLoginPageUrl();

        signuppage = new CustomerSignupPage(driver);
        sleep();
    }
    @Parameters({"name","user_name","email_id","mobile_num","pass","confirm_pass"})
    @Test
    public void customerSignupPageTest(String full_name,String user_name,String email_id,String mobile_num,String pass,String confirm_pass) throws InterruptedException {
        loginpage.clickSignupLink();
        sleep();

        String actualUrl = signuppage.validateSignupPageUrl();
        Assert.assertEquals(actualUrl, signuppage.url, "Actual page url is not as expected");
        System.out.println(signuppage.url);

        signuppage.sendDetails(full_name, user_name, email_id, mobile_num, pass, confirm_pass);
        sleep();
        signuppage.clickSignupButton();

        String actualSignupUrl=signuppage.validateSignupUrl();
        Assert.assertNotEquals(actualSignupUrl, loginpage.url, "Login failed");
        sleep();
    }
    @AfterClass
    public void closeBrowser() throws InterruptedException {
        tearDown();
    }
}
