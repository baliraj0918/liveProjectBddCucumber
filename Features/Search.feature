#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Search customer
@smoke
Scenario: search customer
Given User Lunch Chrome Browser
    When User Opens URL "http://admin-demo.nopcommerce.com/login"
    And Users enter Email as "admin@yourstore.com"and password as"admin"
    And Click on login
     Then user can view Dashboad
     When user click on customers menu
     And click on customers menu Item 
     And Enter customer email
     When click on search button
     Then user should found email in the search table
    And Close browser
