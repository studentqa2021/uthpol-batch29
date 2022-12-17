@finalTestRun

Feature: Login function test final

Scenario:  user must able to successfully login the application with valid credintial

Given open browser
And go to url page
And click signin
When put valid email
And put valid pass
And click submit
Then validate login


