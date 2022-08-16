package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PreventUnauthorizedActionsPage {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[1]")
    WebElement shows;

    public PreventUnauthorizedActionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean AvailbiltyOfScheduleButton() {
        if (driver.getPageSource().contains("Schedule Movie"))
            return true;
        else
            return false;
    }
    public boolean AvailbiltyOfRevenue() {
        if (driver.getPageSource().contains("Revenue: "))
            return true;
        else
            return false;
    }
    public boolean AvailbiltyOfProfileIcon() {
        if (driver.getPageSource().contains("Welcome, Admin!"))
            return true;
        else
            return false;
    }
    public boolean availbilityOfShows(){
        return shows.isDisplayed();
    }

}
