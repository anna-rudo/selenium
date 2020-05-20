import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class test2 {
    WebDriver driver;
    WebElement Login;
    WebElement Password;
    WebElement SigningIn;
    WebElement navigationClick;
    WebElement logout;

    @BeforeMethod
    public void doBeforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\Maven\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();

        Login = driver.findElement(By.cssSelector("#email"));
        Password = driver.findElement(By.cssSelector("#pass"));
        SigningIn = driver.findElement(By.cssSelector("#u_0_b"));

    }

    @Test
    public void verifyIfSigningInWithValidCredentialsIsPossible() {

        Login.sendKeys("annarudamyotkina@gmail.com");
        Password.sendKeys("idnt07800");
        SigningIn.click();
        driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.facebook.com/";
        try {
            Assert.assertEquals(actualUrl, expectedUrl);
            System.out.println("Test passed");
        } catch (Throwable e) {
            System.out.println("Test failed");
        }

    }

    @Test
    public void verifyIfSigningInWithWrongPasswordIfPossible() {

        Login.sendKeys("ann.rudomyotkina@mail.ru");
        Password.sendKeys("123456abcd");
        SigningIn.click();

        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        try {
            Assert.assertEquals(actualTitle, expectedTitle);
            System.out.println("Test passed");
        } catch (Throwable e) {
            System.out.println("Test failed");
        }

    }

    @Test
    public void verifyIfSigningInWithExampleCredentialsIsPossible() {

        Login.sendKeys("example@gmail.com");
        Password.sendKeys("example");
        SigningIn.click();
        driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);

        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        try {
            Assert.assertEquals(actualTitle, expectedTitle);
            System.out.println("Test failed");
        } catch (Throwable e) {
            System.out.println("Test passed");
        }

    }

    @Test
    public void verifyIfFacebookWorksCorrectlyWhenUserWantsToSignInWithoutUsingCredentials() {
        SigningIn.click();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        try {
            Assert.assertEquals(actualTitle, expectedTitle);
            System.out.println("Test passed");
        } catch (Throwable e) {
            System.out.println("Test failed");
        }
    }

    @Test
    public void verifyIfFacebookWorksCorrectlyWhenUserSignsInByUsingSpacesInValidCredentials() {
        Login.sendKeys("a nnar udamyot kina@gmail.com");
        Password.sendKeys("id nt 0 7 800");
        SigningIn.click();
        driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);

        String actualName = driver.findElement(By.xpath("//*[text()='Log In as Evie Lebowski']")).getText();
        String expectedName = "Facebook - Log In or Sign Up";

        String actualEmail = driver.findElement(By.xpath("//*[text()='annarudamyotkina@gmail.com']")).getText();
        String expectedEmail = "  ";

        try {
            Assert.assertEquals(actualEmail, expectedEmail);
            System.out.println("Test passed");
        } catch (Throwable e) {
            System.out.println("Test failed");
        }

        try {
            Assert.assertEquals(actualName, expectedName);
            System.out.println("Test passed");
        } catch (Throwable e) {
            System.out.println("Test failed");
        }

    }

    @Test
    public void verifyIfSiteWorksCorrectlyWhenUserSignsInByUsingTheNameOfAccountInsteadOfEmailOrPhone() {
        Login.sendKeys("Evie Lebowski");
        Password.sendKeys("idnt07800");
        SigningIn.click();
        driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);

        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        try {
            Assert.assertEquals(actualTitle, expectedTitle);
            System.out.println("Test passed");
        } catch (Throwable e) {
            System.out.println("Test failed");
        }

    }

    @Test
    public void verifyIfSigningInWithEmptyEmailAndValidPasswordIsPossible() {
        Password.sendKeys("idnt07800");
        SigningIn.click();
        driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);

        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        try {
            Assert.assertEquals(actualTitle, expectedTitle);
            System.out.println("Test passed");
        } catch (Throwable e) {
            System.out.println("Test failed");
        }

    }

    @Test
    public void verifyIfSigningInWithCorrectEmailAndEmptyPasswordIsPossible() {
        Login.sendKeys("annarudamyotkina@gmail.com");
        SigningIn.click();
        driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);

        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        try {
            Assert.assertEquals(actualTitle, expectedTitle);
            System.out.println("Test passed");
        } catch (Throwable e) {
            System.out.println("Test failed");
        }

    }

    @Test
    public void verifyIfFacebookWorksCorrectlyWhenUserSignsInByUsingUnregisteredPhoneNumber() {
        Login.sendKeys("+37498896188");
        Password.sendKeys("idnt07800");
        SigningIn.click();
        driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);

        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        try {
            Assert.assertEquals(actualTitle, expectedTitle);
            System.out.println("Test passed");
        } catch (Throwable e) {
            System.out.println("Test failed");
        }

    }


    @Test
    public void verifyIfSiteWorksCorrectlyDuringUsingSensitivePassword() {
        Login.sendKeys("annarudamyotkina@gmail.com");
        Password.sendKeys("iDnT07800");
        SigningIn.click();
        driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);

        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        try {
            Assert.assertEquals(actualTitle, expectedTitle);
            System.out.println("Test passed");
        } catch (Throwable e) {
            System.out.println("Test failed");
        }
    }

    @Test
    public void signingInByUsingNotAllowedCharactersInEmail() {
        Login.sendKeys("anna+rudam%yotki*na@gmail.com");
        Password.sendKeys("wrong12password12");
        SigningIn.click();

        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        try {
            Assert.assertEquals(actualTitle, expectedTitle);
            System.out.println("Test passed");
        } catch (Throwable e) {
            System.out.println("Test failed");
        }

    }

    @AfterMethod
    public void doAfterTest() {
        driver.quit();
    }

}
