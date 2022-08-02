package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
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

    public LoginPage(WebDriver driver) {
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

}
