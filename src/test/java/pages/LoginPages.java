package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import java.time.Duration;

public class LoginPages {
    WebDriver driver;
    WebDriverWait wait;
    By usernameLocator = By.id("usernameInput");
    By passwordLocator = By.id("passwordInput");
    By loginButtonLocator = By.className("login-button");
    By websiteLogoLocator = By.className("login-website-logo");

    public LoginPages(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterUsername(String username){
        driver.findElement(usernameLocator).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(passwordLocator).sendKeys(password);
    }
    public void clickOnLoginButton(){
        driver.findElement(loginButtonLocator).click();
    }
    public void loginIntoApplication(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();
    }
    public void WebsiteLogo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(websiteLogoLocator));
        WebElement logo = driver.findElement(websiteLogoLocator);
        Assert.assertTrue(logo.isDisplayed());
        return;
    }

}
