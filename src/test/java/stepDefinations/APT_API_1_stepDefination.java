package stepDefinations;

import static io.restassured.RestAssured.given;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APTAPIBodies;
import resources.Utils;

public class APT_API_1_stepDefination extends Utils{
	RequestSpecification request;
	ResponseSpecification specResponse;
	Response response;
	String securityID;
	
	@Given("BaseURI, Authorisation and Content-Type")
	public void base_uri_authorisation_and_content_type() throws IOException {
		
		request = given().spec(requestSpecification());
	}
	
	@Given("BaseURI, Authorisation and Content-Type with workspace1 body")
	public void base_uri_authorisation_and_content_type_with_workspace1_body() throws IOException {
	    
		request = given().spec(requestSpecification()).body(APTAPIBodies.workspaceEndPoint1());
	}
	
	@Given("BaseURI, Authorisation and Content-Type with workspace2 body")
	public void base_uri_authorisation_and_content_type_with_workspace2_body() throws IOException {
	    
		request = given().spec(requestSpecification()).body(APTAPIBodies.workspaceEndPoint2());
	}
	
	@Given("BaseURI, Authorisation and Content-Type with workspace3 body")
	public void base_uri_authorisation_and_content_type_with_workspace3_body() throws IOException {
	    
		request = given().spec(requestSpecification()).body(APTAPIBodies.workspaceEndPoint3());
	}
	
	@Given("BaseURI, Authorisation and Content-Type with report1 body")
	public void base_uri_authorisation_and_content_type_with_report1_body() throws IOException {
	    
		request = given().spec(requestSpecification()).body(APTAPIBodies.reportEndPoint1());
	}
	
	@Given("BaseURI, Authorisation and Content-Type with report2 body")
	public void base_uri_authorisation_and_content_type_with_report2_body() throws IOException {
	    
		request = given().spec(requestSpecification()).body(APTAPIBodies.reportEndPoint2());
	}
	
	@Given("BaseURI, Authorisation and Content-Type with report3 body")
	public void base_uri_authorisation_and_content_type_with_report3_body() throws IOException {
	    
		request = given().spec(requestSpecification()).body(APTAPIBodies.reportEndPoint3());
	}
	
	@Given("BaseURI, Authorisation and Content-Type with dataextract1 body")
	public void base_uri_authorisation_and_content_type_with_dataextract1_body() throws IOException {
	    
		request = given().spec(requestSpecification()).body(APTAPIBodies.dataExtract1());
	}
	
	@Given("BaseURI, Authorisation and Content-Type with dataextract2 body")
	public void base_uri_authorisation_and_content_type_with_dataextract2_body() throws IOException {
	    
		request = given().spec(requestSpecification()).body(APTAPIBodies.dataExtract2());
	}
	
	@Given("BaseURI, Authorisation and Content-Type with dataextract3 body")
	public void base_uri_authorisation_and_content_type_with_dataextract3_body() throws IOException {
	    
		request = given().spec(requestSpecification()).body(APTAPIBodies.dataExtract3());
	}
	
	@Given("BaseURI, Authorisation and Content-Type with APTU6628 body")
	public void base_uri_authorisation_and_content_type_with_APTU6628_body() throws IOException {
	    
		request = given().spec(requestSpecification()).body(APTAPIBodies.APTU6628());
	}
	
	@Given("BaseURI, Authorisation and Content-Type with APTU6629 body")
	public void base_uri_authorisation_and_content_type_with_APTU6629_body() throws IOException {
	    
		request = given().spec(requestSpecification()).body(APTAPIBodies.APTU6629());
	}
	
	@Given("BaseURI, Authorisation and Content-Type with APTU6627 body")
	public void base_uri_authorisation_and_content_type_with_APTU6627_body() throws IOException, SQLException {
		
        String dbURL = "jdbc:mysql://vlmazdeventapp3.fisdev.local:3306/Prd";
		
		String user = "ent_dba";
		
		String password = "ent_dbaPassw0rd";
		
		Connection con = DriverManager.getConnection(dbURL, user, password);
		
		Statement s = con.createStatement();
		
        ResultSet rs = null;
        
        rs = s.executeQuery("select s.SecurityID from Prd.Security s where s.Name = 'Adjustable Rate MBS 1';");
		 
		rs.next();
		
		String secID = rs.getString("SecurityID");
	    
		request = given().spec(requestSpecification()).body(APTAPIBodies.APTU6627(secID));
	}
	
