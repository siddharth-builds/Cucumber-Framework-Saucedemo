package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver d;

    // Locators
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton   = By.id("login-button");
    private final By errorMessage  = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        this.d = driver;
    }

    public void enterUsername(String Username) {
        d.findElement(usernameInput).clear();
        d.findElement(usernameInput).sendKeys(Username);
    }

    public void enterPassword(String Password) {
        d.findElement(passwordInput).clear();
        d.findElement(passwordInput).sendKeys(Password);
    }

    public void clickLogin() {
        d.findElement(loginButton).click();
    }

    public void login(String Username, String Password) {
        enterUsername(Username);
        enterPassword(Password);
        clickLogin();
    }

    public String getErrorMessage() {
        return d.findElement(errorMessage).getText();
    }
}