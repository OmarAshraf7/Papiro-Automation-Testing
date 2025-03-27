import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;


public class Paprio_InvalidSignUp {

    static  WebDriver driver ;

    static String validEmail = "mai123@gmail.com";
    static List<String> invalidFirstNames = new ArrayList<>(List.of("L", "Thequickbrownfoxjumpsoverthelazydogseverydaysoon","Ephraim##$$", "EPhraim213456","Ephraimعمراشرف"));
    static List<String> invalidLastNames = new ArrayList<>(List.of("L", "Thequickbrownfoxjumpsoverthelazydogseverydaysoon","Ephraim##$$", "EPhraim213456","Ephraimعمراشرف"));
    static List<String> invalidPasswords= new ArrayList<>(List.of("Oma12$","OmarAsharf@","12345678##","OmarAharf12345","الحج جمال يرحب بكم 123 ##"));
    static List<String> invalidEmails= new ArrayList<>(List.of("omarAshraf123","omar Ashraf123@gmail.com","omarAsharf@gamil.com","omarAsharf123@gmail.cm","@gmail.com"));
    static String invalidConfirmPassword = "sdavcxvmdsfoisdffs";
    static String registeredEmail = "ephraimhedia2@gmail.com";


    public static void SignUp_withInvalidFirstName(WebDriver localDriver,String firstName) throws InterruptedException {
        validEmail = TempMailGenerator.generateValidTempEmail();
        // Navigate to Sign Up Page
        localDriver.navigate().to("http://routetask.runasp.net/register");

        // Provide An Invalid First Name
        localDriver.findElement(By.id("firstName")).sendKeys(firstName);

        // Provide Valid Data in the all other fields
        localDriver.findElement(By.id("lastName")).sendKeys("Hedia");
        localDriver.findElement(By.id("exampleInputEmail1")).sendKeys(validEmail);
        localDriver.findElement(By.id("exampleInputPassword1")).sendKeys("Ephraim123##");
        localDriver.findElement(By.id("exampleInputConfirmPassword1")).sendKeys("Ephraim123##");
        localDriver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-register[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/button[1]/div[1]")).click();

        Thread.sleep(4000);
        if(localDriver.getCurrentUrl().contains("confirmation-sent-to-email"))
            System.out.println("First Name Test : Failed \t with data : " + firstName );
        else
            System.out.println("First Name Test : Passed \t with data : " + firstName );
    }

    public static void SignUp_withInvalidLastName(WebDriver localDriver,String lastName) throws InterruptedException {
        validEmail = TempMailGenerator.generateValidTempEmail();
        // Navigate to Sign Up Page
        localDriver.navigate().to("http://routetask.runasp.net/register");

        // Provide An Invalid Last Name
        localDriver.findElement(By.id("lastName")).sendKeys(lastName);

        // Provide Valid Data in the all other fields
        localDriver.findElement(By.id("firstName")).sendKeys("Ephraim");
        localDriver.findElement(By.id("exampleInputEmail1")).sendKeys(validEmail);
        localDriver.findElement(By.id("exampleInputPassword1")).sendKeys("Ephraim123##");
        localDriver.findElement(By.id("exampleInputConfirmPassword1")).sendKeys("Ephraim123##");
        localDriver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-register[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/button[1]/div[1]")).click();

        Thread.sleep(4000);
        if(localDriver.getCurrentUrl().contains("confirmation-sent-to-email"))
            System.out.println("Last Name Test : Failed \t with data : " + lastName );
        else
            System.out.println("Last Name Test : Passed \t with data : " + lastName );
    }

    public static void SignUp_withInvalidPassword(WebDriver localDriver,String password) throws InterruptedException {
        validEmail = TempMailGenerator.generateValidTempEmail();
        // Navigate to Sign Up Page
        localDriver.navigate().to("http://routetask.runasp.net/register");

        // Provide An Invalid Password
        localDriver.findElement(By.id("exampleInputPassword1")).sendKeys(password);

        // Provide Valid Data in the all other fields
        localDriver.findElement(By.id("firstName")).sendKeys("Ephraim");
        localDriver.findElement(By.id("lastName")).sendKeys("Hedia");
        localDriver.findElement(By.id("exampleInputEmail1")).sendKeys(validEmail);
        localDriver.findElement(By.id("exampleInputConfirmPassword1")).sendKeys(password);
        localDriver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-register[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/button[1]/div[1]")).click();

        Thread.sleep(4000);
        if(localDriver.getCurrentUrl().contains("confirmation-sent-to-email"))
            System.out.println("Valid Password Test : Failed \t with data : " + password );
        else
            System.out.println("Valid Password Test : Passed \t with data : " + password );

    }

    public static void SignUp_withInvalidConfirmPassword(WebDriver localDriver,String confirmPassword) throws InterruptedException {
        validEmail = TempMailGenerator.generateValidTempEmail();

        // Navigate to Sign Up Page
        localDriver.navigate().to("http://routetask.runasp.net/register");

        // Provide An Different Confirm Password
        localDriver.findElement(By.id("exampleInputConfirmPassword1")).sendKeys(confirmPassword);

        // Provide Valid Data in the all other fields
        localDriver.findElement(By.id("firstName")).sendKeys("Ephraim");
        localDriver.findElement(By.id("lastName")).sendKeys("Hedia");
        localDriver.findElement(By.id("exampleInputEmail1")).sendKeys(validEmail);
        localDriver.findElement(By.id("exampleInputPassword1")).sendKeys("Ephraim123##");
        localDriver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-register[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/button[1]/div[1]")).click();

        Thread.sleep(4000);
        if(localDriver.getCurrentUrl().contains("confirmation-sent-to-email"))
            System.out.println("Valid Confirm Password Test : Failed \twith data : " + confirmPassword );
        else
            System.out.println("Valid Confirm Password Test : Passed \twith data : " + confirmPassword );

    }

    public static void SignUp_withInvalidEmail(WebDriver localDriver,String email) throws InterruptedException {
        // Navigate to Sign Up Page
        localDriver.navigate().to("http://routetask.runasp.net/register");

        // Provide An Invalid Email
        localDriver.findElement(By.id("exampleInputEmail1")).sendKeys(email);

        // Provide Valid Data in the all other fields
        localDriver.findElement(By.id("firstName")).sendKeys("Ephraim");
        localDriver.findElement(By.id("lastName")).sendKeys("Hedia");
        localDriver.findElement(By.id("exampleInputPassword1")).sendKeys("Ephraim123##");
        localDriver.findElement(By.id("exampleInputConfirmPassword1")).sendKeys("Ephraim123##");
        localDriver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-register[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/button[1]/div[1]")).click();

        Thread.sleep(4000);
        if(localDriver.getCurrentUrl().contains("confirmation-sent-to-email"))
            System.out.println("Valid Email Test : Failed \twith data : " + email );
        else
            System.out.println("Valid Email Test : Passed \twith data : " + email );
    }

    public static void SignUp_withPreRegisteredEmail(WebDriver localDriver,String registeredEmail) throws InterruptedException {
        validEmail = TempMailGenerator.generateValidTempEmail();
        // Navigate to Sign Up Page
        localDriver.navigate().to("http://routetask.runasp.net/register");

        // Provide An Pre-registered Email
        localDriver.findElement(By.id("exampleInputEmail1")).sendKeys(registeredEmail);

        // Provide Valid Data in the all other fields
        localDriver.findElement(By.id("firstName")).sendKeys("Ephraim");
        localDriver.findElement(By.id("lastName")).sendKeys("Hedia");
        localDriver.findElement(By.id("exampleInputPassword1")).sendKeys("Ephraim123##");
        localDriver.findElement(By.id("exampleInputConfirmPassword1")).sendKeys("Ephraim123##");
        localDriver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-register[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/button[1]/div[1]")).click();

        Thread.sleep(4000);
        if(localDriver.getCurrentUrl().contains("confirmation-sent-to-email"))
            System.out.println("Pre-registered Email Test : Failed \t with data : " + registeredEmail );
        else
            System.out.println("Pre-registered Email Test : Passed \t with data : " + registeredEmail );
    }

    public static void SignUp_withEmptyFirstName(WebDriver localDriver) throws InterruptedException {
        validEmail = TempMailGenerator.generateValidTempEmail();
        // Navigate to Sign Up Page
        localDriver.navigate().to("http://routetask.runasp.net/register");

        // Leave First Name Field Empty and Provide Valid Data in the all other fields
        localDriver.findElement(By.id("lastName")).sendKeys("Hedia");
        localDriver.findElement(By.id("exampleInputEmail1")).sendKeys(validEmail);
        localDriver.findElement(By.id("exampleInputPassword1")).sendKeys("Ephraim123##");
        localDriver.findElement(By.id("exampleInputConfirmPassword1")).sendKeys("Ephraim123##");
        localDriver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-register[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/button[1]/div[1]")).click();

        Thread.sleep(4000);
        if(localDriver.getCurrentUrl().contains("confirmation-sent-to-email"))
            System.out.println("Empty First Name Test : Failed ");
        else
            System.out.println("Empty First Name Test : Passed ");
    }

    public static void SignUp_withEmptyLastName(WebDriver localDriver) throws InterruptedException {
        validEmail = TempMailGenerator.generateValidTempEmail();
        // Navigate to Sign Up Page
        localDriver.navigate().to("http://routetask.runasp.net/register");

        // Leave Last Name Field Empty and Provide Valid Data in the all other fields
        localDriver.findElement(By.id("firstName")).sendKeys("Ephraim");
        localDriver.findElement(By.id("exampleInputEmail1")).sendKeys(validEmail);
        localDriver.findElement(By.id("exampleInputPassword1")).sendKeys("Ephraim123##");
        localDriver.findElement(By.id("exampleInputConfirmPassword1")).sendKeys("Ephraim123##");
        localDriver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-register[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/button[1]/div[1]")).click();

        Thread.sleep(4000);
        if(localDriver.getCurrentUrl().contains("confirmation-sent-to-email"))
            System.out.println("Empty Last Name Test : Failed");
        else
            System.out.println("Empty Last Name Test : Passed");
    }

    public static void SignUp_withEmptyEmail(WebDriver localDriver) throws InterruptedException {
        // Navigate to Sign Up Page
        localDriver.navigate().to("http://routetask.runasp.net/register");

        // Leave Email Field Empty and Provide Valid Data in the all other fields
        localDriver.findElement(By.id("firstName")).sendKeys("Ephraim");
        localDriver.findElement(By.id("lastName")).sendKeys("Hedia");
        localDriver.findElement(By.id("exampleInputPassword1")).sendKeys("Ephraim123##");
        localDriver.findElement(By.id("exampleInputConfirmPassword1")).sendKeys("Ephraim123##");
        localDriver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-register[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/button[1]/div[1]")).click();

        Thread.sleep(4000);
        if(localDriver.getCurrentUrl().contains("confirmation-sent-to-email"))
            System.out.println("Empty Email Test : Failed");
        else
            System.out.println("Empty Email Test : Passed");
    }

    public static void SignUp_withEmptyPassword(WebDriver localDriver) throws InterruptedException {
        TempMailGenerator.generateValidTempEmail();
        // Navigate to Sign Up Page
        localDriver.navigate().to("http://routetask.runasp.net/register");

        // Leave Password Field Empty and Provide Valid Data in the all other fields
        localDriver.findElement(By.id("firstName")).sendKeys("Ephraim");
        localDriver.findElement(By.id("lastName")).sendKeys("Hedia");
        localDriver.findElement(By.id("exampleInputEmail1")).sendKeys(validEmail);
        localDriver.findElement(By.id("exampleInputConfirmPassword1")).sendKeys("Ephraim123##");
        localDriver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-register[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/button[1]/div[1]")).click();

        Thread.sleep(4000);
        if(localDriver.getCurrentUrl().contains("confirmation-sent-to-email"))
            System.out.println("Empty Password Test : Failed");
        else
            System.out.println("Empty Password Test : Passed");

    }

    public static void SignUp_withEmptyConfirmPassword(WebDriver localDriver) throws InterruptedException {
        validEmail = TempMailGenerator.generateValidTempEmail();

        // Navigate to Sign Up Page
        localDriver.navigate().to("http://routetask.runasp.net/register");

        // Leave Confirm Password Field Empty and Provide Valid Data in the all other fields
        localDriver.findElement(By.id("firstName")).sendKeys("Ephraim");
        localDriver.findElement(By.id("lastName")).sendKeys("Hedia");
        localDriver.findElement(By.id("exampleInputEmail1")).sendKeys(validEmail);
        localDriver.findElement(By.id("exampleInputPassword1")).sendKeys("Ephraim123##");
        localDriver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-register[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/button[1]/div[1]")).click();

        Thread.sleep(4000);
        if(localDriver.getCurrentUrl().contains("confirmation-sent-to-email"))
            System.out.println("Empty Confirm Password Test : Failed");
        else
            System.out.println("Empty Confirm Password Test : Passed");
    }




    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Validate Sign-Up with Invalid First Name
        for (String fistName : invalidFirstNames)
        {
            SignUp_withInvalidFirstName(driver ,fistName);
        }

        // Validate Sign-Up with  Invalid Last Name
        for (String lastName : invalidLastNames)
        {
            SignUp_withInvalidLastName(driver,lastName);
        }

        // Validate Sign-Up with  Invalid Password
        for (String password : invalidPasswords)
        {
            SignUp_withInvalidPassword(driver,password);
        }

        // Validate Sign-Up with Invalid Confirm Password
        SignUp_withInvalidConfirmPassword(driver,invalidConfirmPassword);

        // Validate Sign-Up with  Invalid Email
        for (String email : invalidEmails)
        {
            SignUp_withInvalidEmail(driver,email);
        }

        // Validate Sign-Up with Pre-registered Email
        SignUp_withPreRegisteredEmail(driver,registeredEmail);

        // Validate Sign-Up with  Empty First Name
        SignUp_withEmptyFirstName(driver);

        // Validate Sign-Up with  Empty Last Name
        SignUp_withEmptyLastName(driver);

        // Validate Sign-Up with  Empty Email
        SignUp_withEmptyEmail(driver);

        // Validate Sign-Up with  Empty Password
        SignUp_withEmptyPassword(driver);

        // Validate Sign-Up with  Empty Confirm Passowrd
        SignUp_withEmptyConfirmPassword(driver);

        driver.quit();
    }
}
