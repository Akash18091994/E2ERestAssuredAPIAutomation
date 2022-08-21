package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class APTAPIBodies {

	
	public static String workspaceEndPoint1()
	{
		return "{ \"portfolioCode\":\"COMP-UK-EQ\", \r\n"
				+ "\"valuationDate\":\"2015-10-31\", \r\n"
				+ "\"model\":\"WorldEqBndFndCm_1wMTV_Lo_GBP_\", \r\n"
				+ "\"benchmarkCode\":\"BNCH-FTSE100\"\r\n"
				+ "}";
	}
	
	public static String workspaceEndPoint2()
	{
		return "{ \"portfolioCode\":\"COMP-UK-EQ\", \r\n"
				+ "\"valuationDate\":\"2015-10-31\", \r\n"
				+ "\"benchmarkCode\":\"BNCH-FTSE100\"\r\n"
				+ "}";
	}
	
	public static String workspaceEndPoint3()
	{
		return "{ \"portfolioCode\":\"COMP-UK-EQ2\", \r\n"
				+ "\"valuationDate\":\"2015-10-31\", \r\n"
				+ "\"model\":\"WorldEqBndFndCm_1wMTV_Lo_GBP_\", \r\n"
				+ "\"benchmarkCode\":\"BNCH-FTSE100\"\r\n"
				+ "}";
	}
	
	public static String reportEndPoint1()
	{
		return "{ \"portfolioCode\":\"COMP-UK-EQ\", \r\n"
				+ "\"valuationDate\":\"2015-10-31\", \r\n"
				+ "\"benchmarkCode\":\"BNCH-FTSE100\"\r\n"
				+ "}";
	}
	
	public static String reportEndPoint2()
	{
		return "{ \"portfolioCode\":\"COMP-UK-EQ\", \r\n"
				+ "\"valuationDate\":\"2015-10-31\", \r\n"
				+ "\"model\":\"WorldEqBndFndCm_1wMTV_Lo_GBP_\", \r\n"
				+ "\"benchmarkCode\":\"BNCH-FTSE100\"\r\n"
				+ "}";
	}
	
	public static String reportEndPoint3()
	{
		return "{ \"portfolioCode\":\"COMP-UK-EQ2\", \r\n"
				+ "\r\n"
				+ "\"valuationDate\":\"2015-10-31\", \r\n"
				+ "\r\n"
				+ "\"model\":\"WorldEqBndFndCm_1wMTV_Lo_GBP_\", \r\n"
				+ "\r\n"
				+ "\"benchmarkCode\":\"BNCH-FTSE100\"\r\n"
				+ "\r\n"
				+ "}";
	}
	
	public static String dataExtract1()
	{
		return "{ \"portfolioCode\":\"COMP-UK-EQ2\", \r\n"
				+ "\"valuationDate\":\"2015-10-31\", \r\n"
				+ "\"model\":\"WorldEqBndFndCm_1wMTV_Lo_GBP_\", \r\n"
				+ "\"benchmarkCode\":\"BNCH-FTSE100\"\r\n"
				+ "}";
	}
	
	public static String dataExtract2()
	{
		return "{ \"portfolioCode\":\"COMP-UK-EQ\", \r\n"
				+ "\"valuationDate\":\"2015-10-31\", \r\n"
				+ "\"benchmarkCode\":\"BNCH-FTSE100\"\r\n"
				+ "}";
	}
	
	public static String dataExtract3()
	{
		return "{ \"portfolioCode\":\"COMP-UK-EQ\", \r\n"
				+ "\r\n"
				+ "\"valuationDate\":\"2015-10-31\", \r\n"
				+ "\r\n"
				+ "\"model\":\"WorldEqBndFndCm_1wMTV_Lo_GBP_\", \r\n"
				+ "\r\n"
				+ "\"benchmarkCode\":\"BNCH-FTSE100\"\r\n"
				+ "\r\n"
				+ "}";
	}
	
	public static String optionAssetType(String SecID)
	{
		return "{\r\n"
				+ "\"assetName\":\"G4S AMERICAN PUT OPTION\",\r\n"
				+ "\"securityCode\":\"UI:9164378\",\r\n"
				+ "\"securityId\":\""+SecID+"\",\r\n"
				+ "\"assetClassificationName\":\"Option\",\r\n"
				+ "\"modellingTypeCode\":\"Option\",\r\n"
				+ "\"serverType\":\"Option\",\r\n"
				+ "\"isoTenantCurrency\":\"United Kingdom Pound\",\r\n"
				+ "\"auditComment\":\"Test-2\",\r\n"
				+ "\"assetClass\":\"47\",\r\n"
				+ "\"optionType\":\"C\",\r\n"
				+ "\"underlyingCode\":\"ABC\",\r\n"
				+ "\"direction\":\"Up\",\r\n"
				+ "\"barrierLevel\":\"1\",\r\n"
				+ "\"barrierType\":\"Out\",\r\n"
				+ "\"payOffAmount\":\"150\",\r\n"
				+ "\"strike\":\"100\",\r\n"
				+ "\"exerciseType\":\"E\",\r\n"
				+ "\"expires\":\"2025-01-01\",\r\n"
				+ "\"fixedExchangeRate\":\"21.453\",\r\n"
				+ "\"underlyingCurrency\":\"36\"\r\n"
				+ "}";
	}
	
	public static String StructuredBondAssetType(String SecID)
	{
		return "{\r\n"
				+ "\"issuerLabel\" : \"AMORTIZING UK GOV BOND\",\r\n"
				+ "\"securityCode\" : \"UI:4264174\",\r\n"
				+ "\"securityId\":\""+SecID+"\",\r\n"
				+ "\"assetClassificationName\" : \"Amortizing Bond\",\r\n"
				+ "\"modellingTypeCode\" : \"Amortizing Bond\",\r\n"
				+ "\"serverType\" : \"Structured\",\r\n"
				+ "\"auditComment\" : \"Test-1\",\r\n"
				+ "\"forceConversion\" : \"true\",\r\n"
				+ "\"conversionPrice\" : \"1.11\",\r\n"
				+ "\"conversionStartDate\" : \"2019-01-01\",\r\n"
				+ "\"conversionEndDate\" : \"2025-01-01\",\r\n"
				+ "\"callScheduleStyle\" : \"DISCRETE\",\r\n"
				+ "\"correlatedResidualGroup\" : \"Default\"\r\n"
				+ "}";
	}
	
	public static String swaptionAssetType(String SecID)
	{
		return "{\r\n"
				+ "\"assetClass\" : \"41\",\r\n"
				+ "\"assetName\" : \"SWAPTION\",\r\n"
				+ "\"securityCode\" : \"UI:15589858\",\r\n"
				+ "\"securityId\":\""+SecID+"\",\r\n"
				+ "\"assetClassificationName\" : \"QA : Swaption\",\r\n"
				+ "\"modellingTypeCode\" : \"Swaption\",\r\n"
				+ "\"serverType\" : \"Swaption\",\r\n"
				+ "\"isoTenantCurrency\" : \"United States Dollar\",\r\n"
				+ "\"auditComment\" : \"Test-3\",\r\n"
				+ "\"curveSwapType\" : \"null\",\r\n"
				+ "\"paymentFrequency\" : \"4\",\r\n"
				+ "\"shortPaymentFrequency\" : \"6\",\r\n"
				+ "\"swapRate\" : \"0.45\",\r\n"
				+ "\"swapTermYears\" : \"0.5\",\r\n"
				+ "\"underlyingSwapType\" : \"COLLATERALIZED_IRS\",\r\n"
				+ "\"exerciseType\" : \"E\",\r\n"
				+ "\"expires\" : \"2025-01-01\",	\r\n"
				+ "\"correlatedResidualGroup\" : \"Default\"\r\n"
				+ "}";
	}
	
	public static String CurrencySwapAssetType(String SecID)
	{
		return "{\r\n"
				+ "\"securityId\":\""+SecID+"\",\r\n"
				+ "\"assetName\": \"CURRENCY SWAP TRIANGULATION\",\r\n"
				+ "\"assetClass\": \"55\",\r\n"
				+ "\"modellingTypeCode\": \"QA: Currency Swap\",\r\n"
				+ "\"serverType\": \"CurrencySwap\",\r\n"
				+ "\"expires\": \"2020-12-31\",\r\n"
				+ "\"securityCode\": \"SEC-UDA-(Multi)-CurrSwap-009\",\r\n"
				+ "\"issueDate\": \"2018-01-01\",\r\n"
				+ "\"auditComment\": \"test-CurrencySwap-2\",\r\n"
				+ "\"longNotional\": \"155127\",\r\n"
				+ "\"shortNotional\": \"123\",\r\n"
				+ "\"shortFloatingSpread\": null,\r\n"
				+ "\"longCouponType\": \"FIXED\",\r\n"
				+ "\"coupon\": \"3.54\",\r\n"
				+ "\"shortCouponType\": \"FLOATING\",\r\n"
				+ "\"longFirstPaymentDate\": \"2018-09-01\",\r\n"
				+ "\"shortFirstPaymentDate\": \"2018-09-01\",\r\n"
				+ "\"id\": \"CurSwap1\",\r\n"
				+ "\"paymentFrequency\": \"9\",\r\n"
				+ "\"shortPaymentFrequency\": \"155\",\r\n"
				+ "\"longCurrency\": \"33\",\r\n"
				+ "\"shortCurrency\": \"2\",\r\n"
				+ "\"shortCoupon\": \"4\",\r\n"
				+ "\"correlatedResidualGroup\": \"None\"\r\n"
				+ "}";
	}
	
	public static String StructuredAssetTypeBondAssetClass(String SecID)
	{
		return "{\r\n"
				+ "\"issuerLabel\": \"CALLABLE UK GOV BOND\",\r\n"
				+ "\"inflationIndex\": \"UK RPI\",\r\n"
				+ "\"securityCode\": \"UI:3456789\",\r\n"
				+ "\"securityId\":\""+SecID+"\",\r\n"
				+ "\"assetClassificationName\": \"Structured Bond\",\r\n"
				+ "\"inflationLagStep\": \"6\",\r\n"
				+ "\"interpolationFlag\": \"false\",\r\n"
				+ "\"serverType\": \"Structured\",\r\n"
				+ "\"auditComment\": \"Test-Structured\",\r\n"
				+ "\"forceConversion\": \"true\",\r\n"
				+ "\"conversionPrice\": \"1.11\",\r\n"
				+ "\"conversionStartDate\": \"2019-01-01\",\r\n"
				+ "\"conversionEndDate\": \"2020-01-01\",\r\n"
				+ "\"callScheduleStyle\": \"DISCRETE\",\r\n"
				+ "\"correlatedResidualGroup\": \"None\",\r\n"
				+ "\"principal\": \"7.147\"\r\n"
				+ "}";
	}
	
	public static String COCOAssetType(String SecID)
	{
		return "{\r\n"
				+ "\"assetClass\": \"55\",\r\n"
				+ "\"assetClassificationName\": \"ContingentConvertibleBond\",\r\n"
				+ "\"assetName\": \"coco_dyc_5\",\r\n"
				+ "\"auditComment\": \"Test-COCO12\",\r\n"
				+ "\"conversionPrice\": \"120.2\",\r\n"
				+ "\"coupon\": null,\r\n"
				+ "\"couponFrequency\": \"4\",\r\n"
				+ "\"id\": \"coco_dyc_5\",\r\n"
				+ "\"isoTenantCurrency\": \"United States Dollar\",\r\n"
				+ "\"isoTenantCurrencyId\": \"3\",\r\n"
				+ "\"modellingTypeCode\": \"2020-12-31\",\r\n"
				+ "\"resetPeriod\": null,\r\n"
				+ "\"securityCode\": \"COCO-TEST2_16\",\r\n"
				+ "\"securityId\":\""+SecID+"\",\r\n"
				+ "\"serverType\": \"ContingentConvertibleBond\",\r\n"
				+ "\"tenor\": null,\r\n"
				+ "\"underlying\": \"FTSE100\",\r\n"
				+ "\"underlyingIDType\": \"Ticker\",\r\n"
				+ "\"writeDownPrincipal\": \"1000\",\r\n"
				+ "\"actionOnTrigger\": \"CONVERTS_TO_SHARES\",\r\n"
				+ "\"principal\": \"2.4\",\r\n"
				+ "\"correlatedResidualGroup\": \"Default\"\r\n"
				+ "}";
	}
	
	public static String APTU6628()
	{
		return "{\r\n"
				+ "    \"alpha\": 0.1,\r\n"
				+ "    \"beta\": 0.2,\r\n"
				+ "    \"gamma\": 0.3,\r\n"
				+ "    \"delta\": 0.4,\r\n"
				+ "    \"tailThreshold\": 0.5,\r\n"
				+ "    \"sigma\": 0.6,\r\n"
				+ "    \"k\": 0.8\r\n"
				+ "}";
	}
	
	public static String APTU6629()
	{
		return "{\r\n"
				+ "    \"alpha\": 0.2,\r\n"
				+ "    \"beta\": 0.4,\r\n"
				+ "    \"gamma\": 0.6,\r\n"
				+ "    \"delta\": 0.8,\r\n"
				+ "    \"tailThreshold\": 0.1,\r\n"
				+ "    \"sigma\": 0.3,\r\n"
				+ "    \"k\": 0.5\r\n"
				+ "}";
	}
	
	public static String APTU6627(String securityID)
	{
		return "{\r\n"
				+ "\"assetName\":\"Adjustable Rate MBS 1\",\r\n"
				+ "\"modellingTypeCode\":\"Adjustable Rate MBS\",\r\n"
				+ "\"securityCode\":\"Adjustable Rate MBS 1\",\r\n"
				+ "\"assetClassificationName\":\"Adjustable Rate MBS\",\r\n"
				+ "\"isoTenantCurrency\":\"United States Dollar\",\r\n"
				+ "\"isoTenantCurrencyId\":347,\r\n"
				+ "\"serverType\":\"AdjustableRateMBS\",\r\n"
				+ "\"assetClass\":421,\r\n"
				+ "\"securityId\":" + securityID +",\r\n"
				+ "\"auditComment\":\"This is test comment\",\r\n"
				+ "\"id\":\"Adjustable Rate MBS 1\",\r\n"
				+ "\"originalBalance\":900000,\r\n"
				+ "\"currentBalance\":850000,\r\n"
				+ "\"originalDate\":\"2020-07-11\",\r\n"
				+ "\"redemptionDate\":\"2070-07-13\",\r\n"
				+ "\"serviceFee\":\"0.0002\",\r\n"
				+ "\"guaranteeFee\":\"0.0002\",\r\n"
				+ "\"mbsTypeId\":\"6\",\r\n"
				+ "\"fixedTerm\":\"38\",\r\n"
				+ "\"balloonTerm\":\"5\",\r\n"
				+ "\"resetPeriod\":\"3y\",\r\n"
				+ "\"indexTenor\":\"2y\",\r\n"
				+ "\"margin\":\"0.025\",\r\n"
				+ "\"periodicCap\":\"0.026\",\r\n"
				+ "\"periodicFloor\":\"0.027\",\r\n"
				+ "\"firstPeriodicCap\":\"0.035\",\r\n"
				+ "\"firstPeriodicFloor\":\"0.036\",\r\n"
				+ "\"lifetimeCap\":\"0.1\",\r\n"
				+ "\"lifetimeFloor\":\"0.025\",\r\n"
				+ "\"paymentPeriod\":\"1m\",\r\n"
				+ "\"paymentCap\":\"0.15\",\r\n"
				+ "\"paymentFloor\":\"0.02\",\r\n"
				+ "\"negativeAmortizationCap\":\"0.35\",\r\n"
				+ "\"amortType\":\"LEVEL_PI\",\r\n"
				+ "\"dayCount\": \"ACT_365\",\r\n"
				+ "\"interestOnlyTerm\":\"4\",\r\n"
				+ "\"fixedMaturityDate\":\"true\"\r\n"
				+ "}";
	}
	
	public static String APTU6655() throws SQLException
	{
		
        String dbURL = "jdbc:mysql://vlmazdeventapp3.fisdev.local:3306/Prd";
		
		String user = "ent_dba";
		
		String password = "ent_dbaPassw0rd";
		
		Connection con = DriverManager.getConnection(dbURL, user, password);
		
		Statement s = con.createStatement();
		
        ResultSet rs = null;
        
        rs = s.executeQuery("Select JobCompositionID,CompositionKey,ValuationDate from Prd.JobExecution where CreatedBy = 'AKASH.TEST' order by 1 desc;");
		 
		rs.next();
		
		String compositionID = rs.getString("JobCompositionID");
		
		String portfolioKey = rs.getString("CompositionKey");
		
		String valuationDate = rs.getString("ValuationDate");
		
		return "[\r\n"
				+ "{\r\n"
				+ "\"jobCompositionId\":"+compositionID+",\r\n"
				+ "\"portfolioKey\":"+portfolioKey+",\r\n"
				+ "\"calculationDate\":\""+valuationDate+"\"\r\n"
				+ "}\r\n"
				+ "]";
	}
	
	public static String APTU6658() throws SQLException
	{
		
        String dbURL = "jdbc:mysql://vlmazdeventapp3.fisdev.local:3306/Prd";
		
		String user = "ent_dba";
		
		String password = "ent_dbaPassw0rd";
		
		Connection con = DriverManager.getConnection(dbURL, user, password);
		
		Statement s = con.createStatement();
		
        ResultSet rs = null;
        
        rs = s.executeQuery("Select JobCompositionID,CompositionKey,ValuationDate from Prd.JobExecution where CreatedBy = 'AKASH.TEST' order by 1 desc;");
		 
		rs.next();
		
		String compositionID = rs.getString("JobCompositionID");
		
		String portfolioKey = rs.getString("CompositionKey");
		
		final Calendar cal = Calendar.getInstance();
		
	    cal.add(Calendar.DATE, -1);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String valuationDate = dateFormat.format(cal.getTime());
		
		return "[\r\n"
				+ "{\r\n"
				+ "\"jobCompositionId\":"+compositionID+",\r\n"
				+ "\"portfolioKey\":"+portfolioKey+",\r\n"
				+ "\"calculationDate\":\""+valuationDate+"\"\r\n"
				+ "}\r\n"
				+ "]";
	}
	
}
