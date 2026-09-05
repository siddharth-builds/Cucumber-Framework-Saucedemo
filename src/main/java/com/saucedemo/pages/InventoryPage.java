package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private final WebDriver d;

    private final By backpackAddToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartBadge            = By.className("shopping_cart_badge");

    public InventoryPage(WebDriver driver) {
        this.d = driver;
    }

    public void addBackpackToCart() {
        d.findElement(backpackAddToCartBtn).click();
    }

    public String getCartBadgeCount() {
        return d.findElement(cartBadge).getText();
    }
}