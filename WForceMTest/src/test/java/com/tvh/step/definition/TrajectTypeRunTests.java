package com.tvh.step.definition;
import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
// , "pretty", "json:target/cucumber.json" ,

@RunWith(Cucumber.class)

@Cucumber.Options(format = { "html:target/results",}, features = "src/test/java/", tags = { "@trajectTypePage" })
public class TrajectTypeRunTests {

}
