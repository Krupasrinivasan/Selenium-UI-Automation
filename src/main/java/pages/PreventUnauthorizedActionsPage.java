package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PreventUnauthorizedActionsPage {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div")
    WebElement schedulebutton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[1]/h5")
    WebElement revenue;

    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div/div[1]/a/p")
    WebElement welcomeadmin;

    @FindBy(css = "#root > div > header > div > div.view-profile > a > svg")
    WebElement profileIcon;

    public PreventUnauthorizedActionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean UnavailbiltyOfScheduleButton() {
        if (driver.getPageSource().contains("//*[@id=\"root\"]/div/div/div[1]/div"))
            return true;
        else
            return false;
    }
    public boolean UnavailbiltyOfRevenue() {
        if (driver.getPageSource().contains("//*[@id=\"root\"]/div/div/div[2]/div[1]/h5"))
            return true;
        else
            return false;
    }
    public boolean UnavailbiltyOfProfileIcon() {
        if (driver.getPageSource().contains("//*[@id=\"root\"]/div/header/div/div[1]/a/svg"))
            return true;
        else
            return false;
    }
    public boolean availabiltyOfschedulebutton(){
        return schedulebutton.isDisplayed();
    }
    public boolean availabiltyOfsRevenue(){
        return revenue.isDisplayed();
    }
    public boolean availabiltyOfProfileIcon(){
        return profileIcon.isDisplayed();
    }
}
