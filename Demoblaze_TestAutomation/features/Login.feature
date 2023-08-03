#Author: Bhanu

Feature: Scenarios for Login functionality

  Background: 
    Given user open the browser
    And user navigates to the Demoblaze site

  @login1
  Scenario Outline: To verify alert shown when Login with invalid credentials
    When user clicks on "Log in" menu link
    Then check Login dialog is displayed
    When I enter Username <username> and Password <password> and click on Log in
    Then verify alert popup displayed with text "Please fill out Username and Password."

    Examples: 
      | username  | password |
      | ''        | ''       |
      | 'Bhanu'   | ''       |
      | ''        | 'pwd123' |

  @login2
  Scenario: To verify alert shown when Login with wrong password
    When user clicks on "Log in" menu link
    Then check Login dialog is displayed
    When I enter Username "b_suri" and Password "pwd123" and click on Log in
    Then verify alert popup displayed with text "Wrong password."

  #covers Test Case: Edu_2
  @login3
  Scenario: To verify welcome message is shown when Login with valid credentials
    When user clicks on "Log in" menu link
    Then check Login dialog is displayed
    When I enter Username "b_suri" and Password "welcome2023" and click on Log in
    Then verify welcome message is displayed with text "Welcome b_suri"
