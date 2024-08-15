# new feature
# Tags: optional

Feature: Checkout

    Background: User is Logged In
        Given User is on the Login page
        When User enters username "standard_user"
        When User enters password "secret_sauce"
        When User clicks on login button
        Then User should be redirected to the dashboard
        When User add "Backpack" item to cart
        Then User basket should be displayed with "1" item

    Scenario: Checkout
        When User click on Cart Button
        Then User is on Cart Page
        When User goes to Checkout Page
        And User fills checkout form with "test" first name "last" last name "4256" zip code
        Then User is on Checkout Overview Page

