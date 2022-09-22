package translate.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {


    private Driver() {
    }


    //make element WebDriver private  coz we want to close access from outside the class
    //make it static coz we'll use in a static method
    private static WebDriver driver;//value is null by default

    //create re-usable utility method which will return same driver instance when we'll call
    public static WebDriver getDriver() {
        if ((driver == null)) {

            String browserType = ConfigReader.read("browser");
            //if it's null I want to create my wish browser
            // and it will return with browser type, get it from config.prop as value.
            // We can control what browser is opened from outside our code

            //depending on browserType that will be return from config.prop file,
            // switch statement will determine the case and open matching browser
            switch (browserType){//generate 'switch' to indicate all browsers type to choose
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                default:
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        }
        return driver;//if not null then return with current 'driver'
    }

    //method to make sure our driver value always 'null' after using 'quite()' method,
    // basically restart browser after 'quit'
    public static void closeDriver(){
        if(driver!=null){
            driver.quit();//this line will terminate existing session, value will not even be null
            driver=null;//assign value back to null
        }

    }


}
