package steps;

import PageObjects.CreateTaskPage;
import PageObjects.MenuPage;
import PageObjects.TaskListPage;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import tests.TestBase;

import java.net.MalformedURLException;
import java.util.List;

public class CreateCompleteTask extends TestBase {
    CreateTaskPage createTaskPage;
    TaskListPage taskListPage;
    MenuPage menuPage;
    @Given("User in today's list")
    public void userInTodaySList() throws MalformedURLException {
        setupAndroid();
        taskListPage = new TaskListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        menuPage = new MenuPage(driver);
        menuPage.checkPage();
    }

    @When("User click Add New Task")
    public void userClickAddNewTask() {
        taskListPage.clickAddTaskBtn();
    }

    @And("User enter the Title {string}")
    public void userEnterTheTitle(String taskName) {
        createTaskPage.enterTitle(taskName);
    }

    @And("User enter Note {string}")
    public void userEnterNote(String taskDesc) {
        createTaskPage.enterNote(taskDesc);
    }

    @And("User pick one tag {string}")
    public void userPickOneTag(String varTag) {
        createTaskPage.clickTag();
        createTaskPage.selectTag(varTag);
        createTaskPage.clickOK();
    }

    @And("User pick today on start date and tomorrow for due date")
    public void userPickTodayOnStartDateAndTomorrowForDueDate() {
        createTaskPage.clickStartDate();
        createTaskPage.selectStartDate();
        createTaskPage.clickOK();
        createTaskPage.clickEndDate();
        createTaskPage.selectEndDate();
        createTaskPage.clickOK();
    }

    @And("User choose {string} priority")
    public void userChoosePriorityHigh(String varPriority) {
        createTaskPage.clickPriority();
        createTaskPage.selectPriority(varPriority);
        createTaskPage.clickOK();
    }

    @And("User click button Save")
    public void userClickButtonSave() {
        createTaskPage.clickSave();
        ((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.BACK));
    }

    @Then("User is able to view a newly added task {string} on the today's list.")
    public void userIsAbleToViewANewlyAddedTaskOnTheTodaySList(String taskName) throws MalformedURLException {
        List<String> DataList = taskListPage.captureDataList();
        int dataSize = taskListPage.captureDataList().size();
        int lastData = dataSize - 1 ;

        String el = DataList.get(lastData);
        Assert.assertEquals(taskListPage.getTitle(lastData),taskName,"Title Match");
    }

    @And("The task should display the title {string}, tag {string} and start date {string}")
    public void theTaskShouldDisplayTheTitleTagAndStartDate(String taskName, String tagName, String startDate){
        List<String> DataList = taskListPage.captureDataList();
        int dataSize = taskListPage.captureDataList().size();
        int lastData = dataSize - 1 ;

        String el = DataList.get(lastData);
        Assert.assertEquals(taskListPage.getTitle(lastData),taskName,"Title Match");
        Assert.assertEquals(taskListPage.getTag(lastData),tagName,"Tag Match");
        Assert.assertEquals(taskListPage.getStartDate(lastData),startDate,"Start date Match");
        tearDown();
    }

}