	@When("User calls with {string} http request having resource {string}")
	public void user_calls_with_http_request_having_resource(String httpRequest, String resource) {
		
		specResponse = new ResponseSpecBuilder().build();
		
		if(httpRequest.equalsIgnoreCase("GET"))
		{
		response = request.when()
                .get(resource).then()
                .spec(specResponse)
                .extract().response();
		}
		
		if(httpRequest.equalsIgnoreCase("PUT"))
		{
			
			response = request.when()
	                .put(resource).then()
	                .spec(specResponse)
	                .extract().response();	
		}
		
		if(httpRequest.equalsIgnoreCase("POST"))
		{
		response = request.when()
                .post(resource).then()
                .spec(specResponse)
                .extract().response();
		}
               
	}
	
	@When("User calls with GET http request having resource with JOBUUID")
	public void User_calls_with_GET_http_request_having_resource_with_JOBUUID() throws SQLException {
		
		specResponse = new ResponseSpecBuilder().build();
		
        String dbURL = "jdbc:mysql://vlmazdeventapp3.fisdev.local:3306/Prd";
		
		String user = "ent_dba";
		
		String password = "ent_dbaPassw0rd";
		
		Connection con = DriverManager.getConnection(dbURL, user, password);
		
		Statement s = con.createStatement();
		
        ResultSet rs = null;
        
        rs = s.executeQuery("Select * from Prd.JobUpload  where JobFailedCount='6'");
		 
		rs.next();
		
		String jobUUID = rs.getString("JobUploadUUID");
		
		String resourceWithJobUUID = "/rest/job/status/" + jobUUID;
		
		response = request.when()
                .get(resourceWithJobUUID).then()
                .spec(specResponse)
                .extract().response();
               
	}
	
	@When("User calls with {string} http request having APTU6672 resource")
	public void user_calls_with_http_request_having_aptu6672_resource(String string) {
		
		specResponse = new ResponseSpecBuilder().build();
		
		String resourceAPTU6672 = "/rest/upload/data-status/" + APT_API_3_stepDefination.statusUrlAPTU6671;
		
		response = request.when()
                .get(resourceAPTU6672).then()
                .spec(specResponse)
                .extract().response();		
	}
	
	@Then("The API call is success with status code {string}")
	public void the_api_call_is_success_with_status_code(String stringStatusCode) {
		
		int expectedStatusCode = Integer.parseInt(stringStatusCode);
		
		assertEquals(expectedStatusCode,response.getStatusCode());
	}
	
