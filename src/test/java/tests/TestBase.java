package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase  extends AbstractTestNGCucumberTests {
    public static AppiumDriver driver;

    public static void setupAndroid() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("deviceName", "Android Emulator");
        //capabilities.setCapability("deviceName", "Mi A1");
        capabilities.setCapability("app", System.getProperty("D:/2. my personal things/Learning/TAU/Java/proappiumbdd/apps/ToDo.apk"));
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("fullReset", false);
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    public static void tearDown(){
        if(null != driver){
            driver.quit();
        }
    }
}
