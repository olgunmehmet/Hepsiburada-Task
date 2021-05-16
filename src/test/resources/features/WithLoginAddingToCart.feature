@parallel
Feature: Adding item to cart as user login
  @wip
  Scenario:Adding item to cart as user login
    Given The user goes to application page
    And The user logins to account
    And The user searches for "faber castel"
    And The user selects any row
    And The user selects the same item from two different vendors
    Then The items is added to cart

