Feature: Coding challenge scenario

  Scenario: login test
    Given 777Games app is installed
    When an unregistered user launches the app
    Then he should see the splash screen (animation) for 3 seconds
    And he should see the signup screen with a slider
    Given user is on the signup/login screen
    When user right swipes on the image
    Then he should see the next image
    And when he left swipes on the new image
    Then he should see the previous image
    Given user is on the signup/login screen
    When user clicks on Signup button
    Then he should be on the Signup form screen
    Given user is on the Signup page
    When user enters '0000001234' as the Mobile number in 'signup' page
    And clicks on Referral code input form
    Then he should see an error message that the number already exists
    Given user is on the Signup page
    When user clicks on the 'Log in' button in the top right of thescreen
    Then he should navigate to the login form screen
    Given user is on the login page
    When user enters '0000001234' as the Mobile number in 'login' page
    And user clicks on the login button
    Then he should navigate to verify OTP page
    Given user is on the Verify OTP page
    When user enters '123456' as the OTP
    Then user should see an incorrect OTP error message
    Given user is on the Verify OTP page
    When user enters '166549' as the OTP
    Then the app should crash
		
		
