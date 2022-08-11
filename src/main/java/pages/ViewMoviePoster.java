package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewMoviePoster {
    String url = "http://ec2-65-2-126-57.ap-south-1.compute.amazonaws.com:3000/shows?date=2022-07-29";

    private WebDriver driver;

    @FindBy(className = "MuiAvatar-img")
    WebElement moviePoster;

    @FindBy(className = "MuiTypography-root")
    WebElement movieName;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/ul")
    WebElement movieDetailsPopup;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div")
    WebElement enlargePosterPopup;

    @FindBy(className = "MuiSvgIcon-root")
    WebElement crossMark;

    public ViewMoviePoster(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickMoviePoster() {
        Actions actions = new Actions(driver);
        actions.moveToElement(moviePoster).click().build().perform();
    }

    public boolean crossmarkAvailability() {
        return crossMark.isDisplayed();
    }

    public boolean posterPopupAvailability() {
        return enlargePosterPopup.isDisplayed();
    }

    public void clickCrossMark() {
        Actions actions = new Actions(driver);
        actions.moveToElement(crossMark).click().build().perform();
    }

    public void clickMovieName() {
        Actions actions = new Actions(driver);
        actions.moveToElement(movieName).click().build().perform();
    }

    public boolean movieDetailsPopupAvailability() {
        return movieDetailsPopup.isDisplayed();
    }

}
