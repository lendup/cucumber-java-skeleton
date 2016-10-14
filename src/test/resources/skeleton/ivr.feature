@IvrTest
Feature: IVR Test

  Scenario: Recent card transactions playback
    Given A user is authenticated through IVR
    And He is in the main menu
    When number 3 is pressed
    Then the user should hear the list of recent transactions
