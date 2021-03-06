package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static constants.Constants.*;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:" + HTML_RESULT_FOLDER + "part3/spiegel.html",
            "json:" + JSON_RESULT_FOLDER + "part3/spiegel.json",
            "junit:" + XML_RESULT_FOLDER
                    + "part3/spiegel.xml" },
        features = SPIEGEL_FEATURE,
        glue = SPIEGEL_STEPS_DEFINITION
        //)
       ,tags = ("@spiegelLeftMenuNavigation"))
        //,tags = ("@spiegelCultureBestseller"))
        //,tags = ("@spiegelPlus"))
        //,tags = ("@spiegelStartPage"))
        //,tags = ("@spiegelSchlagzeilen"))
        //,tags = ("@topbeispiegel or @meistgelesene"))
        //,tags = ("@search"))
        //,tags = ("@spiegelCulture or @spiegelCultureBestseller or @spiegelPlus or @spiegelStartPage or @spiegelSchlagzeilen"))
    public class SpiegelMenuRunner {
    }