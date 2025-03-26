import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;


public class Paprio_InvalidSignUp {

    static  WebDriver driver ;

    static List<String> validFirstNames = new ArrayList<>(List.of("Ephraim", "Mi","عز", "احمد"));
    static List<String> validLastNames = new ArrayList<>(List.of("Ephraim", "Mi","عز", "احمد"));
    static String validEmail = "mai123@gmail.com";
    static String validPassword = "Ephraim123##";
    static String validConfirmPassword = "Ephraim123##";
    static List<String> invalidFirstNames = new ArrayList<>(List.of("L", "Thequickbrownfoxjumpsoverthelazydogseverydaysoon","Ephraim##$$", "EPhraim213456","Ephraimعمراشرف"));
    static List<String> invalidLastNames = new ArrayList<>(List.of("L", "Thequickbrownfoxjumpsoverthelazydogseverydaysoon","Ephraim##$$", "EPhraim213456","Ephraimعمراشرف"));
    static List<String> invalidPasswords= new ArrayList<>(List.of("Oma12$","OmarAsharf@","12345678##","OmarAharf12345","الحج جمال يرحب بكم 123 ##"));
    static List<String> invalidEmails= new ArrayList<>(List.of("omarAshraf123","omar Ashraf123@gmail.com","omarAsharf@gamil.com","omarAsharf123@gmail.cm","@gmail.com"));
    static String invalidConfirmPassword = "sdavcxvmdsfoisdffs";
    static String registeredEmail = "ephraimhedia2@gmail.com";


    public static void test() {
        for(String validFirstName : validFirstNames )
        {
            System.out.println(validFirstName);
        }
    }

    public static void SignUp_withInvalidFirstName(String firstName) throws InterruptedException {
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
            System.out.println("First Name Test : Failed \t with data : " + firstName );
        else
            System.out.println("First Name Test : Passed \t with data : " + firstName );
    }

    public static void SignUp_withInvalidLastName(String lastName) throws InterruptedException {
        validEmail = TempMailGenerator.generateValidTempEmail();
        // Navigate to Sign Up Page
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
            System.out.println("Last Name Test : Failed \t with data : " + lastName );
        else
            System.out.println("Last Name Test : Passed \t with data : " + lastName );
    }

