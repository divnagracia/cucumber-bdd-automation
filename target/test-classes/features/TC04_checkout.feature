Feature: Checkout

  @CheckOut
  Scenario Outline: Populate all fields in Checkout Information
    
    Given

    When I enter firstName <firstname>
    And enter lastName <lastname>
    And enter postalCode <postalcode>
    And click Continue
    Then redirected to Checkout Review page

    Examples: 
      | firstname | lastname | postalcode |
      | Divina    | Bucog    |       1550 |

  Scenario: Checkout items
    Given that I am in Checkout Overview page
    When I verify the item name, item description and item price are equal from the Cart Page
    And verify item total is correct
    And verify the tax info and total info are available
    And click Finish
    Then Checkout is complete
    And successful validation message is displayed
