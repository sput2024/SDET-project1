Feature: Add Planet and Moon Data
  As a user I want to add new planets and moons to the Planetarium so I can update my findings

  Background:   Starting Actions
    Given       the user is logged in on the home page

  Scenario Outline:  The user can only add planets with valid planet data

    When the user selects the planet option
    And the user provides new valid planet data "<Planetname>"
    And  the user hits submit
    Then the table refreshes "<Planetname>"
    And the user is redirected to the homepage

    Examples:
      |Planetname        |
      |Zeus-12 Aries_5   |
      |90Zeus-12 Aries_5 |
      |a                 |



  Scenario Outline:  The user can not only add planets with invalid planet data
    When the user selects the planet option
    And the user provides invalid planet data "<Planetname>"
    And  the user hits submit
    Then the user should get a browser alert "<alert>"
    And the user is redirected to the homepage

    Examples:
      |Planetname                           |alert              |
      |Cleopatra))!!                        |Invalid planet name|
      |Zeusisthefarthestfromthesun123456    |Invalid planet name|








