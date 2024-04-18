package runners;


import org.junit.runner.RunWith;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        // Rerun failed tests from rerun.txt file
        features = {"src/test/java/resources/features/truong.feature"},
        glue = {"stepdefinitions", "hooks"},
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"
        }
)

public class abcTest {
private void pub() {
	// TODO Auto-generated method stub
	ExtentReports a = new ExtentReports();
	ExtentTest b = a.createTest(null) ;
	b.addScreenCaptureFromPath(null, null);
}
}
