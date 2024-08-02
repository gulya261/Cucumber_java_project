Feature: Login user

  Scenario: Login user successfully
    Given User is on the Login page
    When User enters username "standard_user"
    When User enters password "secret_sauce"
    When User clicks on login button
    Then User should be redirected to the dashboard