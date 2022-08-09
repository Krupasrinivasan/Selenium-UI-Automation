package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ChangePasswordPage {

    private WebDriver driver;
    public String url = "http://ec2-65-2-126-57.ap-south-1.compute.amazonaws.com:3000/login";
    @FindBy(name = "username" )
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(className = "MuiButton-label") //html/body/div[2]/div[3]/div[2]/div[1]/svg
    WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div/div[1]/a")
    WebElement profileIcon;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/h5")
    WebElement userProfileHeader;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div/p[1]")
    WebElement nameTag;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div/p[2]")
    WebElement usernameTag;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/button")
    WebElement changePasswordButton;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/h5")
    WebElement changePasswordHeader;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]/div[1]/div/input")
    WebElement oldPasswordText;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]/div[2]/div/input")
    WebElement newPasswordText;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]/div[3]/div/input") //
    WebElement confirmNewPasswordText;

    @FindBy(css = "div:nth-of-type(1) > .MuiSvgIcon-root.jss280.visibility-on")
    WebElement eyeicon1;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]/button")
    WebElement changePasswordSubmitButton;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]/span/span[1]")
    WebElement newPasswordErrorMessage1;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]/span/span[2]")
    WebElement newPasswordErrorMessage2;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]/span/span[3]")
    WebElement newPasswordErrorMessage3;

    @FindBy()
    WebElement confirmPasswordErrorMessage;
    @FindBy(css = ".\\.failure\\-alert")
    WebElement failureMessage;

    @FindBy(css = ".\\.success\\-alert")
    WebElement successMessage;
    @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]/div[1]/svg")
    List<WebElement> eyeiconlist;

    public ChangePasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openLoginPageUrl(){
        System.out.println("Starting login test");
        String url="http://ec2-65-2-126-57.ap-south-1.compute.amazonaws.com:3000/login";
        driver.get(url);
    }

    public void sendUsernamePassword(String name,String pass){
        username.sendKeys(name);
        password.sendKeys(pass);
    }

    public void clickLoginButton(){

        loginButton.click();
    }
    public void clickProfileIcon(){
        profileIcon.click();
    }
    public void clickChangePasswordButton(){

        changePasswordButton.click();
    }

    public String getChangePasswordHeader(){
        return changePasswordHeader.getText();
    }
    public String getuserProfileHeaderSentence(){
        return userProfileHeader.getText();
    }

    public String getNameTagSentence(){
        return nameTag.getText();
    }

    public String getusernameTagSentence(){
        return usernameTag.getText();
    }

    public void sendChangePasswordDetails(String oldPassword, String newPassword, String confirmNewPassword){

        oldPasswordText.sendKeys(oldPassword);
        newPasswordText.sendKeys(newPassword);
        confirmNewPasswordText.sendKeys(confirmNewPassword);
    }
    public boolean checkChangePasswordSubmitButton(){
        if(changePasswordSubmitButton.isEnabled())
        {
            return true;
        }
        return false;
    }

    public void clickChangePasswordSubmitButton(){
        changePasswordSubmitButton.click();
    }

    public String getNewPasswordErrorMessage1(){
        return newPasswordErrorMessage1.getText();
    }

    public String getNewPasswordErrorMessage2(){
        return newPasswordErrorMessage2.getText();
    }

    public String getNewPasswordErrorMessage3(){
        return newPasswordErrorMessage3.getText();
    }

    public String getConfirmNewPasswordErrorMessage(){
        return confirmPasswordErrorMessage.getText();
    }

    public String getFailureMessage(){
        return failureMessage.getText();
    }

    public String getSuccessMessage(){
        return successMessage.getText();
    }

    public void clickCrossMark() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement svgObject = driver.findElement(By.xpath("//*[name()='svg' and @class='MuiSvgIcon-root close-icon']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(svgObject).click().build().perform();

    }

    public String validateLoginUrl(){

        return driver.getCurrentUrl();
    }

    public void cickeyeicon() throws InterruptedException {

        System.out.println(eyeiconlist.size());
        for(WebElement e: eyeiconlist){
            e.click();
        }
    }
}
