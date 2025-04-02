package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepsDefinitions", "core"},
        plugin = {"pretty", "html:target/cucumber/cucumber-report.html"},
        tags = ""
)
public class RunnerTest {
}