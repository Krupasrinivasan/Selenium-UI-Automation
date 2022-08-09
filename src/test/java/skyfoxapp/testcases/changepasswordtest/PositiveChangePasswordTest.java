package skyfoxapp.testcases.changepasswordtest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;

public class PositiveChangePasswordTest extends BaseTest {

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
        changePasswordPage.cickeyeicon();
        sleep();
        sleep();

        boolean clickable = changePasswordPage.checkChangePasswordSubmitButton();
        Assert.assertTrue(clickable,"Change password submit button is not Clickable");

//       changePasswordPage.clickChangePasswordSubmitButton();
//       sleep();
//       String successMessage = changePasswordPage.getSuccessMessage();
//       Assert.assertTrue(successMessage.contains("Your password has been changed successfully"),"Success message  mismatch");
        changePasswordPage.clickCrossMark();
    }
    @AfterClass
    public void closeBrowser() throws InterruptedException {

        tearDown();
    }
}
