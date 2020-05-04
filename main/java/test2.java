import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class test2 {
    WebDriver driver;
    WebElement Login;
    WebElement Password;
    WebElement SigningIn;

    @BeforeMethod
    public void doBeforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\Maven\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();

        Login = driver.findElement(By.cssSelector("#email"));
        Password = driver.findElement(By.cssSelector("#pass"));
        SigningIn = driver.findElement(By.cssSelector("#u_0_b"));

    };

    @Test
    public void firstTest() {
        System.out.println("signing in with wrong credentials");

        Login.sendKeys("abcd@gmail.com");
        Password.sendKeys("123456abcd");
        SigningIn.click();

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.facebook.com/login/";

        if(actualUrl.contentEquals(expectedUrl))
        {
            System.out.println("Test passed");
        }

    }

    @Test
    public void secondTest() {
        System.out.println("signing in with the correct credentials");

        Login.sendKeys("annarudamyotkina@gmail.com");
        Password.sendKeys("idnt07800");
        SigningIn.click();
        driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.facebook.com/";

        if(actualUrl.contentEquals(expectedUrl))
        {
            System.out.println("Test passed");
        }

    }

    @Test
    public void thirdTest() {
        System.out.println("signing in with example credentials");

        Login.sendKeys("example@gmail.com");
        Password.sendKeys("example");
        SigningIn.click();
        driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);

        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        try {
            Assert.assertEquals(actualTitle, expectedTitle);
            System.out.println("Test failed");
        } catch (Throwable e) {

        }

    }


   @AfterTest
    public void terminateBrowser() {
        //driver.close();
        //System.exit(0);
        driver.quit();
    }
}
