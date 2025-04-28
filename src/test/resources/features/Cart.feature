Feature: verifying cart functionalities

  Scenario: verifying cart functionality without any item click purchase button
    Given demo website launched
    When verifying cart button functionality
    Then placing an order with clicking purchase button


  Scenario: verifying cart functionality without any item click close button
    Given demo website launched
    When verifying cart button functionality
    Then placing an order with clicking close button
    And quitting the driver

  Scenario: passing user details through the data tables
    Given demo website launched
    When verifying cart button functionality
    Then clicking the place order button
    And user details passing through data table
      | Name   | Country | City   | CreditCard | Month | Year |
      | Leo   | Portugal |  Maderia  | 9876 7654 4321 1098 | 10 | 2016 |
    And quitting the driver

  Scenario: adding element to the cart
    Given demo website launched
    When clicking the home text button
    Then selecting the required category "Phones"
    Then selecting the required product "Samsung galaxy s6"
    And user details passing through data table
      | Name   | Country | City   | CreditCard | Month | Year |
      | Leo   | Portugal |  Maderia  | 9876 7654 4321 1098 | 10 | 2016 |

