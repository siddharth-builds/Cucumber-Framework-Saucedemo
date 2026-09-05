package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private final WebDriver d;

    // Locators
    private final By cartItemName = By.className("inventory_item_name");
    private final By checkoutButton = By.id("checkout");
    private final By removeButton   = By.id("remove-sauce-labs-backpack");

    public CartPage(WebDriver driver) {
        this.d = driver;
    }

    public String getItemName() {
        return d.findElement(cartItemName).getText();
    }

    public void clickCheckout() {
        d.findElement(checkoutButton).click();
    }

    public void clickRemove() {
        d.findElement(removeButton).click();
    }

    public boolean isCartEmpty() {
        return d.findElements(cartItemName).isEmpty();
    }
}