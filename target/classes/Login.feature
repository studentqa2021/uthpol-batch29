@SmokeTest
Feature: Login function test

@TC_002
Scenario: as a luma app user must able to successfully login the application with valid credintial
Given open any browser
And go to app url
And click signin button
When enter valid email
And enter valid passward
And click submit buttion
Then Validate login was successful