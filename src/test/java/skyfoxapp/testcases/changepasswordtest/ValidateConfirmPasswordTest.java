package skyfoxapp.testcases.changepasswordtest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;

public class ValidateConfirmPasswordTest extends BaseTest {

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

        sleep();
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

//        sleep();
//        String confirmPasswordErrorMessage = changePasswordPage.getConfirmNewPasswordErrorMessage();
//        Assert.assertTrue(confirmPasswordErrorMessage.contains("New password & confirm new password should be same"),"Confirm password error message mismatch");

        boolean clickable = changePasswordPage.checkChangePasswordSubmitButton();
        Assert.assertFalse(clickable,"Change password submit button is Clickable");

        changePasswordPage.clickCrossMark();
    }
    @AfterClass
    public void closeBrowser() throws InterruptedException {

        tearDown();
    }
}