	@Given("Execute {string} SQL Query to get SecurityID")
	public String execute_sql_query_to_get_security_id(String UIKey) throws SQLException {
		
        String dbURL = "jdbc:mysql://vlmazdeventapp3.fisdev.local:3306/Prd";
		
		String user = "ent_dba";
		
		String password = "ent_dbaPassw0rd";
		
		Connection con = DriverManager.getConnection(dbURL, user, password);
		
		Statement s = con.createStatement();
		
		ResultSet r = null;
		
		if(UIKey.equalsIgnoreCase("OptionAssetType"))
		{
		 r = s.executeQuery("Select\r\n"
				+ "Prd.Security.SecurityID,Prd.Security.Name,Prd.SecurityKey.SecurityCode\r\n"
				+ "From Prd.Security\r\n"
				+ "Join Prd.SecurityKey\r\n"
				+ "On Prd.Security.SecurityKey=Prd.SecurityKey.SecurityKey\r\n"
				+ "where Prd.SecurityKey.SecurityCode = 'UI:9164378';");
		}
		
		if(UIKey.equalsIgnoreCase("StructuredBondAssetType"))
		{
			
		 r = s.executeQuery("Select\r\n"
				+ "Prd.Security.SecurityID,Prd.Security.Name,Prd.SecurityKey.SecurityCode\r\n"
				+ "From Prd.Security\r\n"
				+ "Join Prd.SecurityKey\r\n"
				+ "On Prd.Security.SecurityKey=Prd.SecurityKey.SecurityKey\r\n"
				+ "where Prd.SecurityKey.SecurityCode = 'UI:4264174';");
		
		}
		
		if(UIKey.equalsIgnoreCase("SwaptionAssetType"))
		{
			
		 r = s.executeQuery("Select\r\n"
		 		+ "Prd.Security.SecurityID,Prd.Security.Name,Prd.SecurityKey.SecurityCode\r\n"
		 		+ "From Prd.Security\r\n"
		 		+ "Join Prd.SecurityKey\r\n"
		 		+ "On Prd.Security.SecurityKey=Prd.SecurityKey.SecurityKey\r\n"
		 		+ "where Prd.SecurityKey.SecurityCode = 'UI:15589858';");
		
		}
		
		if(UIKey.equalsIgnoreCase("CurrencySwapAssetType"))
		{
			
		 r = s.executeQuery("Select\r\n"
		 		+ "Prd.Security.SecurityID,Prd.Security.Name,Prd.SecurityKey.SecurityCode\r\n"
		 		+ "From Prd.Security\r\n"
		 		+ "Join Prd.SecurityKey\r\n"
		 		+ "On Prd.Security.SecurityKey=Prd.SecurityKey.SecurityKey\r\n"
		 		+ "where Prd.SecurityKey.SecurityCode = 'UI:3164974';");
		
		}
		
		if(UIKey.equalsIgnoreCase("StructuredAssetTypeBondAssetClass"))
		{
			
		 r = s.executeQuery("Select\r\n"
		 		+ "Prd.Security.SecurityID,Prd.Security.Name,Prd.SecurityKey.SecurityCode\r\n"
		 		+ "From Prd.Security\r\n"
		 		+ "Join Prd.SecurityKey\r\n"
		 		+ "On Prd.Security.SecurityKey=Prd.SecurityKey.SecurityKey\r\n"
		 		+ "where Prd.SecurityKey.SecurityCode = 'UI:3456789';");
		
		}
		
		if(UIKey.equalsIgnoreCase("COCOAssetType"))
		{
			
		 r = s.executeQuery("Select\r\n"
		 		+ "Prd.Security.SecurityID,Prd.Security.Name,Prd.SecurityKey.SecurityCode\r\n"
		 		+ "From Prd.Security\r\n"
		 		+ "Join Prd.SecurityKey\r\n"
		 		+ "On Prd.Security.SecurityKey=Prd.SecurityKey.SecurityKey\r\n"
		 		+ "where Prd.SecurityKey.SecurityCode = 'coco_dyc_5';");
		
		}
		
		r.next();
		
		securityID =  r.getString("SecurityID");
		
		return securityID;
	}
	
	@Given("BaseURI, Authorisation and Content-Type with OptionAssetType body")
	public void base_uri_authorisation_and_content_type_with_Option_asset_type_body() throws IOException {
	    
		request = given().spec(requestSpecification()).body(APTAPIBodies.optionAssetType(securityID));
	}
	
	@Given("BaseURI, Authorisation and Content-Type with StructuredBondAssetType body")
	public void base_uri_authorisation_and_content_type_with_Structured_Bond_Asset_Type_body() throws IOException {
	    
		request = given().spec(requestSpecification()).body(APTAPIBodies.StructuredBondAssetType(securityID));
	}
	
	@Given("BaseURI, Authorisation and Content-Type with SwaptionAssetType body")
	public void base_uri_authorisation_and_content_type_with_Swaption_Asset_Type_body() throws IOException {
	    
		request = given().spec(requestSpecification()).body(APTAPIBodies.swaptionAssetType(securityID));
	}
	
