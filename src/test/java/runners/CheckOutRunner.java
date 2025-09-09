package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/Features/",
        glue = "src/test/java/stepdefinition",
        plugin = {"pretty", "html:target/cuumber-html-report",
                "json:target/cucumber.json", "junit:target/cucumber.xml"},
        tags = "@test"
)

public class CheckOutRunner {
}
