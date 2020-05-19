package com.acme.bank.dbo.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:bdd",
        glue = "com.acme.bank.dbo.bdd.glue",
        plugin = {
                "pretty",
                "json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-reports/",
                "junit:target/cucumber-reports/cucumber.xml"
        },
        strict = true
)
public class CucumberTest {
}
