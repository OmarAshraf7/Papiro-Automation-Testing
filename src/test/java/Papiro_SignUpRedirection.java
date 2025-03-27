import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Papiro_SignUpRedirection {
    static  WebDriver driver ;

    public static void ValidateRedirectionToConfirmEmailPage(WebDriver localDriver) throws InterruptedException {
        String TempEmail = TempMailGenerator.generateValidTempEmail();
        Paprio_ValidSignUp.SignUp_withValidEmail(localDriver,TempEmail);
        if(localDriver.getCurrentUrl().contains("confirmation-sent-to-email"))
            System.out.println("Redirection to Confirm Email Page: Passed ");
        else
            System.out.println("Redirection to Confirm Email Page: Failed ");
    }

    public static void ValidateRedirectionToLoginPage(WebDriver Local_driver) throws InterruptedException {
        Local_driver.navigate().to("http://routetask.runasp.net/register");
        Local_driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();

        Thread.sleep(2000);
        if(Local_driver.getCurrentUrl().contains("login"))
            System.out.println("Redirection From Register Page to Login Page Test: Passed");
        else
            System.out.println("Redirection From Register Page to Login Page Test: Failed");
    }


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ValidateRedirectionToConfirmEmailPage(driver);
        ValidateRedirectionToLoginPage(driver);
        driver.quit();
    }
}