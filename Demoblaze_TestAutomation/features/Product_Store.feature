#Author: Bhanu
Feature: Test scenarios for demoblaze home page

  Background: 
    Given user open the browser
    And user navigates to the Demoblaze site

  #covers Test Case: Edu_1
  Scenario: To verify the URL for Demoblaze on browser
    Then verify that demoblaze home page is displayed

  Scenario: To verify products displayed on selecting Categories -> Phones
    When user clicks on "Phones" under Categories
    Then check that product "Samsung galaxy s6" is displayed
    And check that product "Nokia lumia 1520" is displayed
    And check that product "Nexus 6" is displayed
    And check that product "Samsung galaxy s7" is displayed
    And check that product "Iphone 6 32gb" is displayed
    And check that product "Sony xperia z5" is displayed
    And check that product "HTC One M9" is displayed

  Scenario: To verify products displayed on selecting Categories -> Laptops
    When user clicks on "Laptops" under Categories
    Then check that product "Sony vaio i5" is displayed
    And check that product "Sony vaio i7" is displayed
    And check that product "MacBook air" is displayed
    And check that product "Dell i7 8gb" is displayed
    And check that product "2017 Dell 15.6 Inch" is displayed
    And check that product "MacBook Pro" is displayed

  Scenario: To verify products displayed on selecting Categories -> Monitors
    When user clicks on "Monitors" under Categories
    Then check that product "Apple monitor 24" is displayed
    And check that product "ASUS Full HD" is displayed
