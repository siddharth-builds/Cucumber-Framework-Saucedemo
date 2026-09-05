Feature: Swag Labs Login Functionality

  Scenario: Login with empty fields
    Given User is on the SauceDemo login page
    When User clicks the login button
    Then Error message should be displayed containing "Username is required"

  Scenario: Login with locked out user
    Given User is on the SauceDemo login page
    When User enters username "locked_out_user" and password "secret_sauce"
    And User clicks the login button
    Then Error message should be displayed containing "Sorry, this user has been locked out"

  Scenario: Login with invalid credentials
    Given User is on the SauceDemo login page
    When User enters username "invalid_user" and password "wrong_pass"
    And User clicks the login button
    Then Error message should be displayed containing "Username and password do not match"

  Scenario: Login with valid credentials
    Given User is on the SauceDemo login page
    When User enters username "standard_user" and password "secret_sauce"
    And User clicks the login button
    Then User should be redirected to inventory page showing "inventory.html"