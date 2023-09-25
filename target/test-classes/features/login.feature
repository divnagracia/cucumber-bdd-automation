Feature: Login

@Login
  Scenario: Login into the application with valid credentials
  	Given I am on the Login page
    When I enter username "standard_user"
    And I enter password "secret_sauce"
    And click on Login button
    Then I am successfully logged in
  
