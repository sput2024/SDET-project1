#User Story 2
  @US2 @SR1 @SR3 @UR1 @UR2 @UR3 @UR4 @UR5 @UR6
Feature: User Login
  As a user I want to securely access my account so I can interact with the Planetarium in a secure environment

  Background:   Login Starting Actions
    Given       the user is on the login page

  Scenario Outline: Password characters are not visible
  When      the user provides password "<password>"
  Then      the password will never be visible in plain text

    Examples:
      |username                       |password                         |alert           |
      |Batman	                        |Krypton-was_2000               |Invalid credentials|

 Scenario:  The user can only see the homepage when logged in
  When      the user provides a valid username
  And       the user provides a valid password
  And       the user submits the credentials
  And       then the user has logged out of the secure environment
  Then      the user can't see the homepage

  Scenario Outline: The user can't log in with invalid credentials
    When    the user provides username "<username>"
    And     the user provides password "<password>"
    And     the user submits the credentials
    Then    the user should get a browser alert saying "<alert>"
    And     the user should be redirected to the login page

    Examples:
      |username                       |password                         |alert           |
      |Batman	                        |Krypton-was_2000               |Invalid credentials|
      |Ca12	                            |Iamthenight1939                |Invalid credentials|
