package tests;

import POMs.seleniumFacebookPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class seleniumFacebook{

    WebDriver driver;

    @BeforeMethod
    public void doBeforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
    }

    @Test
    public void verifyIfSigningInWithValidCredentialsIsPossible() {
        seleniumFacebookPOM loginPage = PageFactory.initElements(driver, seleniumFacebookPOM.class);
        loginPage.enterValidEmail();
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();
        loginPage.verifyURL();
    }

    @Test
    public void verifyIfSigningInWithWrongPasswordIfPossible() {
        seleniumFacebookPOM loginPage = PageFactory.initElements(driver, seleniumFacebookPOM.class);
        loginPage.enterValidEmail();
        loginPage.enterPassword("123456abcd");
        loginPage.clickOnLoginButton();
        loginPage.verifyTitle();
    }

    @Test
    public void verifyIfSigningInWithExampleCredentialsIsPossible() {
        seleniumFacebookPOM loginPage = PageFactory.initElements(driver, seleniumFacebookPOM.class);
        loginPage.enterEmail("example@gmail.com");
        loginPage.enterPassword("example");
        loginPage.clickOnLoginButton();
        loginPage.verifyTitle();
    }

    @Test
    public void verifyIfFacebookWorksCorrectlyWhenUserWantsToSignInWithoutUsingCredentials() {
        seleniumFacebookPOM loginPage = PageFactory.initElements(driver, seleniumFacebookPOM.class);
        loginPage.clickOnLoginButton();
        loginPage.verifyTitle();
    }

    @Test
    public void verifyIfFacebookWorksCorrectlyWhenUserSignsInByUsingSpacesInValidCredentials() {
        seleniumFacebookPOM loginPage = PageFactory.initElements(driver, seleniumFacebookPOM.class);
        loginPage.enterEmail("a nnar udamyot kina@gmail.com");
        loginPage.enterPassword("id nt 0 7 800");
        loginPage.clickOnLoginButton();
        driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
        loginPage.verifyTitle();
    }

    @Test
    public void verifyIfSiteWorksCorrectlyWhenUserSignsInByUsingTheNameOfAccountInsteadOfEmailOrPhone() {
        seleniumFacebookPOM loginPage = PageFactory.initElements(driver, seleniumFacebookPOM.class);
        loginPage.enterEmail("Evie Lebowski");
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();
        driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
        loginPage.verifyTitle();
    }

    @Test
    public void verifyIfSigningInWithEmptyEmailAndValidPasswordIsPossible() {
        seleniumFacebookPOM loginPage = PageFactory.initElements(driver, seleniumFacebookPOM.class);
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();
        loginPage.verifyTitle();
    }

    @Test
    public void verifyIfSigningInWithCorrectEmailAndEmptyPasswordIsPossible() {
        seleniumFacebookPOM loginPage = PageFactory.initElements(driver, seleniumFacebookPOM.class);
        loginPage.enterValidEmail();
        loginPage.clickOnLoginButton();
        loginPage.verifyTitle();
    }

    @Test
    public void verifyIfFacebookWorksCorrectlyWhenUserSignsInByUsingUnregisteredPhoneNumber() {
        seleniumFacebookPOM loginPage = PageFactory.initElements(driver, seleniumFacebookPOM.class);
        loginPage.enterEmail("+37498896188");
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();
        loginPage.verifyTitle();
    }


    @Test
    public void verifyIfSiteWorksCorrectlyWhenUserSignsInByUsingSensitivePassword() {
        seleniumFacebookPOM loginPage = PageFactory.initElements(driver, seleniumFacebookPOM.class);
        loginPage.enterValidEmail();
        loginPage.enterPassword("iDnT07800");
        loginPage.clickOnLoginButton();
        loginPage.verifyTitle();
    }

    @Test
    public void verifyIfFacebookWorksCorrectlyWhenUserSignsInByUsingNotAllowedCharactersInEmail() {
        seleniumFacebookPOM loginPage = PageFactory.initElements(driver, seleniumFacebookPOM.class);
        loginPage.enterEmail("anna+rudam%yotki*na@gmail.com");
        loginPage.enterValidPassword();
        loginPage.clickOnLoginButton();
        loginPage.verifyTitle();
    }

    @AfterMethod
    public void doAfterTest() {
        driver.quit();
    }
}