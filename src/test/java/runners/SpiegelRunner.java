package runners;

import constants.Constants;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static constants.Constants.*;

//public class SpiegelRunner {

    @RunWith(Cucumber.class)
    @CucumberOptions(plugin = { "pretty", "html:" + HTML_RESULT_FOLDER + "/spiegel.html",
            "json:" + JSON_RESULT_FOLDER + "/spiegel.json",
            "junit:" + XML_RESULT_FOLDER
                    + "/spiegel.xml" }, features = SPIEGEL_FEATURE, glue = SPIEGEL_STEPS_DEFINITION) //, tags = "@bestsellerKinderBuch")
    public class SpiegelRunner {
    }