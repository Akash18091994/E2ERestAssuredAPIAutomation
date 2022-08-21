Feature: APT Enterprise API | APTRPT8944

@APTRegression @APTSmoke
Scenario: APTU6632 - Verify APT Enterprise version number
Given BaseURI, Authorisation and Content-Type
When User calls with "GET" http request having resource "rest/version"
Then The API call is success with status code "200"
#And version number in response body is "2021.3.4"

@APTRegression
Scenario: APTU6822 - Verify workspace end point with status code 200
Given BaseURI, Authorisation and Content-Type with workspace1 body
When User calls with "PUT" http request having resource "rest/report/export/workspace/parameterized"
Then The API call is success with status code "200"

@APTRegression
Scenario: APTU6818 - Verify workspace end point with status code 204
Given BaseURI, Authorisation and Content-Type with workspace3 body
When User calls with "PUT" http request having resource "rest/report/export/workspace/parameterized"
Then The API call is success with status code "204"

@APTRegression
Scenario: APTU6821 - Verify data extract end point with status code 204
Given BaseURI, Authorisation and Content-Type with dataextract1 body
When User calls with "PUT" http request having resource "rest/report/export/dataextracts/parameterized"
Then The API call is success with status code "204"

@APTRegression
Scenario: APTU6887 - Verify data extract end point with status code 200
Given BaseURI, Authorisation and Content-Type with dataextract3 body
When User calls with "PUT" http request having resource "rest/report/export/dataextracts/parameterized"
Then The API call is success with status code "200"

@APTRegression
Scenario: APTU6820 - Verify workspace end point with status code 400
Given BaseURI, Authorisation and Content-Type with workspace2 body
When User calls with "PUT" http request having resource "rest/report/export/workspace/parameterized"
Then The API call is success with status code "400"

@APTRegression
Scenario: APTU6819 - Verify data extract end point with status code 400
Given BaseURI, Authorisation and Content-Type with dataextract2 body
When User calls with "PUT" http request having resource "rest/report/export/dataextracts/parameterized"
Then The API call is success with status code "400"

@APTRegression
Scenario: APTU6816 - Verify report end point with status code 400
Given BaseURI, Authorisation and Content-Type with report1 body
When User calls with "PUT" http request having resource "rest/report/export/download/parameterized"
Then The API call is success with status code "400"

@APTRegression
Scenario: APTU6817 - Verify report end point with status code 200
Given BaseURI, Authorisation and Content-Type with report2 body
When User calls with "PUT" http request having resource "rest/report/export/download/parameterized"
Then The API call is success with status code "200"

@APTRegression
Scenario: APTU6888 - Verify report end point with status code 204
Given BaseURI, Authorisation and Content-Type with report3 body
When User calls with "PUT" http request having resource "rest/report/export/download/parameterized"
Then The API call is success with status code "204"
