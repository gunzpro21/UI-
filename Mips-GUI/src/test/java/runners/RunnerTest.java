package runners;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//create folder + config reader to input data
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/resources/features/truong.feature"},
        glue = {"stepdefinitions", "hooks"},
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)

public class RunnerTest {

}