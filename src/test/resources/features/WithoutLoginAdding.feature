@parallel
Feature: Adding item to cart without login

@wip
  Scenario:Adding item to cart without login
    Given The user goes to application page
    And The user goes to "Kitap, Müzik, Film, Hobi" "Uzaktan Kumandalı Araçlar"
    And The user selects "Drone Aksesuar"
    And The items is added to cart without login