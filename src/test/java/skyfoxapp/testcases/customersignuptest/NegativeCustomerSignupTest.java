//package skyfoxapp.testcases.testcasescustomersignuptest;
//
//import base.BaseTest;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import pages.CustomerSignupPage;
//import pages.LoginPage;
//
//public class NegativeCustomerSignupTest extends BaseTest {
//
//    LoginPage loginpage;
//    CustomerSignupPage customersignuppage;
//
//    @BeforeClass
//    public void openBrowser() {
//        setUp();
//        loginpage = new LoginPage(driver);
//        loginpage.openLoginPageUrl();
//    }
//
//    @Test(priority = 2)
//    public void customerSignupPageTest(String full_name,String user_name,String email_id,String mobile_num,String pass,String confirm_pass,String expecter_failuremsg
//    ){
//        customersignuppage.clickSignupLink();
//
//        String actualUrl = customersignuppage.validateSignupPageUrl();
//        Assert.assertEquals(actualUrl, customersignuppage.url, "Actual page url is not as expected");
//
//        customersignuppage.sendName(full_name);
//
//        customersignuppage.sendUserName(user_name);
//        customersignuppage.emailId(email_id);
//        customersignuppage.mobile_number(mobile_num);
//        customersignuppage.password(pass);
//        customersignuppage.confirmPass(confirm_pass);
//    }
//
//
//
//    @AfterClass
//    public void closeBrowser() throws InterruptedException {
//        tearDown();
//    }
//}
