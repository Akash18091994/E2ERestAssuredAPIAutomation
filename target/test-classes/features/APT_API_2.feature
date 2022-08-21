Feature: APT Enterprise API | APTRPT5897

@APTRegression
Scenario: APTU6191 - Verify editing Primary Details for Option asset type
Given Execute "OptionAssetType" SQL Query to get SecurityID
Given BaseURI, Authorisation and Content-Type with OptionAssetType body
When User calls with "POST" http request having resource "rest/data-management/security-master/security/Option/update"
Then The API call is success with status code "200"
Then Execute "OptionAssetType" SQL Query to get SecurityID
Then SecurityID in response body and in "OptionAssetType" SQL Query database should be same

@APTRegression
Scenario: APTU6190 - Verify editing Primary Details for Structured Bond Asset Type
Given Execute "StructuredBondAssetType" SQL Query to get SecurityID
Given BaseURI, Authorisation and Content-Type with StructuredBondAssetType body
When User calls with "POST" http request having resource "rest/data-management/security-master/security/Structured/update"
Then The API call is success with status code "200"
Then Execute "StructuredBondAssetType" SQL Query to get SecurityID
Then SecurityID in response body and in "StructuredBondAssetType" SQL Query database should be same

@APTRegression
Scenario: APTU6192 - Verify editing Primary Details for Swaption Asset Type
Given Execute "SwaptionAssetType" SQL Query to get SecurityID
Given BaseURI, Authorisation and Content-Type with SwaptionAssetType body
When User calls with "POST" http request having resource "rest/data-management/security-master/security/Swaption/update"
Then The API call is success with status code "200"
Then Execute "SwaptionAssetType" SQL Query to get SecurityID
Then SecurityID in response body and in "SwaptionAssetType" SQL Query database should be same

@APTRegression
Scenario: APTU6193 - Verify editing Primary Details for Currency Swap asset type
Given Execute "CurrencySwapAssetType" SQL Query to get SecurityID
Given BaseURI, Authorisation and Content-Type with CurrencySwapAssetType body
When User calls with "POST" http request having resource "rest/data-management/security-master/security/CurrencySwap/update"
Then The API call is success with status code "200"
Then Execute "CurrencySwapAssetType" SQL Query to get SecurityID
Then SecurityID in response body and in "CurrencySwapAssetType" SQL Query database should be same

@APTRegression
Scenario: APTU6195 - Verify editing Primary Details for Structured asset type Bond Asset Class
Given Execute "StructuredAssetTypeBondAssetClass" SQL Query to get SecurityID
Given BaseURI, Authorisation and Content-Type with StructuredAssetTypeBondAssetClass body
When User calls with "POST" http request having resource "rest/data-management/security-master/security/Structured/update"
Then The API call is success with status code "200"
Then Execute "StructuredAssetTypeBondAssetClass" SQL Query to get SecurityID
Then SecurityID in response body and in "StructuredAssetTypeBondAssetClass" SQL Query database should be same

@APTRegression
Scenario: APTU6194 - Verify editing Primary Details for COCO asset type
Given Execute "COCOAssetType" SQL Query to get SecurityID
Given BaseURI, Authorisation and Content-Type with COCOAssetType body
When User calls with "POST" http request having resource "rest/data-management/security-master/security/ContingentConvertibleBond/update"
Then The API call is success with status code "200"
Then Execute "COCOAssetType" SQL Query to get SecurityID
Then SecurityID in response body and in "COCOAssetType" SQL Query database should be same
