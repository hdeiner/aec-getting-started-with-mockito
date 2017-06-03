package test.com.solutionsiq.timeofday;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
//      dryRun   = false,
//      strict = true,
//      tags     = "",
        monochrome = false,
        features = { "src/test/java/test/com/solutionsiq/timeofday/" },
        glue     = { "test.com.solutionsiq.timeofday" },
        plugin   = { "pretty", "html:target/cucumber-reports/cucumber-html-report", "json:target/cucumber-reports/cucumber-json-report.json" }
)

public class TimeOfDayServiceTestRunner {
}