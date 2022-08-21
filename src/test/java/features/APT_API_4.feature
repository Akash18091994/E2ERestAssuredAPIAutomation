Feature: APT Enterprise API | August 2020

@APTRegression
Scenario: APTRPT7257 - APTU6627 - Verify updating details of security using Rest Call 
Given BaseURI, Authorisation and Content-Type with APTU6627 body
When User calls with "POST" http request having resource "rest/data-management/security-master/security/AdjustableRateMBS/update"
Then The API call is success with status code "200"
Then Verify correct values added in DB table for "APTU6627"

@APTRegression
Scenario: APTRPT7364 - APTU6628 - Verify adding MC params using rest call with Operation ID 
Given BaseURI, Authorisation and Content-Type with APTU6628 body
When User calls with "PUT" http request having resource "rest/operation/update/299"
Then The API call is success with status code "200"
Then Verify correct values added in DB table for "APTU6628"

@APTRegression
Scenario: APTRPT7364 - APTU6629 - Verify adding MC params using rest call with Operation Name 
Given BaseURI, Authorisation and Content-Type with APTU6629 body
When User calls with "PUT" http request having resource "rest/operation/update/MONTE_CARLO.FAT_TAIL.1.99_00._._"
Then The API call is success with status code "200"
Then Verify correct values added in DB table for "APTU6629"

@APTRegression
Scenario: APTRPT7851 - APTU6653 - Verify Job Status can be determined by JobUploadUUID 
Given BaseURI, Authorisation and Content-Type
When User calls with GET http request having resource with JOBUUID
Then The API call is success with status code "200"

@APTRegression
Scenario: APTRPT7851 - APTU6654 - Verify Job Status can be determined by Valuation Date 
Given BaseURI, Authorisation and Content-Type
When User calls with "GET" http request having resource "rest/job/burndown/date/2015-10-31"
Then The API call is success with status code "200"

@APTRegression
Scenario: APTRPT7991 - APTU6655 - Verify response is created for Jobs To Run endpoint using Valuation Date
Given BaseURI, Authorisation and Content-Type with APTU6655 body
When User calls with "POST" http request having resource "rest/job/jobs-to-run?groupReports=false"
Then The API call is success with status code "200"
Then Verify correct values added in DB table for "APTU6655"

@APTRegression
Scenario: APTRPT7991 - APTU6658 - Verify response is created for Jobs To Run endpoint using Execution Date
Given BaseURI, Authorisation and Content-Type with APTU6658 body
When User calls with "POST" http request having resource "rest/job/jobs-to-run?groupReports=false"
Then The API call is success with status code "200"
Then Verify correct values added in DB table for "APTU6658"

@APTRegression
Scenario: APTRPT7852 - APTU6671 - Verify file is uploaded through rest call
Given BaseURI, Authorisation and Content-Type with APTU6671 body and calls POST http request with APTU6671 resource
Then Get statusUrl from response body

@APTRegression
Scenario: APTRPT7852 - APTU6672 - Verify JobUploadUUID is displayed in response
Given BaseURI, Authorisation and Content-Type
When User calls with "GET" http request having APTU6672 resource
Then The API call is success with status code "200"

@APTRegression
Scenario: APTRPT8007 - APTU6659 - Verify Job Execution is added to Burndown endpoint response
#(This testcase is dependent of APTU6671 , Both testcases APTU6672/APTU6652 should run together)
Given BaseURI, Authorisation and Content-Type
When User calls with "GET" http request having resource "rest/job/burndown/date/2015-11-01"
Then The API call is success with status code "200"


