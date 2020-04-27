import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class FirstTestInSelenium {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\Maven\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");

        //signing up with valid credentials
        driver.findElement(By.id("email"))
              .sendKeys("wrong.example@gmail.com");
        driver.findElement(By.id("pass"))
              .sendKeys("something123");
        driver.findElement(By.id("u_0_b"))
              .click();

        String actualUrl="https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=110";
        String expectedUrl=driver.getCurrentUrl();

        if(actualUrl.contentEquals(expectedUrl))
        {
            System.out.println("Test passed");
        }
        else
        {
            System.out.println("Test failed");
        }



    }

}
