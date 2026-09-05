package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private final WebDriver d;

    // Locators - Step One (Information)
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput  = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By errorMessage   = By.xpath("//h3[@data-test='error']");

    // Locators - Step Two (Overview)
    private final By finishButton   = By.id("finish");
    private final By completeHeader = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.d = driver;
    }

    public void fillCheckoutInformation(String firstName, String lastName, String postalCode) {
        d.findElement(firstNameInput).sendKeys(firstName);
        d.findElement(lastNameInput).sendKeys(lastName);
        d.findElement(postalCodeInput).sendKeys(postalCode);
    }

    public void clickContinue() {
        d.findElement(continueButton).click();
    }

    public void clickFinish() {
        d.findElement(finishButton).click();
    }

    public String getErrorMessage() {
        return d.findElement(errorMessage).getText();
    }

    public String getCompleteMessage() {
        return d.findElement(completeHeader).getText();
    }
}