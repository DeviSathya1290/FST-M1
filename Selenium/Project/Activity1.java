package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


import java.time.Duration;

public class Activity1 {

    WebDriver driver;

    @BeforeClass
    @Given("User open the browser")
    public void openPage() {
        //Create Instances
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"NULL");

        driver = new FirefoxDriver();
        //Open browser
        driver.get("https://alchemy.hguy.co/crm/");

    }
    @Test
    @When("User verify the Title of the navigated Webpage")
    public void user_verify_the_title_of_the_navigated_webpage() {
        //Read the page title
        String pageTitle = driver.getTitle();

        //Print the page title
        System.out.println("Page title is: " + pageTitle);
        Assert.assertEquals(driver.getTitle(),"SuiteCRM");
    }
    @AfterClass
    @Then("User close the browser")
    public void user_close_the_browser() {


        driver.close();

    }

}
