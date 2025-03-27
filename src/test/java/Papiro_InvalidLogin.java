import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Papiro_InvalidLogin {
    static  WebDriver driver ;
    static List<String> invalidFormatEmails = new ArrayList<>(List.of("ephraimhedia","ephraimhedia@gamil.com","ephraimhedia@gmail.cm"));
    static String invalidUnconfirmedEmail = "omar.ashraf.ammar2@gmail.com";
    static String validEmail = "ephraimhedia2@gmail.com";
    static String validPassword = "ephraim123@@";
    static String invalidPassword = "sadsdsad";

    public static void ValidateLoginWithInvalidEmail(WebDriver Local_driver,String email) throws InterruptedException {
        Local_driver.navigate().to("http://routetask.runasp.net/login");
        Local_driver.findElement(By.id("exampleInputEmail1")).sendKeys(email);
        Local_driver.findElement(By.id("exampleInputPassword1")).sendKeys(validPassword);
        Local_driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-login[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/button[1]")).click();
        Thread.sleep(2000);
        if(Local_driver.getCurrentUrl().contains("login"))
            System.out.println("Passed \twith data : " + email);
        else
            System.out.println("Failed \twith data : " + email);
    }

    public static void ValidateLoginWithIncorrectPassword(WebDriver Local_driver,String password) throws InterruptedException {
        Local_driver.navigate().to("http://routetask.runasp.net/login");
        Local_driver.findElement(By.id("exampleInputEmail1")).sendKeys(validEmail);
        Local_driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
        Local_driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-login[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/button[1]")).click();
        Thread.sleep(2000);
        if(Local_driver.getCurrentUrl().contains("login"))
            System.out.println("Login With Incorrect Password Test: Passed\t with data: " + password);
        else
            System.out.println("Login With Incorrect Password Test: Failed\t with data: " + password);
    }

    public static void ValidateLoginWithEmptyPassword(WebDriver Local_driver) throws InterruptedException {
        Local_driver.navigate().to("http://routetask.runasp.net/login");
        Local_driver.findElement(By.id("exampleInputEmail1")).sendKeys(validEmail);
        Local_driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-login[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/button[1]")).click();
        Thread.sleep(2000);
        if(Local_driver.getCurrentUrl().contains("login"))
            System.out.println("Login With Empty Password Test: Passed ");
        else
            System.out.println("Login With Empty Password Test: Failed ");
    }

    public static void ValidateLoginWithEmptyEmail(WebDriver Local_driver) throws InterruptedException {
        Local_driver.navigate().to("http://routetask.runasp.net/login");
        Local_driver.findElement(By.id("exampleInputPassword1")).sendKeys(validPassword);
        Local_driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-login[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/button[1]")).click();
        Thread.sleep(2000);
        if(Local_driver.getCurrentUrl().contains("login"))
            System.out.println("Login With Empty Email Test: Passed ");
        else
            System.out.println("Login With Empty Email Test: Failed ");
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver() ;
        driver.get("http://routetask.runasp.net/");

        //Validate Login With Wrong Format Emails
        for (String email : invalidFormatEmails)
        {
            System.out.print("Invalid Wrong Email Format Test: ");
            ValidateLoginWithInvalidEmail(driver, email);
        }

        //Validate Login With Unconfirmed Email
        System.out.print("Login with Unconfirmed Email Test: ");
        ValidateLoginWithInvalidEmail(driver,invalidUnconfirmedEmail);

        //Validate Login With Wrong Unregistered Email
        String TempEmail = TempMailGenerator.generateValidTempEmail();
        System.out.print("Login with Unregistered Email Test: ");
        ValidateLoginWithInvalidEmail(driver,TempEmail);

        //Validate Login With Incorrect Password
        ValidateLoginWithIncorrectPassword(driver,invalidPassword);

        //Validate Login With Leaving Email Field Empty
        ValidateLoginWithEmptyEmail(driver);

        //Validate Login With Leaving Password Field Empty
        ValidateLoginWithEmptyPassword(driver);

        driver.quit();
    }
}

