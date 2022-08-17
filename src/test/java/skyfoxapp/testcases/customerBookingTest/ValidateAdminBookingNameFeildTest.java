package skyfoxapp.testcases.customerBookingTest;

import base.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CustomerBookingPage;

public class ValidateAdminBookingNameFeildTest extends BaseTest {
    CustomerBookingPage customerBookingPage;
    @BeforeClass
    public void openBrowser() throws InterruptedException {
        setUp();
        customerBookingPage = new CustomerBookingPage(driver);
        customerBookingPage.openLoginPageUrl();
    }
    @Parameters({"username", "password", "seats","number","email"})
    @Test(priority = 1)
    public void customerBookingTest(String username, String password,String seats,String number,String email) throws InterruptedException {
        customerBookingPage.sendUsernamePassword(username, password);
        customerBookingPage.clickLoginButton();
        sleep();

        String actualUrl = customerBookingPage.validateLoginUrl();
        Assert.assertNotEquals(actualUrl, customerBookingPage.url, "Login failed");

        driver.navigate().to("http://ec2-65-2-126-57.ap-south-1.compute.amazonaws.com:3000/shows?date=2022-08-30");

        System.out.println("new page");
        Thread.sleep(3000);
        boolean resultMovieStatus = customerBookingPage.returnMoviesStatus();
        Assert.assertTrue(resultMovieStatus,"Movies are not clickable");
        sleep();
        boolean resultDialogBoxStatus = customerBookingPage.returnDialogBoxStatus();
        Assert.assertTrue(resultDialogBoxStatus,"Dialog box is not displayed");
        customerBookingPage.sendNoOfSeats(seats);
        sleep();
        boolean nextDialogbuttonStatus = customerBookingPage.nextButtonStatus();
        Assert.assertTrue(nextDialogbuttonStatus,"Next button is not clickable");
        boolean customerDetailsFormStauts = customerBookingPage.getCustomerDetailsFormStatus();
        sleep();
        String name=null;
        Assert.assertTrue(customerDetailsFormStauts,"Customer details form is not displayed");
        customerBookingPage.sendNumber(number);
        customerBookingPage.sendEmail(email);
        boolean adminBookButtonStatus = customerBookingPage.retrunAdminBookButtonStatus();
        Assert.assertFalse(adminBookButtonStatus,"The admin book is clickable even name field is not correct");
        sleep();
        String nameRequiredErrorMsg = customerBookingPage.returnNameRequiredErrorMsg();
        Assert.assertTrue(nameRequiredErrorMsg.contains("Name is required"),"The required message mismatch");
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {

        tearDown();
    }
}

