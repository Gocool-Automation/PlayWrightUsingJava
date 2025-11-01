Feature: Login functionality

  Background:
    Given user navigates to "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    Then user lands on Login page

  @RegressionTest @Test1
  Scenario: Valid user logs into application
    When user enters username "Admin" and password "admin123"
    And user clicks login button
    Then user should see the homepage

  @RegressionTest @Test2
  Scenario: Invalid user logs into application
    When user enters username "invalid" and password "admin123"
    And user clicks login button
    Then user should see the error message

  @RegressionTest @Test3
  Scenario: Verify all the Homepage Links on the left side menu
    When user enters username "Admin" and password "admin123"
    And user clicks login button
    Then user should see all the Homepage Links

