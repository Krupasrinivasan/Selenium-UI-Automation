//package pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class CustomerSignupPage {
//    WebDriver driver;
//    public String url = "http://ec2-65-2-126-57.ap-south-1.compute.amazonaws.com:3000/login";
//
//    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/form/div[3]")
//    WebElement signupPage;
//
//    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/form/div[3]/a")
//    WebElement signupLink;
//
//    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div/a/svg/path")
//    WebElement movieIcon;
//
//    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div/a/h5")
//    WebElement websiteName;
//
//    @FindBy(name = "name")
//    WebElement name;
//
//    @FindBy(name = "username")
//    WebElement username;
//
//    @FindBy(name = "email")
//    WebElement email;
//
//    @FindBy(name = "mobile_number")
//    WebElement mobile_number;
//
//    @FindBy(name = "password")
//    WebElement password;
//
//    @FindBy(name = "confirm_password")
//    WebElement confirm_password;
//
//    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/form/button/span[1]")
//    WebElement signupButton;
//
//    public CustomerSignupPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//
//    public void clickSignupLink() {
//        signupLink.click();
//    }
//
//    public String validateSignupPageUrl() {
//        return driver.getCurrentUrl();
//    }
//
//    public void sendName(String full_name) {
//
//        name.sendKeys(full_name);
//    }
//
//    public void sendUserName(String user_name) {
//
//        username.sendKeys(user_name);
//    }
//
//    public void emailId(String email_id) {
//
//        email.sendKeys(email_id);
//    }
//
//    public void mobile_number(String mobile_num) {
//
//        mobile_number.sendKeys(mobile_num);
//    }
//
//    public void password(String pass) {
//
//        password.sendKeys(pass);
//    }
//
//    public void confirmPass(String confirm_pass) {
//
//        confirm_password.sendKeys(confirm_pass);
//    }
//
//    public boolean validateSignupButton() {
//        return signupButton.isEnabled();
//    }
//
//}
