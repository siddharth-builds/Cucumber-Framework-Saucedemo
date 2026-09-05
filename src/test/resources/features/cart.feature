Feature: Swag Labs Cart and Product Functionality

  Background:
    Given User is logged in with username "standard_user" and password "secret_sauce"

  Scenario: Add product to cart from Inventory page
    When User adds "Sauce Labs Backpack" to the cart
    Then Cart badge count should be "1"

  Scenario: Verify item presence in Cart page
    Given User adds "Sauce Labs Backpack" to the cart
    And User navigates to the cart page
    Then Item "Sauce Labs Backpack" should be visible in the cart

  Scenario: Remove item from Cart
    Given User adds "Sauce Labs Backpack" to the cart
    And User navigates to the cart page
    When User removes the item from the cart
    Then The cart should be empty