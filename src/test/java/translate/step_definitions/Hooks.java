package translate.step_definitions;


import translate.utilities.ConfigReader;
import translate.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;


public class Hooks {

    @Before()
    public void uiSetup() {
        Driver.getDriver().get(ConfigReader.read("googleTranslateUrl"));
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After()
    public void uiTearDown(Scenario scenario) {

        // check if scenario failed or not
        if (scenario.isFailed()) {
            //take a screenshot if failed
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Image for failed step");
        }
        Driver.closeDriver();
    }

}
