package POMs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class seleniumFacebookPOM {

    private WebDriver driver;

    @FindBy(how = How.CSS, using = "#email")
    WebElement email;

    @FindBy(how = How.CSS, using = "#pass")
    WebElement password;

    @FindBy(how = How.CSS, using = "#u_0_b")
    WebElement loginButton;

    public seleniumFacebookPOM (WebDriver driver){
        this.driver = driver;
        //PageFactory.initElements(driver,this);
    }

    public void enterValidEmail() {
        email.sendKeys("annarudamyotkina@gmail.com");
    }

    public void enterValidPassword() {
        password.sendKeys("idnt07800");
    }

    public void enterEmail(String strEmail) {
        email.sendKeys(strEmail);
    }

    public void enterPassword(String strPassword) {
        password.sendKeys(strPassword);
    }

    public void clickOnLoginButton() {
        loginButton.click();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
    }

    public void verifyTitle() {
        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        try {
            Assert.assertEquals(actualTitle, expectedTitle);
            System.out.println("Test passed");
        } catch (Throwable e) {
            System.out.println("Test failed");
        }
    }

    public boolean verifyURL() {
        if (driver.getCurrentUrl().equals("https://www.facebook.com/")) {
            return true;
        } else {
            return false;
        }
    }

//    public boolean verifyTitle() {
//        if (driver.getTitle().equals("Log into Facebook | Facebook")) {
//            return true;
//        } else {
//            return false;
//        }
//    }

}
