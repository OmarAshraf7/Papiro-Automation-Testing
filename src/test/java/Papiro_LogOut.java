import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Papiro_LogOut {
    public static void ValidateLogout(WebDriver localDriver) throws InterruptedException
    {
        localDriver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-header[1]/app-navbar[1]/nav[1]/div[2]/div[1]/div[1]/div[2]/div[1]/a[2]")).click();
        Thread.sleep(2000);
        localDriver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-account[1]/button[1]")).click();
        localDriver.findElement(By.xpath("//button[contains(text(),'Yes, logout')]")).click();
        Thread.sleep(2000);
        if(localDriver.getCurrentUrl().contains("login"))
            System.out.println("The User is Logged out Successfully");
        else
            System.out.println("The User Log out Failed");
    }
    public static void main(String[] args) throws InterruptedException {

    }
}