package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.lv.Un;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Activity4 {

    WebDriver driver;
    @BeforeClass
    @Given("Open the browser")
    public void open_the_browser() {

        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"NULL");

        driver=new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    @When("Navigate to URL")
    public void navigate_to_url() {

        WebElement Uname = driver.findElement(By.xpath("//input[@name='user_name']"));
        Uname.sendKeys("admin");

        WebElement Password = driver.findElement(By.xpath("//input[@name='username_password']"));
        Password.sendKeys("pa$$w0rd");

        WebElement login = driver.findElement(By.xpath("//input[@name='Login']"));
        login.click();
    }
    @AfterClass
    @Then("Verify that the homepage has opened")
    public void verify_that_the_homepage_has_opened() {

        //Verify the Homepage as opened successfully

        String actualUrl="https://alchemy.hguy.co/crm/index.php?module=Home&action=index";
        System.out.println("Actual URL : " + actualUrl);
        String expectedUrl= driver.getCurrentUrl();
        System.out.println("Expected URL : " + expectedUrl);
        Assert.assertEquals(expectedUrl,actualUrl);

    }
    @AfterClass
    @Then("Close the browser")
    public void close_the_browser() {

        driver.close();
    }

}
