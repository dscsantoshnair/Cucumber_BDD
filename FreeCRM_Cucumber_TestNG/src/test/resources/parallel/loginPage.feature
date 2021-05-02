@Login
Feature: Login Page Feature

@Smoke
Scenario: Login Page Title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Store"

@Smoke
Scenario: Forgot Password Link
Given user is on login page
Then forgot password link should be displayed

@Regression @Skip
Scenario: Login with correct credentials
Given user is on login page
When user enters username 'santoshn50@gmail.com'
And user enters password 'Welcome@2020'
And user clicks on login button
Then user gets the title of the page
And page title should be "My account - My Store"