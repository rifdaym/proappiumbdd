package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase{
    AppiumDriver driver;
    public static final Integer WAIT = 10;

    public PageBase(AppiumDriver appiumDriver) {  //constructor, the name same with class but its not void
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        driver = appiumDriver;
    }
    public void waitForVisibility(WebElement element) {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized");
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void clear(WebElement element){
        waitForVisibility(element);
        element.clear();
    }
    public void click(WebElement element){
        waitForVisibility(element);
        element.click();
    }
    public void sendText(WebElement element, String text) {
        waitForVisibility(element);
        element.sendKeys(text);
    }
    public String getAttribute2(WebElement element, String attribute){
        waitForVisibility(element);
        return element.getAttribute(attribute);
    }
}
