Feature: Going to the home page

  Scenario: clicking the home page button
    Given demo website launched
    And checking the home text
    When clicking the home text button
    And user navigates to "Laptops" category
    And user clicks on the "MacBook air" product
    Then quitting the driver




