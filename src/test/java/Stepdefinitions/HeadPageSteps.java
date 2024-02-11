package Stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.HeaderPages;
import java.time.Duration;
import java.util.List;
public class HeadPageSteps {
    WebDriver driver;
    HeaderPages headDriver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        headDriver = new HeaderPages(driver);
    }
    @Given("I am on Home")
    public void homePage(){
        headDriver.clickOnApplication("rahul","rahul@2021");
    }
    @Then("check logo")
    public void logo(){
        headDriver.homeWebsiteLogo();
    }
    @Then("check nav elements")
    public void nav(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        String total = "NotDisplayed";
        List<WebElement> navItems = driver.findElements(By.cssSelector("div[class='nav-content'] *"));
        if(navItems.size() > 0){
            total = "Displayed";
        } else {
            total = "NotDisplayed";
        }
    }
    @Then("Navigated to home movies using home nav link")
    public void homeMovies(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        WebElement homeNavElement = driver.findElement(By.xpath("//a[@class='nav-link active-nav-link']"));
        homeNavElement.click();
    }
    @Then("Navigated to popular movies using popular nav link")
    public void popularNav(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        WebElement popularButton = driver.findElement(By.xpath("//a[@class='nav-link']"));
        popularButton.click();
    }
    @Then("checking account")
    public void account(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("avatar-img")));
        WebElement accountImage = driver.findElement(By.className("avatar-img"));
        accountImage.click();

    }
    @After
    public void tearDown(){
        driver.quit();
    }
}

