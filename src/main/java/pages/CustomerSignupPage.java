package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerSignupPage {
    public String url = "http://ec2-65-2-126-57.ap-south-1.compute.amazonaws.com:3000/signup";
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/form/div[3]")
    WebElement signupPage;

    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div/a/svg/path")
    WebElement movieIcon;

    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div/a/h5")
    WebElement websiteName;

    @FindBy(name = "name")
    WebElement name;

    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "mobile_number")
    WebElement mobile_number;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "confirm_password")
    WebElement confirm_password;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/form/button")
    WebElement signupButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/form/div[1]/p")
    WebElement nameErrorMessage;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/form/div[2]/p")
    WebElement userNameErrorMessage;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/form/span")
    WebElement alreadyExistingUser;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/form/div[3]/p")
    WebElement emailErrorMessage;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/form/div[4]/p")
    WebElement mobileErrorMessage;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/form/div[5]/div/p")
    WebElement passwordErrorMessage;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/form/div[6]/div/p")
    WebElement confirmPasswordErrorMessage;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div")
    WebElement signupform;


    public CustomerSignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String validateSignupPageUrl() {
        return driver.getCurrentUrl();
    }

    public void sendDetails(String full_name, String user_name, String email_id, String mobile_num, String pass, String confirm_pass) {

        name.sendKeys(full_name);
        username.sendKeys(user_name);
        email.sendKeys(email_id);
        mobile_number.sendKeys(mobile_num);
        password.sendKeys(pass);
        confirm_password.sendKeys(confirm_pass);

    }

    public boolean validateSignupButton() {
        return signupButton.isEnabled();
    }

    public String getErrorMessageForName() {
        return nameErrorMessage.getText();
    }

    public String getErrorMessageForUserName() {
        return userNameErrorMessage.getText();
    }

    public String getErrorMessageForEmail() {
        return emailErrorMessage.getText();
    }

    public String getErrorMessageForMobileNumbeer() {
        return mobileErrorMessage.getText();
    }

    public String getErrorMessageForPassword() {
        return passwordErrorMessage.getText();
    }

    public String getErrorMessageForConfirmPassword() {
        return confirmPasswordErrorMessage.getText();
    }

    public String getErrorMessageForAlreadyExistingUserName() {
        return alreadyExistingUser.getText();
    }

    public void selectSomewhereOnTheSignUpform() {
        signupform.click();
    }

    public void clickSignupButton() {
        signupButton.click();
    }

    public String validateSignupUrl() {
        return driver.getCurrentUrl();
    }


}