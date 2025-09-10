package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions(features = "src/test/resources/Features/",
        glue = "stepdefinition",
        plugin = {"pretty", "html:target/cuumber-html-report",
                "json:target/cucumber.json", "junit:target/cucumber.xml"},
        tags = "@test"
)
@RunWith(Cucumber.class)
public class CheckOutRunner {
}
