package com.facebook.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".\\src\\test\\resources\\Faceookredo.feature",
		glue = "signupFb",
		tags = "@FaceookSignup",
		plugin = {"html:target/index.html","json:target/report.json"}
		)
public class TestRunner {

}
