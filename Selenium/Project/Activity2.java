package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Activity2 {

    WebDriver driver;
    @BeforeClass
    @Given("User open browser")
    public void user_open_browser() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"NULL");

        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @Test
    @When("User Navigate to the webpage and print the header image on the console")
    public void user_navigate_to_the_webpage_and_print_the_header_image_on_the_console() {

        String Url = driver.getCurrentUrl();
        System.out.println("Title of the Website : " + Url);

        String Image_header =driver.findElement(By.xpath("//*[@alt='SuiteCRM']")).
                getAttribute("src");
        System.out.println("Header of the Image URL : " + Image_header);

    }
    @AfterClass
    @Then("User close Browser")
    public void user_close_browser() {
        driver.close();

    }
    }
