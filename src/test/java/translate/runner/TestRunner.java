package translate.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features="src/test/resources/features" ,
                  glue="translate/step_definitions",
                   publish = true,
                  plugin = {"html:target/cucumber.html" ,
                          "rerun:target/rerun.txt"
                          // store the failed scenario into rerun.txt
                  },
                 dryRun = false,
                 tags="@wip" //work in progress

)
public class TestRunner {
}
