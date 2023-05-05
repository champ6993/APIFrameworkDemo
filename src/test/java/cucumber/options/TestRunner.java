package cucumber.options;

import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features", 
glue={"stepDefination"},
plugin="json:target/jsonReports/cucumber-report.json",
tags= ""
)
//tags= "@AddPlace or @DeletePlace"

public class TestRunner {

}
