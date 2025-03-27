import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Papiro_LoginRedirection {
    static  WebDriver driver ;

    public static void ValidateRedirectionToForgetPasswordPage(WebDriver localDriver) throws InterruptedException {
        localDriver.navigate().to("http://routetask.runasp.net/login");
        localDriver.findElement(By.linkText("Forgot password?")).click();
        Thread.sleep(2000);
        //http://routetask.runasp.net/forget-password
        if(localDriver.getCurrentUrl().contains("forget-password"))
            System.out.println("Redirection From Login Page to Forget Password Test : Passed");
        else
            System.out.println("Redirection From Login Page to Forget Password Test : Failed");
    }

    public static void ValidateRedirectionToCreateAccountPage(WebDriver localDriver) throws InterruptedException {
        localDriver.navigate().to("http://routetask.runasp.net/login");
        localDriver.findElement(By.linkText("Create")).click();
        Thread.sleep(2000);
        //http://routetask.runasp.net/forget-password
        if(localDriver.getCurrentUrl().contains("register"))
            System.out.println("Redirection From Login Page to Register Page Test : Passed");
        else
            System.out.println("Redirection From Login Page to Register Page Test : Failed");
    }

    public static void ValidateRedirectionToUnauthorizedPages(WebDriver localDriver) throws InterruptedException {
        Papiro_ValidLogin.ValidateLoginWithRegisteredEmail(localDriver);
        localDriver.navigate().to("http://routetask.runasp.net/login");
        Thread.sleep(2000);
        if(localDriver.getCurrentUrl().contains("login"))
        {
            System.out.println("Test Failed , I Can Navigate to Login Page After Sign In");
            return ;
        }
        System.out.println("Test Passed: Couldn't navigate to Login Page again when logged in");

        localDriver.navigate().to("http://routetask.runasp.net/register");
        Thread.sleep(2000);
        if(localDriver.getCurrentUrl().contains("register"))
        {
            System.out.println("Test Failed , I Can Navigate to register Page After Sign In");
            return ;
        }
        System.out.println("Test Passed: Couldn't navigate to Register Page when logged in");

        localDriver.navigate().to("http://routetask.runasp.net/forget-password");
        Thread.sleep(2000);
        if(localDriver.getCurrentUrl().contains("forget-password"))
        {
            System.out.println("Test Failed , I Can Navigate to Forget Password Page After Sign In");
            return ;
        }
        System.out.println("Test Passed: Couldn't navigate to Forget Password Page when logged in");
        System.out.println("Redirection To All Unauthorized Pages Test : Passed");
        Papiro_LogOut.ValidateLogout(localDriver);
    }

    public static void ValidateNavigatingBackToHomePageAfterLogin(WebDriver localDriver) throws InterruptedException
    {
        Papiro_ValidLogin.ValidateLoginWithRegisteredEmail(localDriver);
        localDriver.navigate().back();
        Thread.sleep(2000);
        if(localDriver.getCurrentUrl().contains("login"))
            System.out.println("Validate to back to home page after login : Failed");
        else
            System.out.println("Validate Navigating back to home page after login : Passed");

        Papiro_LogOut.ValidateLogout(localDriver);
    }


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://routetask.runasp.net/");
        ValidateRedirectionToForgetPasswordPage(driver);
        ValidateRedirectionToCreateAccountPage(driver);
        ValidateNavigatingBackToHomePageAfterLogin(driver);
        ValidateRedirectionToUnauthorizedPages(driver);
        driver.quit();
    }
}