package skyfoxapp.testcases.addMovieScheduleTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AddMovieSchedulePage;

public class NoAvailableSlotsScheduleTest extends BaseTest {
    AddMovieSchedulePage AddMovieSchedulePage;
    @BeforeClass
    public void openBrowser() throws InterruptedException {
        setUp();
        AddMovieSchedulePage = new AddMovieSchedulePage(driver);
        AddMovieSchedulePage.openLoginPageUrl();
    }
    @Parameters({"username", "password"})
    @Test(priority = 1)
    public void scheduleMovieTest(String username, String password) throws InterruptedException {
        AddMovieSchedulePage.sendUsernamePassword(username, password);
        AddMovieSchedulePage.clickLoginButton();
        sleep();

        String actualUrl = AddMovieSchedulePage.validateLoginUrl();
        Assert.assertNotEquals(actualUrl, AddMovieSchedulePage.url, "Login failed");


        driver.navigate().to("http://ec2-65-2-126-57.ap-south-1.compute.amazonaws.com:3000/shows?date=2022-08-30");


        System.out.println("new page");
        Thread.sleep(3000);
        boolean result = AddMovieSchedulePage.clickScheduleButton();
        Assert.assertFalse(result, "The schedule button is clickable for past days with available slots");
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {

        tearDown();
    }
}
