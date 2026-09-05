Feature: Swag Labs Checkout Functionality

  Background:
    Given User is logged in with username "standard_user" and password "secret_sauce"
    And User adds "Sauce Labs Backpack" to the cart
    And User navigates to the cart page
    And User clicks the checkout button

  Scenario: Checkout with empty fields
    When User clicks the continue button
    Then Error message should be displayed containing "First Name is required"

  Scenario: Complete successful order
    When User fills checkout information with "John", "Doe", and "12345"
    And User clicks the continue button
    And User clicks the finish button
    Then Order complete header should display "Thank you for your order!"