	@Given("BaseURI, Authorisation and Content-Type with CurrencySwapAssetType body")
	public void base_uri_authorisation_and_content_type_with_Currency_Swap_Asset_Type_body() throws IOException {
	    
		request = given().spec(requestSpecification()).body(APTAPIBodies.CurrencySwapAssetType(securityID));
	}
	
	@Given("BaseURI, Authorisation and Content-Type with StructuredAssetTypeBondAssetClass body")
	public void base_uri_authorisation_and_content_type_with_Structured_Asset_Type_Bond_Asset_Class_body() throws IOException {
	    
		request = given().spec(requestSpecification()).body(APTAPIBodies.StructuredAssetTypeBondAssetClass(securityID));
	}
	
	@Given("BaseURI, Authorisation and Content-Type with COCOAssetType body")
	public void base_uri_authorisation_and_content_type_with_COCO_Asset_Type_body() throws IOException {
	    
		request = given().spec(requestSpecification()).body(APTAPIBodies.COCOAssetType(securityID));
	}
	
	@Given("BaseURI, Authorisation and Content-Type with APTU6655 body")
	public void BaseURI_Authorisation_and_Content_Type_with_APTU6655_body() throws IOException, SQLException {
	    
		request = given().spec(requestSpecification()).body(APTAPIBodies.APTU6655());
	}
	
	@Given("BaseURI, Authorisation and Content-Type with APTU6658 body")
	public void BaseURI_Authorisation_and_Content_Type_with_APTU6658_body() throws IOException, SQLException {
	    
		request = given().spec(requestSpecification()).body(APTAPIBodies.APTU6658());
	}
	
	@Then("SecurityID in response body and in {string} SQL Query database should be same")
	public void security_id_in_response_body_and_in_sql_query_database_should_be_same(String UIKey) throws SQLException {
	    //steps to get response code securityID
		String responseSecurityID = getJsonPath(response,"securityId");
		
		//steps to get database securityID
        String dbURL = "jdbc:mysql://vlmazdeventapp3.fisdev.local:3306/Prd";
		
		String user = "ent_dba";
		
		String password = "ent_dbaPassw0rd";
		
		Connection con = DriverManager.getConnection(dbURL, user, password);
		
		Statement s = con.createStatement();
		
        ResultSet rs = null;
		
		if(UIKey.equalsIgnoreCase("OptionAssetType"))
		{
			
		 rs = s.executeQuery("Select\r\n"
				+ "Prd.Security.SecurityID,Prd.Security.Name,Prd.SecurityKey.SecurityCode\r\n"
				+ "From Prd.Security\r\n"
				+ "Join Prd.SecurityKey\r\n"
				+ "On Prd.Security.SecurityKey=Prd.SecurityKey.SecurityKey\r\n"
				+ "where Prd.SecurityKey.SecurityCode = 'UI:9164378';");
		
		}
		
		if(UIKey.equalsIgnoreCase("StructuredBondAssetType"))
		{
			
		 rs = s.executeQuery("Select\r\n"
				+ "Prd.Security.SecurityID,Prd.Security.Name,Prd.SecurityKey.SecurityCode\r\n"
				+ "From Prd.Security\r\n"
				+ "Join Prd.SecurityKey\r\n"
				+ "On Prd.Security.SecurityKey=Prd.SecurityKey.SecurityKey\r\n"
				+ "where Prd.SecurityKey.SecurityCode = 'UI:4264174';");
		
		}
		
		if(UIKey.equalsIgnoreCase("SwaptionAssetType"))
		{
			
		 rs = s.executeQuery("Select\r\n"
		 		+ "Prd.Security.SecurityID,Prd.Security.Name,Prd.SecurityKey.SecurityCode\r\n"
		 		+ "From Prd.Security\r\n"
		 		+ "Join Prd.SecurityKey\r\n"
		 		+ "On Prd.Security.SecurityKey=Prd.SecurityKey.SecurityKey\r\n"
		 		+ "where Prd.SecurityKey.SecurityCode = 'UI:15589858';");
		
		}
		
		if(UIKey.equalsIgnoreCase("CurrencySwapAssetType"))
		{
			
		 rs = s.executeQuery("Select\r\n"
		 		+ "Prd.Security.SecurityID,Prd.Security.Name,Prd.SecurityKey.SecurityCode\r\n"
		 		+ "From Prd.Security\r\n"
		 		+ "Join Prd.SecurityKey\r\n"
		 		+ "On Prd.Security.SecurityKey=Prd.SecurityKey.SecurityKey\r\n"
		 		+ "where Prd.SecurityKey.SecurityCode = 'UI:3164974';");
		
		}
		
		if(UIKey.equalsIgnoreCase("StructuredAssetTypeBondAssetClass"))
		{
			
		 rs = s.executeQuery("Select\r\n"
		 		+ "Prd.Security.SecurityID,Prd.Security.Name,Prd.SecurityKey.SecurityCode\r\n"
		 		+ "From Prd.Security\r\n"
		 		+ "Join Prd.SecurityKey\r\n"
		 		+ "On Prd.Security.SecurityKey=Prd.SecurityKey.SecurityKey\r\n"
		 		+ "where Prd.SecurityKey.SecurityCode = 'UI:3456789';");
		
		}
		
		if(UIKey.equalsIgnoreCase("COCOAssetType"))
		{
			
		 rs = s.executeQuery("Select\r\n"
		 		+ "Prd.Security.SecurityID,Prd.Security.Name,Prd.SecurityKey.SecurityCode\r\n"
		 		+ "From Prd.Security\r\n"
		 		+ "Join Prd.SecurityKey\r\n"
		 		+ "On Prd.Security.SecurityKey=Prd.SecurityKey.SecurityKey\r\n"
		 		+ "where Prd.SecurityKey.SecurityCode = 'coco_dyc_5';");
		
		}
		
		rs.next();
		
		String databaseSecurityID =  rs.getString("SecurityID");
		
		assertEquals(responseSecurityID,databaseSecurityID);
	}
	
