package com.saucedemo.stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.utils.DriverFactory;
import io.cucumber.java.en.*;

public class CartSteps {
    private WebDriver driver = DriverFactory.getDriver();
    private InventoryPage inventoryPage = new InventoryPage(driver);
    private CartPage cartPage = new CartPage(driver);

    @When("User adds {string} to the cart")
    public void add_product_to_cart(String item) {
        inventoryPage.addBackpackToCart();
    }

    @Then("Cart badge count should be {string}")
    public void verify_cart_badge(String count) {
        Assert.assertEquals(inventoryPage.getCartBadgeCount(), count);
    }

    @Given("User navigates to the cart page")
    public void navigate_to_cart() {
        driver.get("https://www.saucedemo.com/cart.html");
    }

    @Then("Item {string} should be visible in the cart")
    public void item_visible_in_cart(String expectedItem) {
        Assert.assertEquals(cartPage.getItemName(), expectedItem, "Item in cart mismatch!");
    }

    @When("User removes the item from the cart")
    public void remove_item() {
        cartPage.clickRemove();
    }

    @Then("The cart should be empty")
    public void verify_empty_cart() {
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart was expected to be empty!");
    }
}