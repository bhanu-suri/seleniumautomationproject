#Author: Bhanu
#Feature: Test scenarios for Sign up dialog

Feature: Scenarios for Sign up functionality

  Background: 
    Given user open the browser
    And user navigates to the Demoblaze site

  #covers Test Case - Edu_3, Edu_4
  @Signup1
  Scenario: To verify the alert shown when Sign up with existing user
    When user clicks on "Sign up" menu link
    Then check Sign up dialog is displayed
    When I enter Username "b_suri" and Password "welcome2023" and click on Sign up
    Then verify alert popup displayed with text "This user already exist."

  @Signup2
  Scenario Outline: To verify the alert shown when Sign up with incomplete fields
    When user clicks on "Sign up" menu link
    Then check Sign up dialog is displayed
    When I enter Username <username> and Password <password> and click on Sign up
    Then verify alert popup displayed with text "Please fill out Username and Password."

    Examples: 
      | username  | password |
      | ''        | ''       |
      | 'Bharath' | ''       |
      | ''        | 'pwd123' |
