import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Paprio_ValidSignUp {

    static  WebDriver driver ;

    static List<String> validFirstNames = new ArrayList<>(List.of("Ephraim", "Mi","عز", "احمد"));
    static List<String> validLastNames = new ArrayList<>(List.of("Ephraim", "Mi","عز", "احمد"));
    static String validEmail = "mai123@gmail.com";
    static String validPassword = "Ephraim123##";
    static String validConfirmPassword = "Ephraim123##";



    public static void test() {
        for(String validFirstName : validFirstNames )
        {
            System.out.println(validFirstName);
        }
    }

    public static void SignUp_withValidFirstName(String firstName) throws InterruptedException {
        validEmail = TempMailGenerator.generateValidTempEmail();
        // Navigate to Sign Up Page
        driver.navigate().to("http://routetask.runasp.net/register");

        // Provide A Valid First Name
        driver.findElement(By.id("firstName")).sendKeys(firstName);

        // Provide Valid Data in the all other fields
        driver.findElement(By.id("lastName")).sendKeys("Hedia");
        driver.findElement(By.id("exampleInputEmail1")).sendKeys(validEmail);
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Ephraim123##");
        driver.findElement(By.id("exampleInputConfirmPassword1")).sendKeys("Ephraim123##");
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-register[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/button[1]/div[1]")).click();

        Thread.sleep(4000);
        if(driver.getCurrentUrl().contains("confirmation-sent-to-email"))
            System.out.println("First Name Test : Passed \t with data : " + firstName );
        else
            System.out.println("First Name Test : Failed \t with data : " + firstName );

    }

    public static void SignUp_withValidLastName(String lastName) throws InterruptedException {
        validEmail = TempMailGenerator.generateValidTempEmail();        // Navigate to Sign Up Page
        driver.navigate().to("http://routetask.runasp.net/register");

        // Provide A Valid First Name
        driver.findElement(By.id("firstName")).sendKeys("Ephraim");

        // Provide Valid Data in the all other fields
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("exampleInputEmail1")).sendKeys(validEmail);
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Ephraim123##");
        driver.findElement(By.id("exampleInputConfirmPassword1")).sendKeys("Ephraim123##");
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-register[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/button[1]/div[1]")).click();

        Thread.sleep(4000);
        if(driver.getCurrentUrl().contains("confirmation-sent-to-email"))
            System.out.println("Last Name Test : Passed \t with data : " + lastName );
        else
            System.out.println("Last Name Test : Failed \t with data : " + lastName );
    }

    public static void SignUp_withValidPassword(String password) throws InterruptedException {
        validEmail = TempMailGenerator.generateValidTempEmail();        // Navigate to Sign Up Page
        driver.navigate().to("http://routetask.runasp.net/register");

        // Provide A Valid First Name
        driver.findElement(By.id("firstName")).sendKeys("Ephraim");

        // Provide Valid Data in the all other fields
        driver.findElement(By.id("lastName")).sendKeys("Hedia");
        driver.findElement(By.id("exampleInputEmail1")).sendKeys(validEmail);
        driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
        driver.findElement(By.id("exampleInputConfirmPassword1")).sendKeys("Ephraim123##");
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-register[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/button[1]/div[1]")).click();

        Thread.sleep(4000);
        if(driver.getCurrentUrl().contains("confirmation-sent-to-email"))
            System.out.println("Valid Password Test : Passed \t with data : " + password );
        else
            System.out.println("Valid Password Test : Failed \t with data : " + password );

    }

    public static void SignUp_withValidConfirmPassword(String confirmPassword) throws InterruptedException {
        validEmail = TempMailGenerator.generateValidTempEmail();
        // Navigate to Sign Up Page
        driver.navigate().to("http://routetask.runasp.net/register");

        // Provide A Valid First Name
        driver.findElement(By.id("firstName")).sendKeys("Ephraim");

        // Provide Valid Data in the all other fields
        driver.findElement(By.id("lastName")).sendKeys("Hedia");
        driver.findElement(By.id("exampleInputEmail1")).sendKeys(validEmail);
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Ephraim123##");
        driver.findElement(By.id("exampleInputConfirmPassword1")).sendKeys(confirmPassword);
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-register[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/button[1]/div[1]")).click();

        Thread.sleep(4000);
        if(driver.getCurrentUrl().contains("confirmation-sent-to-email"))
            System.out.println("Valid Confirm Password Test : Passed \twith data : " + confirmPassword );
        else
            System.out.println("Valid Confirm Password Test : Failed \twith data : " + confirmPassword );

    }

    public static void SignUp_withValidEmail(String email) throws InterruptedException {
        // Navigate to Sign Up Page
        driver.navigate().to("http://routetask.runasp.net/register");

        // Provide A Valid First Name
        driver.findElement(By.id("firstName")).sendKeys("Ephraim");

        // Provide Valid Data in the all other fields
        driver.findElement(By.id("lastName")).sendKeys("Hedia");
        driver.findElement(By.id("exampleInputEmail1")).sendKeys(email);
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Ephraim123##");
        driver.findElement(By.id("exampleInputConfirmPassword1")).sendKeys("Ephraim123##");
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-register[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/button[1]/div[1]")).click();

        Thread.sleep(4000);
        if(driver.getCurrentUrl().contains("confirmation-sent-to-email"))
            System.out.println("Valid Email Test : Passed \twith data : " + email );
        else
            System.out.println("Valid Email Test : Failed \twith data : " + email );
    }




    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Validate A Sign-Up with  Valid First Name
        for (String fistName : validFirstNames)
        {
            SignUp_withValidFirstName(fistName);
        }

        // Validate A Sign-Up with  Valid Last Name
        for (String lastName : validLastNames)
        {
            SignUp_withValidLastName(lastName);
        }

        // Validate A Sign-Up with  Valid Password
        SignUp_withValidPassword(validPassword);

        // Validate A Sign-Up with  Valid Confirm Password
        SignUp_withValidConfirmPassword(validConfirmPassword);


        // Validate A Sign-Up with  Valid Email

        validEmail = TempMailGenerator.generateValidTempEmail();
        SignUp_withValidEmail(validEmail);

        driver.quit();
    }
}
