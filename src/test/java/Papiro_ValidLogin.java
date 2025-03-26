import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.compress.archivers.zip.ScatterZipOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class Papiro_ValidLogin {

    static  WebDriver driver ;

    static List<String> validFirstNames = new ArrayList<>(List.of("Ephraim", "Mi","عز", "احمد"));
    static List<String> validLastNames = new ArrayList<>(List.of("Ephraim", "Mi","عز", "احمد"));
    static String registeredEmail = "ephraimhedia2@gmail.com";
    static String validPassword = "ephraim123@@";


    public static void ValidateLoginWithRegisteredEmail(WebDriver Local_driver) throws InterruptedException {


        Local_driver.navigate().to("http://routetask.runasp.net/login");
        Local_driver.findElement(By.id("exampleInputEmail1")).sendKeys(registeredEmail);
        Local_driver.findElement(By.id("exampleInputPassword1")).sendKeys(validPassword);
        Local_driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-login[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/button[1]")).click();
        Thread.sleep(5000);
        if(Local_driver.getCurrentUrl().contains("login"))
        {
            System.out.println("The Login Test : Failed ");
        }
        else
        {
            System.out.println("The Login Test : Passed ");
        }

    }
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() ;
        driver.get("http://routetask.runasp.net/");
        ValidateLoginWithRegisteredEmail(driver);
        driver.quit();
    }
}