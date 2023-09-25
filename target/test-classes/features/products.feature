Feature: Products

  @Inventory
  Scenario Outline: Add to Cart Item/s
    Given I am in Products List page
    When click Add to Cart to a selected <item>
    Then <quantity> reflected in cart
    And <item> has remove button

    Examples: 
      | item                              | quantity |
      | Sauce Labs Bike Light             |        1 |
      | Sauce Labs Onesie                 |        2 |
      | Test.allTheThings() T-Shirt (Red) |        3 |
