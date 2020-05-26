package com.acme.banking.dbo.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:bdd",
        glue = "com.acme.banking.dbo.bdd.glue",
        plugin = {
                "pretty",
                "json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-reports/",
                "junit:target/cucumber-reports/cucumber.xml",
                "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"
        },
        strict = true
)
public class CucumberTest {
}
