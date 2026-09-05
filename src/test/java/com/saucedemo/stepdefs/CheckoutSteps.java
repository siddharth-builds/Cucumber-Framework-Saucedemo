package com.saucedemo.stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.utils.DriverFactory;
import io.cucumber.java.en.*;

public class CheckoutSteps {
    private WebDriver driver = DriverFactory.getDriver();
    private CartPage cartPage = new CartPage(driver);
    private CheckoutPage checkoutPage = new CheckoutPage(driver);

    @Given("User clicks the checkout button")
    public void click_checkout() {
        cartPage.clickCheckout();
    }

    @When("User clicks the continue button")
    public void click_continue() {
        checkoutPage.clickContinue();
    }

    @When("User fills checkout information with {string}, {string}, and {string}")
    public void fill_checkout_info(String firstName, String lastName, String zip) {
        checkoutPage.fillCheckoutInformation(firstName, lastName, zip);
    }

    @When("User clicks the finish button")
    public void click_finish() {
        checkoutPage.clickFinish();
    }

    @Then("Order complete header should display {string}")
    public void verify_order_completion(String expectedMessage) {
        Assert.assertEquals(checkoutPage.getCompleteMessage(), expectedMessage);
    }
}