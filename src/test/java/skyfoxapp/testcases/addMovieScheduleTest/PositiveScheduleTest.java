package skyfoxapp.testcases.addMovieScheduleTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AddMovieSchedulePage;

public class PositiveScheduleTest extends BaseTest {

    AddMovieSchedulePage AddMovieSchedulePage;
    @BeforeClass
    public void openBrowser() throws InterruptedException {
        setUp();
        AddMovieSchedulePage = new AddMovieSchedulePage(driver);
        AddMovieSchedulePage.openLoginPageUrl();
    }
    @Parameters({"username", "password","cost"})
    @Test(priority = 1)
    public void scheduleMovieTest(String username, String password,String cost) throws InterruptedException {
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
        boolean clickable = AddMovieSchedulePage.clickScheduleSubmitButton();
        Assert.assertTrue(clickable);
        System.out.println("clickable");
        AddMovieSchedulePage.clickCrossMark();
        System.out.println("clicked Cross mark");
        sleep();
        String sentence = AddMovieSchedulePage.sendShowsSentence();
        Assert.assertTrue(sentence.contains("Shows"),"The movie not scheduled Successfully");
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {

        tearDown();
    }
}
