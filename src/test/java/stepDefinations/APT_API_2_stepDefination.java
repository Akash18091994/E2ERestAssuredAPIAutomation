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

public class APT_API_2_stepDefination extends Utils{
	
	String jobExecutionID1;
	String jobExecutionID2;
	
	@Given("Execute SQL Query to get JobExecutionID")
	public void execute_sql_query_to_get_job_execution_id() throws SQLException {
	    
        String dbURL = "jdbc:mysql://vlmazdeventapp3.fisdev.local:3306/Rst";
		
		String user = "ent_dba";
		
		String password = "ent_dbaPassw0rd";
		
		Connection con = DriverManager.getConnection(dbURL, user, password);
		
		Statement s = con.createStatement();
		
        ResultSet rs = null;
			
		rs = s.executeQuery("SELECT\r\n"
				+ "jex.JobExecutionID\r\n"
				+ "FROM\r\n"
				+ "Prd.JobExecution jex\r\n"
				+ "INNER JOIN\r\n"
				+ "Prd.JobComposition jc ON jc.JobCompositionID = jex.JobCompositionID\r\n"
				+ "INNER JOIN\r\n"
				+ "Prd.JobDefinition jd ON jd.JobDefinitionID = jc.JobDefinitionID\r\n"
				+ "INNER JOIN\r\n"
				+ "Prd.CompositionKey compkey ON compkey.CompositionKey = jex.CompositionKey\r\n"
				+ "LEFT JOIN\r\n"
				+ "Prd.CompositionKey benkey ON benkey.CompositionKey = jex.BenchmarkID\r\n"
				+ "WHERE\r\n"
				+ "compkey.CompositionCode = 'PLEV1.1'\r\n"
				+ "AND jex.ValuationDate = '2015-12-29'\r\n"
				+ "AND jd.name = 'MAC TEMPLATE'\r\n"
				+ "ORDER BY 1 DESC\r\n"
				+ "LIMIT 1");
		 
		rs.next();
			
		jobExecutionID1 =  rs.getString("JobExecutionID");
		 
		rs = s.executeQuery("SELECT\r\n"
				+ "jex.JobExecutionID\r\n"
				+ "FROM\r\n"
				+ "Prd.JobExecution jex\r\n"
				+ "INNER JOIN\r\n"
				+ "Prd.JobComposition jc ON jc.JobCompositionID = jex.JobCompositionID\r\n"
				+ "INNER JOIN\r\n"
				+ "Prd.JobDefinition jd ON jd.JobDefinitionID = jc.JobDefinitionID\r\n"
				+ "INNER JOIN\r\n"
				+ "Prd.CompositionKey compkey ON compkey.CompositionKey = jex.CompositionKey\r\n"
				+ "LEFT JOIN\r\n"
				+ "Prd.CompositionKey benkey ON benkey.CompositionKey = jex.BenchmarkID\r\n"
				+ "WHERE\r\n"
				+ "compkey.CompositionCode = 'COMP-UK-BOND'\r\n"
				+ "AND jex.ValuationDate = '2015-10-31'\r\n"
				+ "AND jd.name = 'RPMI PBA'\r\n"
				+ "ORDER BY 1 DESC\r\n"
				+ "LIMIT 1");
			 
		rs.next();
				
	    jobExecutionID2 =  rs.getString("JobExecutionID");
		 
	    con.close();
	    
	}
		
	@When("BaseURI, Authorisation and Content-Type with APTU6537 body and user calls GET http request with APTU6537resource")
	public void base_uri_authorisation_and_content_type_with_aptu6537_body() throws IOException {
	    
		RestAssured.baseURI= "http://vlmazdeventapp3.fisdev.local:8080/enterprise/";
		
		StringBuilder stringBuilder = new StringBuilder(100);
		stringBuilder.append("rest/report/export/workspace/");
		stringBuilder.append(jobExecutionID1);
		stringBuilder.append(",");
		stringBuilder.append(jobExecutionID2);
		
		String APTU6537url = "rest/report/export/workspace/" + jobExecutionID1 + "," + jobExecutionID2;
		
		//*********IMP*********** 
		//      Below we have added 'given().urlEncodingEnabled(false)' 
		//      because sometimes when we try to concat string it adds special character like % etc 
		//      In order to get exact URL we want we have to add 'urlEncodingEnabled(false)' after given()
		
		String responseAPTU6537 = 
				   given().urlEncodingEnabled(false).log().all().
		           header("Authorization", getGlobalValue("Authorization")).
		           header("Content-Type","application/json")
		          .body("{\r\n"
		          		+ "\"url\": \""+ APTU6537url +"\",\r\n"
		          		+ "\"method\": \"GET\",\r\n"
		          		+ "\"headers\":\r\n"
		          		+ "{ \r\n"
		          		+ "\"Authorization\": \""+ getGlobalValue("Authorization") +"\",\r\n"
		          		+ "\"Accept\": \"[Object]\"\r\n"
		          		+ "},\r\n"
		          		+ "\"encoding\": \"null \"\r\n"
		          		+ "}")
                  .when()
                  .get(stringBuilder.toString())
                  .then()
                  .assertThat().statusCode(200)
                  .extract().response().asString();
		
		System.out.println(responseAPTU6537);
		
		
	}
	
