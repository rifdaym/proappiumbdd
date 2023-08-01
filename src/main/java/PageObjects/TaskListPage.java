package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TaskListPage extends PageBase{

    public TaskListPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "com.jeffprod.todo:id/fab")
    public WebElement addTaskBtn;
    public void clickAddTaskBtn(){
        click(addTaskBtn);
    }
    @AndroidFindBy(id = "com.jeffprod.todo:id/textViewListView")
    List<WebElement> titleInList;
    @AndroidFindBy(id = "com.jeffprod.todo:id/textViewDateStart")
    List<WebElement> startdateInList;
    @AndroidFindBy(id = "com.jeffprod.todo:id/textViewTag")
    List<WebElement> tagInList;
    @AndroidFindBy(id = "com.jeffprod.todo:id/imageViewNote")
    WebElement iconinlistNote;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.RelativeLayout\")")
    List<WebElement> boxinList;
    @AndroidFindBy(id = "com.jeffprod.todo:id/lv")
    List<WebElement> dataListElements;
    @AndroidFindBy(id = "com.jeffprod.todo:id/textViewListView")
    List<WebElement> boxinList2;

    public List<String> captureDataList() {
        // Extract the text of each data list element
        List<String> dataList = new ArrayList<>();
        for (WebElement element : boxinList2) {
            dataList.add(element.getText());
        }
        return dataList;
    }
    public String getTitle(int el){
        String text = getAttribute2(titleInList.get(el), "text");
        return text;
    }
    public String getTag(int el){
        String text = getAttribute2(tagInList.get(el), "text");
        return text.trim();
    }
    public String getStartDate(int el){
        String text = getAttribute2(startdateInList.get(el), "text");
        String replace = text.replace("|"," ");
        return replace.trim();
    }


}
