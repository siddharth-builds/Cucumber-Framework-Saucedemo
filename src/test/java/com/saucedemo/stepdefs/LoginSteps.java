package com.saucedemo.stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utils.DriverFactory;
import io.cucumber.java.en.*;

public class LoginSteps {
    private WebDriver driver = DriverFactory.getDriver();
    private LoginPage loginPage = new LoginPage(driver);

    @Given("User is on the SauceDemo login page")
    public void user_is_on_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @Given("User is logged in with username {string} and password {string}")
    public void user_is_logged_in(String username, String password) {
        driver.get("https://www.saucedemo.com/");
        loginPage.login(username, password);
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("User clicks the login button")
    public void user_clicks_login() {
        loginPage.clickLogin();
    }

    @Then("Error message should be displayed containing {string}")
    public void error_message_displayed(String expectedError) {
        Assert.assertTrue(loginPage.getErrorMessage().contains(expectedError));
    }

    @Then("User should be redirected to inventory page showing {string}")
    public void verify_redirect(String expectedUrl) {
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl));
    }
}