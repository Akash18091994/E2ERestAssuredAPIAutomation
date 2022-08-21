package cucumber.Options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)

@CucumberOptions(features="src/test/java/features",

glue= {"stepDefinations"},

plugin ={"pretty","json:target/jsonReports/cucumber-report.json","html:target/jsonReports/cucumber-report.html"},

tags= "@APTRegression or @APTSmoke")

public class TestRunner {

}
