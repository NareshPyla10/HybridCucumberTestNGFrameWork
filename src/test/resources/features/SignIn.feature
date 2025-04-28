Feature: verifying signUp and login functionality


  Scenario: verifying existing user functionality in sign up flow
    Given demo website launched
    And user is on home page
    When user tries to signUp existing user "Gilly" and "12345678"
    Then user should see existing user error

  Scenario: verifying user logIn functionality
    Given demo website launched
    And user is on home page
    When user logs into the application with "Gilly" and "12345678"
    Then user should be signedIn successfully

  Scenario: verifying logout button functionality
    Given demo website launched
    And verifying logout button

  Scenario: verifying user sign up flow
    Given demo website launched
    And user is on home page
    When new user tries to signUp
    Then user should be signed up successfully


