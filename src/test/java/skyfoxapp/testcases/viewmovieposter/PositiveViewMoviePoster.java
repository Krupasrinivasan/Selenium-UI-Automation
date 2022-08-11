package skyfoxapp.testcases.viewmovieposter;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ViewMoviePoster;

public class PositiveViewMoviePoster extends BaseTest {

    ViewMoviePoster viewMoviePoster;
    LoginPage loginPage;

    @BeforeClass
    public void openBrowser() {
        setUp();
        loginPage = new LoginPage(driver);
        loginPage.openLoginPageUrl();
        viewMoviePoster = new ViewMoviePoster(driver);
    }

    @Parameters({"username","password"})
    @Test
    public void viewMoviePoster(String username,String password) throws InterruptedException {
        loginPage.sendUsernamePassword(username,password);
        System.out.println("Parameters sent");
        loginPage.clickLoginButton();
        System.out.println("Clicked login button");
        Thread.sleep(2000);
        viewMoviePoster.clickMoviePoster();
        System.out.println("Clicked movie poster");
        sleep();
        checkForMoviePosterPopupAvailability();
        sleep();
        checkForCrossMarkAvailability();
        viewMoviePoster.clickCrossMark();
        System.out.println("Cross mark in movie poster is clicked");
        sleep();
        checkForPosterPopupNotDisplayed();
        viewMoviePoster.clickMovieName();
        System.out.println("Clicked movie name");
        Thread.sleep(2000);
        checkForMovieDetailsPopupAvailability();
        checkForCrossMarkAvailability();
        viewMoviePoster.clickMoviePoster();
        System.out.println("Clicked movie name");
        sleep();
        checkForMoviePosterPopupAvailability();
        sleep();
        checkForCrossMarkAvailability();
        viewMoviePoster.clickCrossMark();
        System.out.println("Cross mark in movie poster is clicked");
        sleep();
        checkForMovieDetailsPopupAvailability();
        viewMoviePoster.clickCrossMark();
        System.out.println("Cross mark in movie poster is clicked");
        sleep();
        checkForMovieDetailPopupNotDisplayed();
    }

    private void checkForMovieDetailPopupNotDisplayed() {
        boolean movieDetailsPopupNotAvailability = viewMoviePoster.movieDetailsPopupAvailability();
        Assert.assertNotEquals(String.valueOf(movieDetailsPopupNotAvailability),"false");
        System.out.println("Movie Details Popup is not available");
    }


    private void checkForMovieDetailsPopupAvailability() {
        boolean movieDetailPopupAvailabitlity = viewMoviePoster.movieDetailsPopupAvailability();
        Assert.assertEquals(String.valueOf(movieDetailPopupAvailabitlity),"true");
        System.out.println("Movie Detail Popup is available");
    }

    private void checkForPosterPopupNotDisplayed() {
        boolean popupNotAvailability = viewMoviePoster.posterPopupAvailability();
        Assert.assertNotEquals(String.valueOf(popupNotAvailability),"false");
        System.out.println("Movie Poster Popup is not available");
    }

    private void checkForMoviePosterPopupAvailability() {
        boolean posterPopupAvailability = viewMoviePoster.posterPopupAvailability();
        Assert.assertEquals(String.valueOf(posterPopupAvailability),"true");
        System.out.println("Movie Poster Popup is available");

    }

    private void checkForCrossMarkAvailability() {
        boolean crossMarkAvailablity = viewMoviePoster.crossmarkAvailability();
        Assert.assertEquals(String.valueOf(crossMarkAvailablity),"true");
        System.out.println("crossmark is available");
    }



    @AfterClass
    public void closeBrowser() {
        tearDown();
    }

}
