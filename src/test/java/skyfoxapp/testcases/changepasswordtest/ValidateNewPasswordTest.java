package skyfoxapp.testcases.changepasswordtest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;

public class ValidateNewPasswordTest extends BaseTest {

    ChangePasswordPage changePasswordPage;
    @BeforeClass
    public void openBrowser() throws InterruptedException {
        setUp();
        changePasswordPage = new ChangePasswordPage(driver);
        changePasswordPage.openLoginPageUrl();
    }

    @Parameters({"username","password","oldPassword", "newPassword", "confirmPassword"})
    @Test
    public void changePasswordTest(String username,String password,String oldPassword,String newPassword,String confirmPassword) throws InterruptedException {
        changePasswordPage.sendUsernamePassword(username,password);
        changePasswordPage.clickLoginButton();
        sleep();

        String actualUrl = changePasswordPage.validateLoginUrl();
        Assert.assertNotEquals(actualUrl, changePasswordPage.url, "Login failed");

        Thread.sleep(1000);
        changePasswordPage.clickProfileIcon();
        System.out.println("Clicked profile icon");

        String userProfileTag = changePasswordPage.getuserProfileHeaderSentence();
        Assert.assertTrue(userProfileTag.contains("User Profile"),"User Profile header missing");

        String nameTag = changePasswordPage.getNameTagSentence();
        Assert.assertTrue(nameTag.contains("Name:"),"Name tag missing");

        String userNameTag = changePasswordPage.getusernameTagSentence();
        Assert.assertTrue(userNameTag.contains("Username"),"Username tag missing");

        changePasswordPage.clickChangePasswordButton();
        System.out.println("Clicked Change Password button");

        String changePasswordHeader= changePasswordPage.getChangePasswordHeader();
        Assert.assertTrue(changePasswordHeader.contains("Change Password"),"Change password header mismatch");
        changePasswordPage.sendChangePasswordDetails(oldPassword,newPassword,confirmPassword);
        System.out.println("Entered all fields");

       String newPasswordErrorMessage1 = changePasswordPage.getNewPasswordErrorMessage1();
        Assert.assertTrue(newPasswordErrorMessage1.contains("Password must contain 8-64 characters,"),"New password error message1 mismatch");
        String newPasswordErrorMessage2 = changePasswordPage.getNewPasswordErrorMessage2();
        Assert.assertTrue(newPasswordErrorMessage2.contains("at least one uppercase character,"),"New password error message2 mismatch");
        String newPasswordErrorMessage3 = changePasswordPage.getNewPasswordErrorMessage3();
        Assert.assertTrue(newPasswordErrorMessage3.contains("one number and one special character"),"New password error message3 mismatch");

        boolean clickable = changePasswordPage.checkChangePasswordSubmitButton();
        Assert.assertFalse(clickable,"Change password submit button is Clickable");

        changePasswordPage.clickCrossMark();
    }
    @AfterClass
    public void closeBrowser() throws InterruptedException {

        tearDown();
    }
}

