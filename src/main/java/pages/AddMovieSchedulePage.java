package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Policy;
import java.util.List;

public class AddMovieSchedulePage {
    private WebDriver driver;
    public String url = "http://ec2-65-2-126-57.ap-south-1.compute.amazonaws.com:3000/login";
    @FindBy(name = "username" )
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(className = "MuiButton-label")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/form/p")
    WebElement failureMessage;

    @FindBy(xpath="//*[@id=\"root\"]/div/div/div[2]/div/form/div[3]")
    WebElement signupPage;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/button")
    WebElement scheduleButton;

    @FindBy(xpath = "//*[@id=\"formBody\"]/div[2]/div/div/input")
    WebElement costTextField;

    @FindBy(xpath = "//*[@id=\"formBody\"]/fieldset/div/label[1]/span[2]")
    WebElement firstShow;

    @FindBy(xpath = "//*[@id=\"formBody\"]/fieldset/div/label[2]/span[2]")
    WebElement secondShow;

    @FindBy(xpath = "//*[@id=\"formBody\"]/fieldset/div/label[3]/span[2]")
    WebElement thirdShow;

    @FindBy(xpath = "//*[@id=\"formBody\"]/fieldset/div/label[4]/span[2]")
    WebElement lastShow;

    @FindBy(id="demo-simple-select")
    WebElement selectdropdown;

    @FindBy(xpath = "//*[@id=\"menu-\"]/div[3]/ul") ////*[@id="menu-"]/div[3]/ul
    List<WebElement> dropdown;

    @FindBy(xpath = "//*[@id=\"footer\"]/button/span[1]")
    WebElement scheduleSubmitButton;

    @FindBy(className = "MuiIconButton-label")
    WebElement crossMark;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[1]/h4")
    WebElement showsSentence;

    @FindBy(xpath = "//*[@id=\"formBody\"]/div[2]/div/p")
    WebElement errorMessage;

    @FindBy(xpath = "/html/body/div[2]/div[3]")
    WebElement scheduleFormPopUp;
    public AddMovieSchedulePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openLoginPageUrl(){
        System.out.println("Starting login test");
        driver.get(url);
    }

    public void sendUsernamePassword(String name,String pass){
        username.sendKeys(name);
        password.sendKeys(pass);
    }

    public void clickLoginButton(){

        loginButton.click();
    }

    public String validateLoginUrl(){

        return driver.getCurrentUrl();
    }

    public String getActualMessageAfterInvalidLoginCredentials() {
        return failureMessage.getText();
    }

    public boolean clickScheduleButton() {

        if(scheduleButton.isEnabled()) {
            scheduleButton.click();
            return true;
        }
        return false;
    }

    public void selectSlot(){

        if(firstShow.isDisplayed())
        {
            firstShow.click();
            return;
        }
        else if(secondShow.isDisplayed())
        {
            secondShow.click();
            return;
        }
        else if(thirdShow.isDisplayed())
        {
            thirdShow.click();
            return;
        }
        else
        {
            lastShow.click();
            return;
        }
    }
    public void setCost(String cost){

        costTextField.sendKeys(cost);
    }

    public boolean displayScheduleFormopUp(){
        if(scheduleFormPopUp.isDisplayed())
        {
            return true;
        }
        return false;
    }
    public void selectMovieFromDropdown() throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.moveToElement(selectdropdown);
        actions.perform();
        selectdropdown.click();
        for (WebElement e: dropdown) {

            e.click();
        }
    }

    public boolean clickScheduleSubmitButton(){

        // scheduleSubmitButton.click();
        if(scheduleSubmitButton.isEnabled())
        {
            return true;
        }
        return false;
    }

    public void clickCrossMark(){

        crossMark.click();
    }

    public String sendShowsSentence(){

        return showsSentence.getText();
    }

    public String getErrorMessage(){

        return errorMessage.getText();
    }
}
