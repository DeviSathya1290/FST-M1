package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Activity7 {

    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    @Given("Open the browser to the Alchemy CRM site and login")
    public void open_the_browser_to_the_alchemy_crm_site_and_login() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"NULL");

        driver=new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    @When("Navigate to Sales -> Leads find the Additional information icon and click it")
    public void navigate_to_sales_leads_find_the_additional_information_icon_and_click_it() throws InterruptedException {
        WebElement User_name = driver.findElement(By.xpath("//input[@name='user_name']"));
        User_name.sendKeys("admin");

        WebElement Pass= driver.findElement(By.xpath("//input[@name='username_password']"));
        Pass.sendKeys("pa$$w0rd");

        WebElement Login = driver.findElement(By.xpath("//input[@name='Login']"));
        Login.click();

        //Navigate to Sales -> Leads

        WebElement sales = driver.findElement(By.xpath("//a[text()='Sales']"));
        sales.click();

        //Leads
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sales']//following-sibling::ul//li//a[text()='Leads']")));

        Actions acc = new Actions(driver);
        WebElement leads = driver.findElement(By.xpath("//a[text()='Sales']//following-sibling::ul//li//a[text()='Leads']"));
        acc.moveToElement(leads).click().perform();

    }
    @AfterClass
    @Then("Read the popup and print the phone number displayed in it.")
    public void read_the_popup_and_print_the_phone_number_displayed_in_it() {

        // Click on Additional detail icon

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@title='Additional Details'])[1]")));
        WebElement click_AD = driver.findElement(By.xpath("(//span[@title='Additional Details'])[1]"));
        click_AD.click();

        // Print the Mobile No displayed On it

        String phone = driver.findElement(By.xpath("//span[@class='phone']")).getText();
        System.out.println("Mobile_no on Additional Details :"+ phone);

    }
    @AfterClass
    @Then("Close a browser opened")
    public void close_a_browser_opened() {
        driver.close();

    }

}
