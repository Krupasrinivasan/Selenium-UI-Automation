package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void sleep() throws InterruptedException {
        Thread.sleep(500);
    }
    public void tearDown() {
        driver.quit();
    }

}
