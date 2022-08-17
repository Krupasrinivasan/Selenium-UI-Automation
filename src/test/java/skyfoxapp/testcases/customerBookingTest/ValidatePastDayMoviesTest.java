package skyfoxapp.testcases.customerBookingTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CustomerBookingPage;

public class ValidatePastDayMoviesTest extends BaseTest {
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


        driver.navigate().to("http://ec2-65-2-126-57.ap-south-1.compute.amazonaws.com:3000/shows?date=2022-07-30");


        System.out.println("new page");
        Thread.sleep(3000);
        boolean result = customerBookingPage.returnMoviesStatus();
        Assert.assertFalse(result,"Past day movies are clickable");
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {

        tearDown();
    }
}
