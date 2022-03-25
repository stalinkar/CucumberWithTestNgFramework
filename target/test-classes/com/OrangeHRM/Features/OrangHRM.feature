Feature: Create 4 scenarios and tag them with smoke and Regression, and run with cucumber
 
Background: Initialize the browser
Given the user opens the browser
Then the user navigates the URL
 
 @SmokeTest@RegressionalTest
Scenario: Admin Menu Navigation
Given I am in OrangeHRP Application 
Then Login to Application 
When Dashboard page is available 
And click on Admin menu
Then close the browser

 @RegressionalTest
Scenario: Job text validation 
Given I am in OrangeHRP Application
Then Login to Application 
Then click on Admin menu
Then Click on Job 
And validate text – Job Title
Then close the browser

@RegressionalTest
Scenario: My Info Navigation
Given I am in OrangeHRP Application 
Then Login to Application 
When Dashboard page is available 
And click on My Info menu
Then validate My Info is loaded
Then close the browser

@SmokeTest
Scenario: Time Menu Navigation
Given I am in OrangeHRP Application 
Then Login to Application 
When Dashboard page is available 
And click on Time Link
Then validate Time Page is loaded
Then close the browser
