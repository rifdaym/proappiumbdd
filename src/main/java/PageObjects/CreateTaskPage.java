package PageObjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateTaskPage extends PageBase{

    public CreateTaskPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "com.jeffprod.todo:id/editTextTitre")
    WebElement fieldTitle;
    @AndroidFindBy(id = "com.jeffprod.todo:id/editTextNote")
    WebElement fieldNote;
    @AndroidFindBy(id = "com.jeffprod.todo:id/action_save")
    WebElement btnSave;
    @AndroidFindBy(id = "com.jeffprod.todo:id/editTextTag")
    WebElement btnTag;
    @AndroidFindBy(id = "com.jeffprod.todo:id/buttonStartDate")
    WebElement btnStartDate;
    @AndroidFindBy(id = "com.jeffprod.todo:id/buttonDeadline")
    WebElement btnEndDate;
    @AndroidFindBy(id = "com.jeffprod.todo:id/editTextPriority")
    WebElement btnPriority;
    @AndroidFindBy(id = "android:id/button1")
    WebElement btnOk;
    @AndroidFindBy(className = "android.view.View")
    WebElement chooseStartDate;
    @AndroidFindBy(className = "android.view.View")
    WebElement chooseEndDate;

    public void enterTitle(String textTitle){
        clear(fieldTitle);
        sendText(fieldTitle,textTitle);
    }

    public void enterNote(String textNote){
        clear(fieldNote);
        sendText(fieldNote,textNote);
    }
    public void clickTag(){
        click(btnTag);
    }
    public void clickStartDate(){ click(btnStartDate); }
    public void clickEndDate(){ click(btnEndDate); }
    public void clickPriority() { click(btnPriority); }
    public void clickSave(){
        click(btnSave);
    }
    public void selectTag(String varTag){
        WebElement chooseTag1 = driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiSelector().text(\"" + varTag + "\")"));
        click(chooseTag1);
    }
    public void selectStartDate(){
        click(chooseStartDate);
    }
    public void selectEndDate(){click(chooseEndDate);}
    public void selectPriority(String varPriority){
        WebElement choosePriority = driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiSelector().text(\"" + varPriority + "\")"));
        click(choosePriority);
    }
    public void clickOK(){ click(btnOk); }

}
