package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Activity9 {

    public static void main(String[] args) {


        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");

        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Login the User with credentials

        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@name='Login']")).click();

        //Navigate to Sales -> Accounts page.

        WebElement sales = driver.findElement(By.xpath("//a[text()='Sales']"));
        sales.click();

        Actions acc = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sales']//following-sibling::ul//li//a[text()='Leads']")));
        WebElement leads = driver.findElement(By.xpath("//a[text()='Sales']//following-sibling::ul//li//a[text()='Leads']"));
        acc.moveToElement(leads).click().perform();

        String name , user ;
       //  System.out.println("\tName  User");
        for (int i=1;i<11;i++) {
            name = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[@field='name']")).getText();
           // System.out.println(name);
            user = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[@field='assigned_user_name']")).getText();
            System.out.println(i+ "    "+name+"   "+user);
        }

        driver.close();
    }
}
