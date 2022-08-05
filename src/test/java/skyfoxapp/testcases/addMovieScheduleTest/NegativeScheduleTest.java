package skyfoxapp.testcases.addMovieScheduleTest;

import base.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AddMovieSchedulePage;

public class NegativeScheduleTest extends BaseTest {

    pages.AddMovieSchedulePage AddMovieSchedulePage;
    @BeforeClass
    public void openBrowser() throws InterruptedException {
        setUp();
        AddMovieSchedulePage = new AddMovieSchedulePage(driver);
        AddMovieSchedulePage.openLoginPageUrl();
    }
    @Parameters({"username", "password","cost","expectedFailureMessage"})
    @Test(priority = 1)
    public void loginPageTest(String username, String password,String cost,String expectedFailureMessage) throws InterruptedException {
        AddMovieSchedulePage.sendUsernamePassword(username,password);
        AddMovieSchedulePage.clickLoginButton();
        sleep();

        String actualUrl = AddMovieSchedulePage.validateLoginUrl();
        Assert.assertNotEquals(actualUrl, AddMovieSchedulePage.url, "Login failed");

        driver.navigate().to("http://ec2-65-2-126-57.ap-south-1.compute.amazonaws.com:3000/shows?date=2022-08-22");

        System.out.println("new page");
        AddMovieSchedulePage.clickScheduleButton();
        System.out.println("Clicked Schedule Button");
        sleep();
        AddMovieSchedulePage.selectSlot();
        System.out.println("Selected slot");
        sleep();
        AddMovieSchedulePage.setCost(cost);
        System.out.println("Cost entered");
        sleep();
        AddMovieSchedulePage.selectMovieFromDropdown();
        System.out.println("Selected Dropdown");
        sleep();
        sleep();
        String actualFailureMessage = AddMovieSchedulePage.getErrorMessage();
        Assert.assertTrue(actualFailureMessage.contains(expectedFailureMessage),"Actual failure message does not match expected failure message." +
                "\nActual failure message: " + actualFailureMessage +
                "\nExpected failure message: "+expectedFailureMessage);
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {

        tearDown();
    }
}
