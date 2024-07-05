Feature: Login user

  Scenario: Login user successfully
    Given user navigates to the Login page
    When user is logged in
    Then user should be logged in
    Then browser is closed