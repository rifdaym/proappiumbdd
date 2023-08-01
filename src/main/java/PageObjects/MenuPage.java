package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenuPage extends PageBase{
    public MenuPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(className= "android.widget.ImageButton")
    WebElement btnBurgerMenu;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Today\")")
    WebElement btnMenuToday;
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Today\")")
    @AndroidFindBy(className = "android.widget.TextView")
    WebElement namePage;

    public void clickBurgerMenu(){
        click(btnBurgerMenu);
    }
    public void clickMenuToday(){ click(btnMenuToday); }
    public void checkPage(){
        String txt = getAttribute2(namePage,"text");
        if (!"Today".equals(txt)){
            clickBurgerMenu();
            clickMenuToday();
        }
    }
}
