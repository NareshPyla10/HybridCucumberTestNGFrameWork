Feature: Verifying and clicking the about button
  Scenario: verifying the about us button
    Given demo website launched
    When verifying the about us button is displayed or not
    When clicking the about us text button
    When clicking the close text button
    Then quitting the driver