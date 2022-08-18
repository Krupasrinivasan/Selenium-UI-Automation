package pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;

import java.io.File;
import java.io.IOException;

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
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/form/div[5]/span/button")
    WebElement eyeiconforpassword;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/form/div[6]/span/button")
    WebElement eyeiconforconfirmpassword;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div")
    WebElement signupFormPopup;


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

    public void clickEyeIconForPassword() {
        eyeiconforpassword.click();
    }

    public void clickEyeIconForConfirmPassword() {
        eyeiconforconfirmpassword.click();
    }

    public boolean availabiltyOfSignupForm() {
        return signupFormPopup.isDisplayed();
    }

    public boolean enablesignupButton() {
        return signupButton.isEnabled();
    }

    public boolean availabiltyOfNameField() {
        return name.isDisplayed();
    }

    public boolean availabiltyOfUserNameField() {
        return username.isDisplayed();
    }

    public boolean availabiltyOfemailField() {
        return email.isDisplayed();
    }

    public boolean availabiltyOfPhoneNumberField() {
        return mobile_number.isDisplayed();
    }

    public boolean availabiltyOfpasswordField() {
        return password.isDisplayed();
    }

    public boolean availabiltyOfconfirmPasswordField() {
        return confirm_password.isDisplayed();
    }

    public boolean UnavailbiltyOfUserNameExistMessage() {
        if (driver.getPageSource().contains("//*[@id=\"root\"]/div/div/div[2]/div/form/div[2]/p"))
            return true;
        else
            return false;
    }

    public void takeScreenShot(WebDriver webdriver, String fileWithPath) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }

    public Boolean testImageComparison() throws IOException, InterruptedException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Thread.sleep(500);
        FileUtils.copyFile(screenshot, new File("Projects/neev-beta-01-booking-ui-automation-repo/EyeIconAfterClick.png"));

        File fileInput = new File("Projects/neev-beta-01-booking-ui-automation-repo/EyeIconBeforeClick.png");
        File fileOutPut = new File("Projects/neev-beta-01-booking-ui-automation-repo/EyeIconAfterClick.png");

        BufferedImage bufferedImage = ImageIO.read(fileInput);
        DataBuffer bufferfileInput = bufferedImage.getData().getDataBuffer();
        int sizefileInput = bufferfileInput.getSize();
        BufferedImage bufferfileOutPut = ImageIO.read(fileOutPut);
        DataBuffer datafileOutPut = bufferfileOutPut.getData().getDataBuffer();
        int sizefileOutPut = datafileOutPut.getSize();
        Boolean matchFlag = true;
        if (sizefileInput == sizefileOutPut) {
            for (int i = 0; i < sizefileInput; i++) {
                if (bufferfileInput.getElem(i) != datafileOutPut.getElem(i)) {
                    matchFlag = false;
                    break;
                }
            }
        } else {
            matchFlag = false;
        }
        return matchFlag;
    }
}