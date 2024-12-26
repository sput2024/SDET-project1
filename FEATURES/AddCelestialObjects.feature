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

    Scenario Outline:  The user can only add moons with valid moon data
    When the user provides new valid moonname "<Moonname>"
      And the user provides new valid Planet ID "<PlanetId>"
      And the user hits submit
    Then the table refreshes "<Moonname>"
    And  the user is redirected to the homepage

      Examples:
        |Moonname                 |PlanetId|
        |Eureka-3 Fire_2          | 1
        |90Champion               | 2



  Scenario Outline:  The user can not add planets with invalid planet data
    When the user selects the planet option
    And the user provides invalid planet data "<Planetname>"
    And  the user hits submit
    Then the user should get a browser alert "<alert>"
    And the user is redirected to the homepage

    Examples:
      |Planetname                           |alert              |
      |Cleopatra))!!                        |Invalid planet name|
      |Zeusisthefarthestfromthesun123456    |Invalid planet name|
      |                                     |Invalid planet name|
      |Earth                                |Invalid planet name|

  Scenario Outline:  The user can not add moons with invalid moon data
    When the user provides new valid moonname "<Moonname>"
    And the user provides new valid Planet ID "<PlanetId>"
    And the user hits submit
    Then the table refreshes "<Moonname>"
    And  the user is redirected to the homepage

    Examples:
      |Moonname                           |PlanetId|     |alert |
      |Eureka-3 Fire_2                    | 1            |Invalid moon name|
      |SulfurCarbonHydrogenMonoxide1990   | 2            |Invalid moon name|
      |                                   | 1            |Invalid moon name|
      |Kryptonite3                        |300           |Invalid planet ID|









