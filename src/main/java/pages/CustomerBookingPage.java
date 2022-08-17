package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CustomerBookingPage {
    private WebDriver driver;
    public String url = "http://ec2-65-2-126-57.ap-south-1.compute.amazonaws.com:3000/login";
    @FindBy(name = "username" )
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(className = "MuiButton-label")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/ul/div[1]/li")
    WebElement selectMovies;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div")
    WebElement dialogBox;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[2]/div/div[2]/div/div/div[1]/div/div/input")
    WebElement noOfSeats;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[2]/div/div[2]/div/button")
    WebElement nextDialogButton;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div")
    WebElement paymentDialogBox;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div")
    WebElement customerDetailsForm;

    @FindBy(id = "demo-simple-select")
    WebElement cashDropdown;
    @FindBy(xpath = "//*[@id=\"menu-payment\"]/div[3]/ul/li")
    List<WebElement> cash;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[2]/button")
    WebElement bookButton;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div")
    WebElement confirmationBox;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/button")
    WebElement downloadTicketButton;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[2]/div/div[2]/div/h6")
    WebElement pastShowsErrorMsg;

    @FindBy(id = "component-error-text")
    WebElement seatsErrorMsg;

    @FindBy(className = "MuiAlert-message")
    WebElement availableSeatsErrorMsg;

    @FindBy(name = "name")
    WebElement customerName;

    @FindBy(name = "phoneNumber")
    WebElement customerPhnNo;

    @FindBy(name="email")
    WebElement customerEmail;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/form/div/button")
    WebElement adminBookButton;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/form/div/div[1]/p")
    WebElement nameRequiredErrorMsg;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/form/div/div[2]/p")
    WebElement phoneNumberErrorMessage;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/form/div/div[3]/p")
    WebElement emailErrorMsg;
    public CustomerBookingPage(WebDriver driver) {
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

    public boolean returnMoviesStatus() {
        try {
            if (selectMovies.isDisplayed()) {
                selectMovies.click();
                return true;
            }
            return false;
        }catch(Exception e){
            return false;
        }
    }

    public boolean returnDialogBoxStatus(){
        if(dialogBox.isDisplayed()){
            return true;
        }
        return false;
    }

    public String validateLoginUrl(){

        return driver.getCurrentUrl();
    }

    public void sendNoOfSeats(String seats){

        noOfSeats.sendKeys(seats);
    }

    public boolean nextButtonStatus(){
        try{
        if(nextDialogButton.isDisplayed()){
            nextDialogButton.click();
            return true;
        }
    }catch (Exception e){
            return false;}
        return false;
    }

    public boolean getCustomerDetailsFormStatus(){
        if(customerDetailsForm.isDisplayed()){
            return true;
        }
        return false;
    }

    public void selectCashFromDropdown() throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.moveToElement(cashDropdown);
        actions.perform();
        cashDropdown.click();
        for (WebElement e: cash) {

            e.click();
        }
    }

    public boolean bookButtonStatus(){
        if(bookButton.isDisplayed()){
            if(bookButton.isEnabled()) {
                bookButton.click();
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean confimationStatus(){
        if(confirmationBox.isDisplayed()){
            return true;
        }
        return false;
    }

    public boolean downloadTicketButtonStatus(){
        if(downloadTicketButton.isDisplayed())
        {
            if(downloadTicketButton.isEnabled())
            {
                downloadTicketButton.click();
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean returnPastShowsStatus(){
        if(pastShowsErrorMsg.isDisplayed()){
            return true;
        }
        return false;
    }
    public String returnPastShowsString(){
        if(pastShowsErrorMsg.isDisplayed()){
            return pastShowsErrorMsg.getText();
        }
        return null;
    }

    public String returnSeatsErrorMsg(){
        if(seatsErrorMsg.isDisplayed())
        {
            return seatsErrorMsg.getText();
        }
        return null;
    }

    public String returnAvailableSeatsErrorMsg(){
        return availableSeatsErrorMsg.getText();
    }

    public void sendName(String name){
        customerName.sendKeys(name);
    }
    public void sendNumber(String number){
        customerPhnNo.sendKeys(number);
    }
    public void sendEmail(String email){
        customerEmail.sendKeys(email);
    }

    public boolean retrunAdminBookButtonStatus(){
        try{
        if(adminBookButton.isEnabled())
        {
            adminBookButton.click();
            return true;
        }}catch(Exception e){
            return false;
        }
        return false;
    }

    public String returnNameRequiredErrorMsg(){
        return nameRequiredErrorMsg.getText();
    }

    public String returnPhoneNumberMsg(){
        return phoneNumberErrorMessage.getText();
    }

    public String retrunEmailErrorMsg(){
        return emailErrorMsg.getText();
    }
}
