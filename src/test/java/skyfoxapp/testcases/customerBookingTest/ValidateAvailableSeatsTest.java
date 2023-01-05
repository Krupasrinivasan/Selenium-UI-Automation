package skyfoxapp.testcases.customerBookingTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CustomerBookingPage;

public class ValidateAvailableSeatsTest extends BaseTest {
    CustomerBookingPage customerBookingPage;
    @BeforeClass
    public void openBrowser() throws InterruptedException {
        setUp();
        customerBookingPage = new CustomerBookingPage(driver);
        customerBookingPage.openLoginPageUrl();
    }
    @Parameters({"username", "password", "seats"})
    @Test(priority = 1)
    public void customerBookingTest(String username, String password,String seats) throws InterruptedException {
        customerBookingPage.sendUsernamePassword(username, password);
        customerBookingPage.clickLoginButton();
        sleep();

        String actualUrl = customerBookingPage.validateLoginUrl();
        Assert.assertNotEquals(actualUrl, customerBookingPage.url, "Login failed");

        driver.navigate().to("http://ec2-65-2-126-57.ap-south-1.compute.amazonaws.com:3000/shows?date=2022-08-31");

        System.out.println("new page");
        Thread.sleep(3000);
        boolean resultMovieStatus = customerBookingPage.returnMoviesStatus();
        Assert.assertTrue(resultMovieStatus,"Movies are not clickable");
        sleep();
        boolean resultDialogBoxStatus = customerBookingPage.returnDialogBoxStatus();
        Assert.assertTrue(resultDialogBoxStatus,"Dialog box is not displayed");
        sleep();
        customerBookingPage.sendNoOfSeats(seats);
        sleep();
        boolean nextDialogbuttonStatus = customerBookingPage.nextButtonStatus();
        Assert.assertTrue(nextDialogbuttonStatus,"Next button is not clickable");
        sleep();
        boolean paymentDialogBoxStatus = customerBookingPage.getCustomerDetailsFormStatus();
        Assert.assertTrue(paymentDialogBoxStatus,"payment dialog box is not displayed");
        sleep();
        customerBookingPage.selectCashFromDropdown();
        sleep();
        boolean bookButtonStatus = customerBookingPage.bookButtonStatus();
        Assert.assertTrue(bookButtonStatus, "Book button is not enabled");
        sleep();
        String availableSeatsString = customerBookingPage.returnAvailableSeatsErrorMsg();
        Assert.assertTrue(availableSeatsString.contains("Sorry, seats could not be booked"));

    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {

        tearDown();
    }
}
