package skyfoxapp.testcases.customerBookingTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CustomerBookingPage;

public class ValidateNumberOfSeatsTest extends BaseTest {
    CustomerBookingPage customerBookingPage;
    @BeforeClass
    public void openBrowser() throws InterruptedException {
        setUp();
        customerBookingPage = new CustomerBookingPage(driver);
        customerBookingPage.openLoginPageUrl();
    }
    @Parameters({"username", "password","seats"})
    @Test(priority = 1)
    public void customerBookingTest(String username, String password,String seats) throws InterruptedException {
        customerBookingPage.sendUsernamePassword(username, password);
        customerBookingPage.clickLoginButton();
        sleep();

        String actualUrl = customerBookingPage.validateLoginUrl();
        Assert.assertNotEquals(actualUrl, customerBookingPage.url, "Login failed");

        driver.navigate().to("http://ec2-65-2-126-57.ap-south-1.compute.amazonaws.com:3000/shows?date=2022-08-30");

        System.out.println("new page");
        Thread.sleep(1000);
        boolean resultMovieStatus = customerBookingPage.returnMoviesStatus();
        Assert.assertTrue(resultMovieStatus,"Movies are not clickable");
        sleep();
        boolean resultDialogBoxStatus = customerBookingPage.returnDialogBoxStatus();
        Assert.assertTrue(resultDialogBoxStatus,"Dialog box is not displayed");
        sleep();
        customerBookingPage.sendNoOfSeats(seats);
        sleep();
        String seatsErrorMsg = customerBookingPage.returnSeatsErrorMsg();
        sleep();
        Assert.assertTrue(seatsErrorMsg.contains("Error"),"The message did not match for seats error message");
        sleep();
        boolean nextButtonstatus = customerBookingPage.nextButtonStatus();
        Assert.assertFalse(nextButtonstatus,"Next button is clickable when the seat number is error");
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {

        tearDown();
    }
}
