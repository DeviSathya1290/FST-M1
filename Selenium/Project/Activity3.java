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

public class Activity3 {

    WebDriver driver;

    @BeforeClass
    @Given("User open the browser the given URL")
    public void user_open_the_browser_the_given_url() {

        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"NULL");

        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }

    @Test
    @When("Get the first copyright text in the footer")
    public void get_the_first_copyright_text_in_the_footer() {

        //Print the Text of the Footer

        String Text = driver.findElement(By.xpath("//a[@id='admin_options']")).getText();
        System.out.println("Copyright text of the footer : " + Text);

    }

    @AfterClass
    @Then("User close the browser opened")
    public void user_close_the_browser_opened() {
        driver.close();

    }

}
