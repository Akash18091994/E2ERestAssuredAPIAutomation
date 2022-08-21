Feature: APT Enterprise API | APTRPT5762

@APTRegression
Scenario: APTU6537 - Verify download and save multiple proimports through rest call 
Given Execute SQL Query to get JobExecutionID
When BaseURI, Authorisation and Content-Type with APTU6537 body and user calls GET http request with APTU6537resource
Then Execute SQL Query to verify Tot Sys Spec values