    public static void SignUp_withInvalidPassword(String password) throws InterruptedException {
        validEmail = TempMailGenerator.generateValidTempEmail();
        // Navigate to Sign Up Page
        driver.navigate().to("http://routetask.runasp.net/register");

        // Provide A Valid First Name
        driver.findElement(By.id("firstName")).sendKeys("Ephraim");

        // Provide Valid Data in the all other fields
        driver.findElement(By.id("lastName")).sendKeys("Hedia");
        driver.findElement(By.id("exampleInputEmail1")).sendKeys(validEmail);
        driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
        driver.findElement(By.id("exampleInputConfirmPassword1")).sendKeys(password);
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-register[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/button[1]/div[1]")).click();

        Thread.sleep(4000);
        if(driver.getCurrentUrl().contains("confirmation-sent-to-email"))
            System.out.println("Valid Password Test : Failed \t with data : " + password );
        else
            System.out.println("Valid Password Test : Passed \t with data : " + password );

    }

    public static void SignUp_withInvalidConfirmPassword(String confirmPassword) throws InterruptedException {
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
            System.out.println("Valid Confirm Password Test : Failed \twith data : " + confirmPassword );
        else
            System.out.println("Valid Confirm Password Test : Passed \twith data : " + confirmPassword );

    }

    public static void SignUp_withInvalidEmail(String email) throws InterruptedException {
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
            System.out.println("Valid Email Test : Failed \twith data : " + email );
        else
            System.out.println("Valid Email Test : Passed \twith data : " + email );
    }

    public static void SignUp_withEmptyFirstName() throws InterruptedException {
        validEmail = TempMailGenerator.generateValidTempEmail();
        // Navigate to Sign Up Page
        driver.navigate().to("http://routetask.runasp.net/register");

        // Provide Valid Data in the all other fields
        driver.findElement(By.id("lastName")).sendKeys("Hedia");
        driver.findElement(By.id("exampleInputEmail1")).sendKeys(validEmail);
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Ephraim123##");
        driver.findElement(By.id("exampleInputConfirmPassword1")).sendKeys("Ephraim123##");
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-register[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/button[1]/div[1]")).click();

        Thread.sleep(4000);
        if(driver.getCurrentUrl().contains("confirmation-sent-to-email"))
            System.out.println("Empty First Name Test : Failed ");
        else
            System.out.println("Empty First Name Test : Passed ");
    }

    public static void SignUp_withEmptyLastName() throws InterruptedException {
        validEmail = TempMailGenerator.generateValidTempEmail();
        // Navigate to Sign Up Page
        driver.navigate().to("http://routetask.runasp.net/register");

        // Provide Valid Data in the all other fields
        driver.findElement(By.id("firstName")).sendKeys("Ephraim");
        driver.findElement(By.id("exampleInputEmail1")).sendKeys(validEmail);
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Ephraim123##");
        driver.findElement(By.id("exampleInputConfirmPassword1")).sendKeys("Ephraim123##");
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-register[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/button[1]/div[1]")).click();

        Thread.sleep(4000);
        if(driver.getCurrentUrl().contains("confirmation-sent-to-email"))
            System.out.println("Empty Last Name Test : Failed");
        else
            System.out.println("Empty Last Name Test : Passed");
    }

    public static void SignUp_withEmptyEmail() throws InterruptedException {
        // Navigate to Sign Up Page
        driver.navigate().to("http://routetask.runasp.net/register");

        // Provide Valid Data in the all other fields
        driver.findElement(By.id("firstName")).sendKeys("Ephraim");
        driver.findElement(By.id("lastName")).sendKeys("Hedia");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Ephraim123##");
        driver.findElement(By.id("exampleInputConfirmPassword1")).sendKeys("Ephraim123##");
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-register[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/button[1]/div[1]")).click();

        Thread.sleep(4000);
        if(driver.getCurrentUrl().contains("confirmation-sent-to-email"))
            System.out.println("Empty Email Test : Failed");
        else
            System.out.println("Empty Email Test : Passed");
    }

    public static void SignUp_withEmptyPassword() throws InterruptedException {
        TempMailGenerator.generateValidTempEmail();
        // Navigate to Sign Up Page
        driver.navigate().to("http://routetask.runasp.net/register");

        // Provide Valid Data in the all other fields
        driver.findElement(By.id("firstName")).sendKeys("Ephraim");
        driver.findElement(By.id("lastName")).sendKeys("Hedia");
        driver.findElement(By.id("exampleInputEmail1")).sendKeys(validEmail);
        driver.findElement(By.id("exampleInputConfirmPassword1")).sendKeys("Ephraim123##");
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-register[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/button[1]/div[1]")).click();

        Thread.sleep(4000);
        if(driver.getCurrentUrl().contains("confirmation-sent-to-email"))
            System.out.println("Empty Password Test : Failed");
        else
            System.out.println("Empty Password Test : Passed");

    }

    public static void SignUp_withEmptyConfirmPassword() throws InterruptedException {
        validEmail = TempMailGenerator.generateValidTempEmail();

        // Navigate to Sign Up Page
        driver.navigate().to("http://routetask.runasp.net/register");

        // Provide Valid Data in the all other fields
        driver.findElement(By.id("firstName")).sendKeys("Ephraim");
        driver.findElement(By.id("lastName")).sendKeys("Hedia");
        driver.findElement(By.id("exampleInputEmail1")).sendKeys(validEmail);
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Ephraim123##");
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-register[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/button[1]/div[1]")).click();

        Thread.sleep(4000);
        if(driver.getCurrentUrl().contains("confirmation-sent-to-email"))
            System.out.println("Empty Confirm Password Test : Failed");
        else
            System.out.println("Empty Confirm Password Test : Passed");
    }


    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Validate A Sign-Up with  Invalid First Name
        for (String fistName : invalidFirstNames)
        {
            SignUp_withInvalidFirstName(fistName);
        }

        // Validate A Sign-Up with  Invalid Last Name
        for (String lastName : invalidLastNames)
        {
            SignUp_withInvalidLastName(lastName);
        }

        // Validate A Sign-Up with  Invalid Password
        for (String password : invalidPasswords)
        {
            SignUp_withInvalidPassword(password);
        }

        // Validate A Sign-Up with Invalid Confirm Password
        SignUp_withInvalidConfirmPassword(invalidConfirmPassword);

        // Validate A Sign-Up with  Invalid Email
        for (String email : invalidEmails)
        {
            SignUp_withInvalidEmail(email);
        }

        // Validate A Sign-Up with  Empty First Name
        SignUp_withEmptyFirstName();

        // Validate A Sign-Up with  Empty Last Name
        SignUp_withEmptyLastName();

        // Validate Sign-Up with  Empty Email
        SignUp_withEmptyEmail();

        // Validate A Sign-Up with  Empty Password
        SignUp_withEmptyPassword();

        // Validate Sign-Up with  Empty Confirm Passowrd
        SignUp_withEmptyConfirmPassword();

        driver.quit();
    }
}