	@Then("Execute SQL Query to verify Tot Sys Spec values")
	public void execute_sql_query_to_verify_tot_sys_spec_values() throws SQLException {
	    
        String dbURL = "jdbc:mysql://vlmazdeventapp3.fisdev.local:3306/Rst";
		
		String user = "ent_dba";
		
		String password = "ent_dbaPassw0rd";
		
		Connection con = DriverManager.getConnection(dbURL, user, password);
		
		Statement s = con.createStatement();
		
        ResultSet rs = null;
			
		rs = s.executeQuery("SELECT rcomp.Composition,\r\n"
				+ "rst.resulttype,\r\n"
				+ "rop.OperationType,\r\n"
				+ "prs.Valuationdate,\r\n"
				+ "tss.Total,\r\n"
				+ "tss.Systematic,\r\n"
				+ "tss.Specific_\r\n"
				+ "FROM Rst.TotSysSpecRoot tss\r\n"
				+ "INNER JOIN Rst.ResultComposition rcomp ON rcomp.resultcompositionid = tss.resultcompositionid\r\n"
				+ "INNER JOIN Rst.Result rst ON rst.resultid = tss.resultid\r\n"
				+ "INNER JOIN Rst.ResultOperation rop ON rop.resultoperationid = tss.resultoperationid\r\n"
				+ "-- INNER JOIN job.operationtype jopty on jopty.OperationTypeId = rop.OperationType\r\n"
				+ "INNER JOIN Rst.PortfolioReportSummary prs ON prs.PortfolioReportSummaryID = rst.PortfolioReportSummaryID\r\n"
				+ "WHERE rcomp.JobExecutionID = (SELECT\r\n"
				+ "MIN(jex.JobExecutionID)\r\n"
				+ "FROM Rst.ResultComposition jex\r\n"
				+ "WHERE jex.JobExecutionID = " + jobExecutionID1 + ")\r\n"
				+ "AND rst.resulttype = 'PORTFOLIO'\r\n"
				+ "AND tss.resulttype ='CONTRIBUTION'\r\n"
				+ "AND rop.OperationType = 'VOLATILITY'\r\n"
				+ "AND rop.OperationName = 'VOLATILITY.NORMAL'\r\n"
				+ "AND rop.distributiontype = 'NORMAL';");
		 
		rs.next();
			
		String actualTotValue1 =  rs.getString("Total");
		
        String expectedTotValue1 = "16.8626239231705";
		
		assertEquals(actualTotValue1,expectedTotValue1);
		
		rs = s.executeQuery("SELECT rcomp.Composition,\r\n"
				+ "rst.resulttype,\r\n"
				+ "rop.OperationType,\r\n"
				+ "prs.Valuationdate,\r\n"
				+ "tss.Total,\r\n"
				+ "tss.Systematic,\r\n"
				+ "tss.Specific_\r\n"
				+ "FROM Rst.TotSysSpecRoot tss\r\n"
				+ "INNER JOIN Rst.ResultComposition rcomp ON rcomp.resultcompositionid = tss.resultcompositionid\r\n"
				+ "INNER JOIN Rst.Result rst ON rst.resultid = tss.resultid\r\n"
				+ "INNER JOIN Rst.ResultOperation rop ON rop.resultoperationid = tss.resultoperationid\r\n"
				+ "-- INNER JOIN job.operationtype jopty on jopty.OperationTypeId = rop.OperationType\r\n"
				+ "INNER JOIN Rst.PortfolioReportSummary prs ON prs.PortfolioReportSummaryID = rst.PortfolioReportSummaryID\r\n"
				+ "WHERE rcomp.JobExecutionID = (SELECT\r\n"
				+ "MIN(jex.JobExecutionID)\r\n"
				+ "FROM Rst.ResultComposition jex\r\n"
				+ "WHERE jex.JobExecutionID = " + jobExecutionID2 + ")\r\n"
				+ "AND rst.resulttype = 'PORTFOLIO'\r\n"
				+ "AND tss.resulttype ='CONTRIBUTION'\r\n"
				+ "AND rop.OperationType = 'VOLATILITY'\r\n"
				+ "AND rop.OperationName = 'VOLATILITY.NORMAL'\r\n"
				+ "AND rop.distributiontype = 'NORMAL';");
		 
		rs.next();
			
		String actualTotValue2 =  rs.getString("Total");
		
        String expectedTotValue2 = "8.98862705966208";
		
		assertEquals(actualTotValue2,expectedTotValue2);
		
		con.close();
		
	}
	
}
