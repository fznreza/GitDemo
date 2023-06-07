package resources;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".\\src\\test\\java\\features",plugin="json:target/jsonReports/cucmber-report.json" ,
glue = {"stepDefinations"},
dryRun=true)

public class TestRunner {

}
