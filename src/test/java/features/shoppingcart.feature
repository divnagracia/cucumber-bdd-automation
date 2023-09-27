Feature: Shopping Cart

@ShoppingCart
  Scenario: Check out items in the shopping cart
    Given I am in Products List page
    When I click Shopping Cart Badge
    And click Checkout button
    Then redirected to Checkout Information page
