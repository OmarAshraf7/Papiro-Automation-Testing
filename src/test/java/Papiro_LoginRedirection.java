import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Papiro_LoginRedirection {
    static  WebDriver driver ;

    public static void ValidateRedirectionToForgetPasswordPage(WebDriver Local_driver) throws InterruptedException {
        Local_driver.navigate().to("http://routetask.runasp.net/login");
        Local_driver.findElement(By.linkText("Forgot password?")).click();
        Thread.sleep(2000);
        //http://routetask.runasp.net/forget-password
        if(Local_driver.getCurrentUrl().contains("forget-password"))
            System.out.println("Redirection From Login Page to Forget Password Test : Passed");
        else
            System.out.println("Redirection From Login Page to Forget Password Test : Failed");
    }

    public static void ValidateRedirectionToCreateAccountPage(WebDriver Local_driver) throws InterruptedException {
        Local_driver.navigate().to("http://routetask.runasp.net/login");
        Local_driver.findElement(By.linkText("Create")).click();
        Thread.sleep(2000);
        //http://routetask.runasp.net/forget-password
        if(Local_driver.getCurrentUrl().contains("register"))
            System.out.println("Redirection From Login Page to Register Page Test : Passed");
        else
            System.out.println("Redirection From Login Page to Register Page Test : Failed");
    }

    public static void ValidateRedirectionToUnauthorizedPages(WebDriver Local_driver) throws InterruptedException {
        Papiro_ValidLogin.ValidateLoginWithRegisteredEmail(Local_driver);
        Local_driver.navigate().to("http://routetask.runasp.net/login");
        Thread.sleep(2000);
        if(Local_driver.getCurrentUrl().contains("login"))
        {
            System.out.println("Test Failed , I Can Navigate to Login Page After Sign In");
            return ;
        }
        System.out.println("Test Passed: Couldn't navigate to Login Page again when logged in");

        Local_driver.navigate().to("http://routetask.runasp.net/register");
        Thread.sleep(2000);
        if(Local_driver.getCurrentUrl().contains("register"))
        {
            System.out.println("Test Failed , I Can Navigate to register Page After Sign In");
            return ;
        }
        System.out.println("Test Passed: Couldn't navigate to Register Page when logged in");

        Local_driver.navigate().to("http://routetask.runasp.net/forget-password");
        Thread.sleep(2000);
        if(Local_driver.getCurrentUrl().contains("forget-password"))
        {
            System.out.println("Test Failed , I Can Navigate to Forget Password Page After Sign In");
            return ;
        }
        System.out.println("Test Passed: Couldn't navigate to Forget Password Page when logged in");
        System.out.println("Redirection To All Unauthorized Pages Test : Passed");
    }

    public static void ValidateToBackToHomePageAfterLogin(WebDriver Local_driver) throws InterruptedException
    {
        Papiro_ValidLogin.ValidateLoginWithRegisteredEmail(Local_driver);
        Local_driver.navigate().back();
        Thread.sleep(2000);
        if(Local_driver.getCurrentUrl().contains("login"))
            System.out.println("Validate to back to home page after login : Failed");
        else
            System.out.println("Validate to back to home page after login : Passed");
    }

    public static void ValidateToLogout(WebDriver Local_driver) throws InterruptedException
    {
        Local_driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-header[1]/app-navbar[1]/nav[1]/div[2]/div[1]/div[1]/div[2]/div[1]/a[2]")).click();
        Thread.sleep(2000);
        Local_driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-account[1]/button[1]")).click();
        Local_driver.findElement(By.xpath("//button[contains(text(),'Yes, logout')]")).click();
        Thread.sleep(2000);
        if(Local_driver.getCurrentUrl().contains("login"))
            System.out.println("The User is Logged out Successfully");
        else
            System.out.println("The User Logged out Failed");
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://routetask.runasp.net/");
        ValidateRedirectionToForgetPasswordPage(driver);
        ValidateRedirectionToCreateAccountPage(driver);
        ValidateToBackToHomePageAfterLogin(driver);
        ValidateToLogout(driver);
        ValidateRedirectionToUnauthorizedPages(driver);
        ValidateToLogout(driver);
        driver.quit();
    }
}