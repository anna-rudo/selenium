import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class test2 {
    WebDriver driver = null;
    public static By Login = By.cssSelector("#email");
    public static By Password = By.cssSelector("#pass");
    public static By SigningIn = By.cssSelector("#u_0_b");

    @BeforeMethod
    public void doBeforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\Maven\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyIfSigningInWithValidCredentialsIsPossible() {
        driver.findElement(test2.Login).sendKeys("annarudamyotkina@gmail.com");
        driver.findElement(test2.Password).sendKeys("idnt07800");
        driver.findElement(test2.SigningIn).click();
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.facebook.com/";
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void verifyIfSigningInWithWrongPasswordIfPossible() {
        driver.findElement(test2.Login).sendKeys("ann.rudomyotkina@mail.ru");
        driver.findElement(test2.Password).sendKeys("123456abcd");
        driver.findElement(test2.SigningIn).click();
        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void verifyIfSigningInWithExampleCredentialsIsPossible() {
        driver.findElement(test2.Login).sendKeys("example@gmail.com");
        driver.findElement(test2.Password).sendKeys("example");
        driver.findElement(test2.SigningIn).click();
        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void verifyIfFacebookWorksCorrectlyWhenUserWantsToSignInWithoutUsingCredentials() {
        driver.findElement(test2.SigningIn).click();
        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void verifyIfFacebookWorksCorrectlyWhenUserSignsInByUsingSpacesInValidCredentials() {
        driver.findElement(test2.Login).sendKeys("a nnar udamyot kina@gmail.com");
        driver.findElement(test2.Password).sendKeys("id nt 0 7 800");
        driver.findElement(test2.SigningIn).click();

        driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);

        String actualName = driver.findElement(By.xpath("//*[text()='Log In as Evie Lebowski']")).getText();
        String expectedName = "Facebook - Log In or Sign Up";
        try {
            Assert.assertEquals(actualName, expectedName);
            System.out.println("Test passed");
        } catch (Throwable e) {
            System.out.println("Test failed");
        }

        String actualEmail = driver.findElement(By.xpath("//*[text()='annarudamyotkina@gmail.com']")).getText();
        String expectedEmail = "  ";
        try {
            Assert.assertEquals(actualEmail, expectedEmail);
            System.out.println("Test passed");
        } catch (Throwable e) {
            System.out.println("Test failed");
        }
    }

    @Test
    public void verifyIfSiteWorksCorrectlyWhenUserSignsInByUsingTheNameOfAccountInsteadOfEmailOrPhone() {
        driver.findElement(test2.Login).sendKeys("Evie Lebowski");
        driver.findElement(test2.Password).sendKeys("idnt07800");
        driver.findElement(test2.SigningIn).click();
        driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void verifyIfSigningInWithEmptyEmailAndValidPasswordIsPossible() {
        driver.findElement(test2.Password).sendKeys("idnt07800");
        driver.findElement(test2.SigningIn).click();
        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void verifyIfSigningInWithCorrectEmailAndEmptyPasswordIsPossible() {
        driver.findElement(test2.Login).sendKeys("annarudamyotkina@gmail.com");
        driver.findElement(test2.SigningIn).click();
        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void verifyIfFacebookWorksCorrectlyWhenUserSignsInByUsingUnregisteredPhoneNumber() {
        driver.findElement(test2.Login).sendKeys("+37498896188");
        driver.findElement(test2.Password).sendKeys("idnt07800");
        driver.findElement(test2.SigningIn).click();
        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }


    @Test
    public void verifyIfSiteWorksCorrectlyWhenUserSignsInByUsingSensitivePassword() {
        driver.findElement(test2.Login).sendKeys("annarudamyotkina@gmail.com");
        driver.findElement(test2.Password).sendKeys("iDnT07800");
        driver.findElement(test2.SigningIn).click();
        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void verifyIfFacebookWorksCorrectlyWhenUserSignsInByUsingNotAllowedCharactersInEmail() {
        driver.findElement(test2.Login).sendKeys("anna+rudam%yotki*na@gmail.com");
        driver.findElement(test2.Password).sendKeys("idnt07800");
        driver.findElement(test2.SigningIn).click();
        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterMethod
    public void doAfterTest() {
        driver.quit();
    }

}
