package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Activity5 {

    WebDriver driver;
    @BeforeClass
    @Given("Open a browser")
    public void open_a_browser() {

        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"NULL");

        driver=new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    @When("Navigate to URL and login using the credentials")
    public void navigate_to_url_and_login_using_the_credentials() {

        WebElement Username = driver.findElement(By.xpath("//input[@name='user_name']"));
        Username.sendKeys("admin");

        WebElement Password = driver.findElement(By.xpath("//input[@name='username_password']"));
        Password.sendKeys("pa$$w0rd");

        WebElement login = driver.findElement(By.xpath("//input[@name='Login']"));
        login.click();

    }
    @AfterClass
    @Then("Get the color of the navigation menu and print it to the console")
    public void get_the_color_of_the_navigation_menu_and_print_it_to_the_console() {

        //Get the color of the navigation menu

        String Navigation_Menu =driver.findElement(By.xpath("//div[@id='toolbar']")).getCssValue("color");
        System.out.println("Color of the Navigation Menu :"+ Navigation_Menu);

    }
    @AfterClass
    @Then("close a Browser")
    public void close_a_browser() {
        driver.close();

    }
}
