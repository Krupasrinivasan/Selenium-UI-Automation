package skyfoxapp.testcases.customerBookingTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CustomerBookingPage;

public class ValidatePastShowsTest extends BaseTest {
    CustomerBookingPage customerBookingPage;
    @BeforeClass
    public void openBrowser() throws InterruptedException {
        setUp();
        customerBookingPage = new CustomerBookingPage(driver);
        customerBookingPage.openLoginPageUrl();
    }
    @Parameters({"username", "password"})
    @Test(priority = 1)
    public void customerBookingTest(String username, String password) throws InterruptedException {
        customerBookingPage.sendUsernamePassword(username, password);
        customerBookingPage.clickLoginButton();
        sleep();

        String actualUrl = customerBookingPage.validateLoginUrl();
        Assert.assertNotEquals(actualUrl, customerBookingPage.url, "Login failed");

        Thread.sleep(3000);
        boolean result = customerBookingPage.returnMoviesStatus();
        sleep();
        boolean dialogBoxStatus;
        if(result){
            dialogBoxStatus = customerBookingPage.returnDialogBoxStatus();
            sleep();
            Assert.assertTrue(dialogBoxStatus,"Dialog box is not displayed");
            boolean pastShowsResult = customerBookingPage.returnPastShowsStatus();
            sleep();
            if(pastShowsResult){
                String pastShowsErrorMsg = customerBookingPage.returnPastShowsString();
                sleep();
                Assert.assertTrue(pastShowsErrorMsg.contains("Show Time is Over"),"The error Message did not match");
            }
        }
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {

        tearDown();
    }

}
