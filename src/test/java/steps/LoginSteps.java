package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.FacebookLoginPage;
import utils.DriverFactory;

public class LoginSteps {
    WebDriver driver;
    FacebookLoginPage fbLogin;

    @Given("I am on the facebook login page")
    public void i_am_on_the_facebook_login_page() {
        driver = DriverFactory.getDriver();
        driver.get("https://www.facebook.com/");
        fbLogin = new FacebookLoginPage(driver);
    }

    @When("I enter my email and password")
    public void i_enter_my_email_and_password() {
        fbLogin.enterEmail("metest@hotmail.com");
        fbLogin.enterPassword("test@test!!#");
    }

    @And("I click the login button")
    public void i_click_the_login_button() {
        fbLogin.clickLogin();
    }

    @Then("I should see the Facebook home page")
    public void i_should_see_the_facebook_home_page() {
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.contains("facebook.com")) {
            throw new AssertionError("Login failed or not redirected!");
        }
        DriverFactory.quitDriver();
    }
}