	@Then("Verify correct values added in DB table for {string}")
	public void verify_correct_values_added_in_db_table_for(String testcaseNumber) throws SQLException {
	    
        String dbURL = "jdbc:mysql://vlmazdeventapp3.fisdev.local:3306/Prd";
		
		String user = "ent_dba";
		
		String password = "ent_dbaPassw0rd";
		
		Connection con = DriverManager.getConnection(dbURL, user, password);
		
		Statement s = con.createStatement();
		
        ResultSet rs = null;
		
		if(testcaseNumber.equalsIgnoreCase("APTU6628"))
		{
			
		 rs = s.executeQuery("Select * from Prd.Operation where TenantID=4 and Name = 'MONTE_CARLO.FAT_TAIL.1.95_00._._';");
		 
		 rs.next();
		 
		 String ExpectedMCAlpha = "0.1";
	     String ActualMCAlpha =  rs.getString("MCAlpha");
	     assertEquals(ExpectedMCAlpha,ActualMCAlpha);
	     
	     String ExpectedMCBeta = "0.2";
	     String ActualMCBeta =  rs.getString("MCBeta");
	     assertEquals(ExpectedMCBeta,ActualMCBeta);
	     
	     String ExpectedMCGamma = "0.3";
	     String ActualMCGamma =  rs.getString("MCGamma");
	     assertEquals(ExpectedMCGamma,ActualMCGamma);
	     
	     String ExpectedMCDelta = "0.4";
	     String ActualMCDelta =  rs.getString("MCDelta");
	     assertEquals(ExpectedMCDelta,ActualMCDelta);
	     
	     String ExpectedMCTailThreshold = "0.5";
	     String ActualMCTailThreshold =  rs.getString("MCTailThreshold");
	     assertEquals(ExpectedMCTailThreshold,ActualMCTailThreshold);
	     
	     String ExpectedMCSigma = "0.6";
	     String ActualMCSigma =  rs.getString("MCSigma");
	     assertEquals(ExpectedMCSigma,ActualMCSigma);
	     
	     String ExpectedMCK = "0.8";
	     String ActualMCK =  rs.getString("MCK");
	     assertEquals(ExpectedMCK,ActualMCK);
		
	     con.close();
		}
		
		if(testcaseNumber.equalsIgnoreCase("APTU6629"))
		{
			
		 rs = s.executeQuery("Select * from Prd.Operation where TenantID=4 and Name = 'MONTE_CARLO.FAT_TAIL.1.99_00._._';");
		 
		 rs.next();
		 
		 String ExpectedMCAlpha = "0.2";
	     String ActualMCAlpha =  rs.getString("MCAlpha");
	     assertEquals(ExpectedMCAlpha,ActualMCAlpha);
	     
	     String ExpectedMCBeta = "0.4";
	     String ActualMCBeta =  rs.getString("MCBeta");
	     assertEquals(ExpectedMCBeta,ActualMCBeta);
	     
	     String ExpectedMCGamma = "0.6";
	     String ActualMCGamma =  rs.getString("MCGamma");
	     assertEquals(ExpectedMCGamma,ActualMCGamma);
	     
	     String ExpectedMCDelta = "0.8";
	     String ActualMCDelta =  rs.getString("MCDelta");
	     assertEquals(ExpectedMCDelta,ActualMCDelta);
	     
	     String ExpectedMCTailThreshold = "0.1";
	     String ActualMCTailThreshold =  rs.getString("MCTailThreshold");
	     assertEquals(ExpectedMCTailThreshold,ActualMCTailThreshold);
	     
	     String ExpectedMCSigma = "0.3";
	     String ActualMCSigma =  rs.getString("MCSigma");
	     assertEquals(ExpectedMCSigma,ActualMCSigma);
	     
	     String ExpectedMCK = "0.5";
	     String ActualMCK =  rs.getString("MCK");
	     assertEquals(ExpectedMCK,ActualMCK);
		
	     con.close();
		}
		
		if(testcaseNumber.equalsIgnoreCase("APTU6627"))
		{
			
		 rs = s.executeQuery("select s.Name, s.AuditComment from Prd.Security s where s.Name = 'Adjustable Rate MBS 1';");
		 
		 rs.next();
		 
		 String ExpectedName = "Adjustable Rate MBS 1";
	     String ActualName =  rs.getString("Name");
	     assertEquals(ExpectedName,ActualName);
	     
	     String ExpectedComment = "This is test comment";
	     String ActualComment =  rs.getString("AuditComment");
	     assertEquals(ExpectedComment,ActualComment);
		
	     con.close();
		}
		
		if(testcaseNumber.equalsIgnoreCase("APTU6655"))
		{
			
		 String jobUUID = response.asString();
		 
		 rs = s.executeQuery("Select JobStatus,JobCount,JobCompletedCount,CreatedBy from Prd.JobUpload where JobUploadUUID='"+jobUUID+"';");
		 
		 rs.next();
	     
	     String ExpectedCreatedBy = "AKASH.TEST";
	     String ActualCreatedBy =  rs.getString("CreatedBy");
	     assertEquals(ExpectedCreatedBy,ActualCreatedBy);
	     
	     String ExpectedJobCount = "1";
	     String ActualJobCount =  rs.getString("JobCount");
	     assertEquals(ExpectedJobCount,ActualJobCount);  
		
	     con.close();
		}
		
		if(testcaseNumber.equalsIgnoreCase("APTU6658"))
		{
			
		 String jobUUID = response.asString();
		 
		 rs = s.executeQuery("Select JobStatus,JobCount,JobCompletedCount,CreatedBy from Prd.JobUpload where JobUploadUUID='"+jobUUID+"';");
		 
		 rs.next();
	     
	     String ExpectedCreatedBy = "AKASH.TEST";
	     String ActualCreatedBy =  rs.getString("CreatedBy");
	     assertEquals(ExpectedCreatedBy,ActualCreatedBy);
	     
	     String ExpectedJobCount = "1";
	     String ActualJobCount =  rs.getString("JobCount");
	     assertEquals(ExpectedJobCount,ActualJobCount);  
		
	     con.close();
		}
		
	}
		
	
	
}
