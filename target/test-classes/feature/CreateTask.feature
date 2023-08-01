Feature: Create New Task

  @Test_for:Today>Task,Tag>Shopping,Priority>Low
  Scenario Outline: User can create a new task with all fields fully completed.
    Given User in today's list
    When User click Add New Task
    And User enter the Title "<TaskName>"
    And User enter Note "<TaskDesc>"
    And User pick one tag "<Tag>"
    And User pick today on start date and tomorrow for due date
    And User choose "<Priority>" priority
    And User click button Save
    Then User is able to view a newly added task "<TaskName>" on the today's list.
    And The task should display the title "<TaskName>", tag "<Tag>" and start date "<StartDate>"

    Examples:
      | TaskName | TaskDesc | Tag | StartDate | EndDate | Priority |
      | Cucumber Task 1 | Task 1 Detail | Shopping | Today | Today | Low |
      | Cucumber Task 2 | Task 2 Detail | Shopping | Today | Today | Low |
