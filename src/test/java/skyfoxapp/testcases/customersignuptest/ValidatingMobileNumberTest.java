package skyfoxapp.testcases.customersignuptest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CustomerSignupPage;
import pages.LoginPage;

public class ValidatingMobileNumberTest extends BaseTest {
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
    @Parameters({"name","user_name","email_id","mobile_num","pass","confirm_pass","errorMessage"})
    @Test
    public void mobileNumberValidityChecking (String full_name,String user_name,String email_id,String mobile_num,String pass,String confirm_pass,String errorMessage) throws InterruptedException {
        loginpage.clickSignupLink();
        sleep();

        String actualUrl = signuppage.validateSignupPageUrl();
        Assert.assertEquals(actualUrl, signuppage.url, "Actual page url is not as expected");
        System.out.println(signuppage.url);

        signuppage.sendDetails(full_name, user_name, email_id, mobile_num, pass, confirm_pass);
        sleep();
        sleep();

        String actualFailureMessageForMobileNum = signuppage.getErrorMessageForMobileNumbeer();
        System.out.println(actualFailureMessageForMobileNum);

        Assert.assertTrue(actualFailureMessageForMobileNum.contains(errorMessage), "Actual failure message does not match expected failure message." +
                "\nActual failure message: " + actualFailureMessageForMobileNum +
                "\nExpected failure message: " + errorMessage);
        Assert.assertFalse(signuppage.validateSignupButton());

    }
    @AfterClass
    public void closeBrowser() throws InterruptedException {
        tearDown();
    }
}
