package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

public class APT_API_3_stepDefination extends Utils{
	
	Response responseAPTU6671;
	public static String statusUrlAPTU6671;
	
	@When("BaseURI, Authorisation and Content-Type with APTU6671 body and calls POST http request with APTU6671 resource")
	public void base_uri_authorisation_and_content_type_with_aptu6671_body_and_calls_POST_http_request_with_APTU6671_resource() throws IOException {
	    
		/* ************IMP*********
		  Here we are using '.contentType("multipart/form-data")' 
		  because we are using 'form-data' having 'KEY' = 'files' 
		  and 'VALUE'= 'C:\Users\e5647787\OneDrive - FIS\Desktop\APIAutomationTesting\CompositionAttributes_coco.zip' 
		       Note - Make sure to add file name in 'new File()'
		*/
		RestAssured.baseURI= "http://vlmazdeventapp3.fisdev.local:8080/enterprise/";
		
		 responseAPTU6671 = 
				   given().urlEncodingEnabled(false).log().all().
		           header("Authorization", getGlobalValue("Authorization"))
		          .contentType("multipart/form-data")
		          .multiPart("files", new File("C:\\Users\\e5647787\\OneDrive - FIS\\Desktop\\APIAutomationTesting\\CompositionAttributes_coco.zip"))   
                  .when()
                  .post("rest/file-upload/?charset=ISO-8859-1&version=STANDARD&overrides=false&comment=")
                  .then()
                  .assertThat().statusCode(200)
                  .extract().response();
			
	}
	
	@Then("Get statusUrl from response body")
	public void get_status_url_from_response_body() {
	    
		statusUrlAPTU6671 = getJsonPath(responseAPTU6671, "statusUrl");
		
	}
	
}
