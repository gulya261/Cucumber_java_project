Feature: Add to cart

  Background: User is Logged In
    Given User is on the Login page
    When User enters username "standard_user"
    When User enters password "secret_sauce"
    When User clicks on login button
    Then User should be redirected to the dashboard

  Scenario: Add to cart
    When User add "Backpack" item to cart
    Then User basket should be displayed with "1" item

  Scenario: Remove from cart
    When User add "Bike light" item to cart
    Then User basket should be displayed with "1" item
    When User remove "Bike light" item from cart
    Then Basket badge is not exist

  Scenario: Filter
    When User chooses "Name (A to Z)" filter
    Then User have new sort page with "Name (A to Z)" filter

