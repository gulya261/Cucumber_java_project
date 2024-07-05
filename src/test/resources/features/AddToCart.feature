Feature: Add to cart

Background: User is Logged In
Given user navigates to the Login page
When user is logged in
Then user should be logged in

Scenario: Add to cart
When User navigates to the Product page
Then User click on Add to cart
And User basket should display with added item


  Scenario: Remove from cart
    When User goes to the Product page
    Then User repeat to click on Add to cart
    Then User removes from card
    And User basket should display 0 item

  Scenario: Filter
    When User clicks on filter
    Then User chooses new filter
    And User have new sort page with work of filter
