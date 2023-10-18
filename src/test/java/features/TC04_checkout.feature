Feature: Checkout

  @CheckOut
  Scenario Outline: Populate all fields in Checkout Information
    Given I am in Checkout Information page
    When I enter firstName <firstname>
    And enter lastName <lastname>
    And enter postalCode <postalcode>
    And click Continue
    Then I am in Checkout Review page

    Examples: 
      | firstname | lastname | postalcode |
      | Juan    | Cruz    |       1550 |

  Scenario: Checkout items
    Given I am in Checkout Review page
    When I verify the no. of item name, item description and price are displayed
    And verify the tax info and total info are available and correct
    And click Finish
    Then Checkout is complete with validation message displayed
 
