@LdcTest
Feature: LDC Test

  Scenario: User goes to ldc not logged in
    Given user is not logged in
    When they go to ldc
    Then they should see sign-in

  Scenario: User goes to ldc logged in
    Given user is logged in
    When they go to ldc
    Then they should see their dashboard