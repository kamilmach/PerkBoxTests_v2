
  @run
  Feature: LogIn
  #Login feature

  Scenario: Login To Application
    Given that I'm on Login Page
    When I enter Email
    And I click continue button
    Then I'm taken to account selection page
