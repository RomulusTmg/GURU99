import net.bytebuddy.asm.Advice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.openqa.selenium.Keys.ENTER;

public class Login {

    private WebDriver driver;

    @Before
    public void setup() { driver = new FirefoxDriver(); }
    @Test
    public void LoginToGuru99() throws InterruptedException {
        WebElement emailId;
        WebElement cookie;
        WebElement iframe;
        WebElement userId;
        WebElement password;
        WebElement login;

        driver.get("https://demo.guru99.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        iframe = driver.findElement(By.id("gdpr-consent-notice"));
        driver.switchTo().frame(iframe);

        cookie = driver.findElement(By.id("save"));
        cookie.click();

        driver.switchTo().defaultContent();
        Thread.sleep(2000);

        emailId = driver.findElement(By.name("emailid"));
        emailId.click();

        emailId.sendKeys("romulus2@mailinator.com");
        emailId.sendKeys(ENTER);
        Thread.sleep(5000);

        driver.get("https://demo.guru99.com/v4/");

        userId = driver.findElement(By.name("uid"));
        userId.click();
        userId.sendKeys("mngr554915");
        Thread.sleep(1000);

        password = driver.findElement(By.name("password"));
        password.click();
        password.sendKeys("1a!");
        Thread.sleep(1000);

        login = driver.findElement(By.name("btnLogin"));
        login.click();
        Thread.sleep(3000);

        WebElement newCustomer;

        newCustomer = driver.findElement(By.xpath("//a[starts-with(@href, 'addcustomerpage.php')]"));
        newCustomer.click();
    }

//    @After
//    public void tearDown(){
//        driver.quit();
//    }
}
