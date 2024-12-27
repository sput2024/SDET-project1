Feature: Delete Planet and Moon Data
  As a user I want to delete planets and moons in the Planetarium so I can correct my findings
  Background:   Starting Actions
    Given       the user is logged in on the home page

  Scenario Outline:  The user can only delete planets with valid planet names

    When the user selects the planet option
    And the user provides planet data for deletion "<Planetname>"
    And the user hits submit to delete
    Then the celestial object is deleted and the table refreshes "<Planetname>"
    And the user is redirected to the homepage

    Examples:
      |Planetname        |
      |Zeus-12 Aries_5   |
      |a                 |
      |Aphrodite85       |


    Scenario Outline:  The user can only delete moons with valid moon names

    When the user selects the moon option
    And the user provides moon data for deletion "<Moonname>"
      And the user hits submit to delete
      Then the celestial object is deleted and the table refreshes "<Moonname>"
      And the user is redirected to the homepage

      Examples:
        |Moonname       |
        |Eureka-3 Fire_2|
        |Hermes-2 Lion-1|



  Scenario Outline:  The user can not delete planets with invalid planet names
    When the user selects the planet option
    And the user provides planet data for deletion "<Planetname>"
    Then the user should get a browser alert "<alert>"
    And  the user is redirected to the homepage

    Examples:
      |Planetname        |alert              |
      |Hercules123       |Invalid planet name|

  Scenario Outline:  The user can not delete moons with invalid moon names
    When the user selects the moon option
    And the user provides moon data for deletion "<Moonname>"
    Then the user should get a browser alert for moon "<alert>"
    And  the user is redirected to the homepage

    Examples:
      |Moonname          |alert            |
      |Hercules123       |Invalid moon name|
