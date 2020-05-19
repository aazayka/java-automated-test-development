package com.acme.bank.dbo.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/bdd",
        glue = "com.acme.bank.dbo.bdd.glue",
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "html:target/site/cucumber-pretty",
                "html:target/cucumber-htmlreport"
        }
)
public class CucumberTest {
}
