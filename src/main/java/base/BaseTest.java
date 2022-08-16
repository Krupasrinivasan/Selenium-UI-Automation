package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void sleep() throws InterruptedException {
        Thread.sleep(1000);
    }
    public void tearDown() {
        driver.quit();
    }

}
