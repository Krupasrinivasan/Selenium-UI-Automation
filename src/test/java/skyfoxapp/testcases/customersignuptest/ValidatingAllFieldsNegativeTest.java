package skyfoxapp.testcases.customersignuptest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CustomerSignupPage;
import pages.LoginPage;

public class ValidatingAllFieldsNegativeTest extends BaseTest {

    LoginPage loginpage;
    CustomerSignupPage signuppage;

    @BeforeClass
    public void openBrowser() throws InterruptedException {
        setUp();
        loginpage = new LoginPage(driver);
        loginpage.openLoginPageUrl();

        signuppage = new CustomerSignupPage(driver);
        Thread.sleep(500);
    }
    @Parameters({"name","user_name","email_id","mobile_num","pass","confirm_pass","nameErrorMessage","usernameErrorMessage","emailErrorMessage","mobileNumberErrorMessage","passwordErrorMessage","confirmPasswordErrorMessage"})
    @Test
    public void customerSignupPageTest(String full_name,String user_name,String email_id,String mobile_num,String pass,String confirm_pass,String nameErrorMessage,String usernameErrorMessage,String emailErrorMessage,String mobileErrorMessage,String passwordErrorMessage,String confirmPasswordErrorMessage) throws InterruptedException {
        loginpage.clickSignupLink();
        sleep();

        String actualUrl = signuppage.validateSignupPageUrl();
        Assert.assertEquals(actualUrl, signuppage.url, "Actual page url is not as expected");
        System.out.println(signuppage.url);

        signuppage.sendDetails(full_name, user_name, email_id, mobile_num, pass, confirm_pass);
        sleep();

        signuppage.clickEyeIconForPassword();
        signuppage.clickEyeIconForConfirmPassword();
        signuppage.selectSomewhereOnTheSignUpform();

        String actualFailureMessageForText = signuppage.getErrorMessageForName();
        System.out.println(actualFailureMessageForText);
        sleep();

        Assert.assertTrue(actualFailureMessageForText.contains(nameErrorMessage),"Actual failure message does not match expected failure message." +
                "\nActual failure message: " + actualFailureMessageForText +
                "\nExpected failure message: "+nameErrorMessage);

        String actualFailureMessageForUserName = signuppage.getErrorMessageForUserName();
        System.out.println(actualFailureMessageForUserName);
        sleep();

        Assert.assertTrue(actualFailureMessageForUserName.contains(usernameErrorMessage), "Actual failure message does not match expected failure message." +
                "\nActual failure message: " + actualFailureMessageForUserName +
                "\nExpected failure message: " + usernameErrorMessage);

        String actualFailureMessageForEmail = signuppage.getErrorMessageForEmail();
        System.out.println(actualFailureMessageForEmail);
        sleep();

        Assert.assertTrue(actualFailureMessageForEmail.contains(emailErrorMessage),"Actual failure message does not match expected failure message." +
                "\nActual failure message: " + actualFailureMessageForEmail +
                "\nExpected failure message: "+emailErrorMessage);

        String actualFailureMessageForMobileNumber = signuppage.getErrorMessageForMobileNumbeer();
        System.out.println(actualFailureMessageForMobileNumber);
        sleep();

        Assert.assertTrue(actualFailureMessageForMobileNumber.contains(mobileErrorMessage),"Actual failure message does not match expected failure message." +
                "\nActual failure message: " + actualFailureMessageForMobileNumber +
                "\nExpected failure message: "+mobileErrorMessage);

        String actualFailureMessageForPassword = signuppage.getErrorMessageForPassword();
        System.out.println(actualFailureMessageForPassword);
        sleep();

        Assert.assertTrue(actualFailureMessageForPassword.contains(passwordErrorMessage),"Actual failure message does not match expected failure message." +
                "\nActual failure message: " + actualFailureMessageForPassword +
                "\nExpected failure message: "+passwordErrorMessage);

        String actualFailureMessageForConfirmPassword = signuppage.getErrorMessageForConfirmPassword();
        System.out.println(actualFailureMessageForConfirmPassword);

        Assert.assertTrue(actualFailureMessageForConfirmPassword.contains(confirmPasswordErrorMessage),"Actual failure message does not match expected failure message." +
                "\nActual failure message: " + actualFailureMessageForConfirmPassword +
                "\nExpected failure message: "+confirmPasswordErrorMessage);

        sleep();
        Assert.assertFalse(signuppage.validateSignupButton());
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        tearDown();
    }
}