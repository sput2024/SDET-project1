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
      |Aphrodite85       |

    Scenario Outline:  The user can only add moons with valid moon data
      When the user selects the moon option
      And the user provides a moonname "<Moonname>"
      And the user provides a planet id "<PlanetId>"
      And the user hits submit
      Then the table updates moonname "<Moonname>"
      And  the user is redirected to the homepage

      Examples:
        |Moonname                 |PlanetId|
        |Eureka-3 Fire_2          | 1      |
        |90Champion               | 2      |
        |Hermes-2 Lion-1          | 3      |


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

  Scenario Outline:  The user can not add moons with invalid moon name
    When the user selects the moon option
    And the user provides a moonname "<Moonname>"
    And the user provides a planet id "<PlanetId>"
    And the user hits submit
    Then the user should get a browser alert for moon "<alert>"
    And  the user is redirected to the homepage

    Examples:
      |Moonname                           |PlanetId      |alert            |
      |SulfurCarbonHydrogenMonoxide1990   | 2            |Invalid moon name|
      |Eureka-3 Fire_2                    | 2            |Invalid moon name|
      |                                   | 2            |Invalid moon name|
      |Krypton)))!!                       | 1            |Invalid moon name|

  Scenario Outline:  The user can not add moons with invalid planet id
    When the user selects the moon option
    And the user provides a moonname "<Moonname>"
    And the user provides a planet id "<PlanetId>"
    And the user hits submit
    Then the user should get a browser alert "<alert>"
    And  the user is redirected to the homepage

    Examples:
      |Moonname                           |PlanetId      |alert            |
      |Kryptonite3                        |300           |Invalid planet id|
