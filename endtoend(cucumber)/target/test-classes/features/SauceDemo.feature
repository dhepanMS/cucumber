Feature: SauceDemo Checkout Flow

  Scenario: Complete checkout after adding products
    Given the user is on the SauceDemo login page
    When the user logs in with username "standard_user" and password "secret_sauce"
    And the user adds two products to the cart
    And the user clicks the cart and proceeds to checkout
    And the user fills first name "Deepan", last name "MS" and postal code "600001"
    And the user continues and finishes the order
    Then the user should return to the homepage and logout
