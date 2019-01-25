
@run
Feature: LogIn
  #Login feature

  Scenario: Enter Invalid Email on Login page
    Given that I'm on Login Page
    When I enter invalid Email
    And I click continue button
    Then Error message : "This email address is not valid" is shown
