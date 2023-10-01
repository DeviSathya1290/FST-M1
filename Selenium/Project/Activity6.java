package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Activity6 {

    WebDriver driver;

    @BeforeClass
    @Given("Open the browser with given URL")
    public void open_the_browser_with_given_url() {

        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"NULL");

        driver=new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    @When("Navigate to URL given and login using the credentials")
    public void navigate_to_url_given_and_login_using_the_credentials() {

        WebElement User_name = driver.findElement(By.xpath("//input[@name='user_name']"));
        User_name.sendKeys("admin");

        WebElement Pass= driver.findElement(By.xpath("//input[@name='username_password']"));
        Pass.sendKeys("pa$$w0rd");

        WebElement Login = driver.findElement(By.xpath("//input[@name='Login']"));
        Login.click();

    }
    @AfterClass
    @Then("Locate the navigation menu and ensure that the “Activities” menu item exists")
    public void locate_the_navigation_menu_and_ensure_that_the_activities_menu_item_exists() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement activities = driver.findElement(By.xpath("//a[text()='Activities']"));
        if(activities.isEnabled());
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Activities']")));
            activities.click();

        }

    }

    @AfterClass
    @Then("Close the opened browser")
    public void close_the_opened_browser() {
        driver.close();

    }
}
