Feature: Checkout

@ShoppingCart
  Scenario Outline: Populate all fields in Checkout Information
    Given I am in Checkout Information page
    When I enter <firstname>
    And enter <lastname>
    And enter <postalcode>
    And click Continue
    Then redirected to Checkout Review page
