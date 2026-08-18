package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class FacebookLoginPage {
    WebDriver driver;

    // ✅ Use stable locators
    By emailField = By.cssSelector("input[name='email']");
    By passwordField = By.cssSelector("input[name='pass']");
    // Use the absolute XPath you found as a fallback
    By loginButton = By.xpath("//div[@id='login_form']//button | //div[@id='login_form']//input[@name='login']");


    public FacebookLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        WebElement emailInput = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passInput = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passInput.sendKeys(password);
    }

    public void clickLogin() {
        try {
            WebElement loginBtn = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.presenceOfElementLocated(loginButton));

            // Scroll into view and click via JavaScript
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginBtn);
            Thread.sleep(1000);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginBtn);

        } catch (Exception e) {
            System.out.println("Login button not found or not clickable: " + e.getMessage());
        }
    }
}
