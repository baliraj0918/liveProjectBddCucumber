Feature: Customers
@regression
Scenario: Add new customer
Given User Lunch Chrome Browser
    When User Opens URL "http://admin-demo.nopcommerce.com/login"
    And Users enter Email as "admin@yourstore.com"and password as"admin"
    And Click on login
     Then user can view Dashboad
     When user click on customers menu
     And click on customers menu Item 
     And click on add new button
     Then user can view add new customer page
     When user enter customer info
     And click on save button
     Then user can view confirmation message "The new customer has been added sucessfully"
    And Close browser
    
 #Scenario: Add new customer
#Given User Lunch Chrome Browser
    #When User Opens URL "http://admin-demo.nopcommerce.com/login"
    #And Users enter Email as "admin@yourstore.com"and password as"admin"
    #And Click on login
     #Then user can view Dashboad
     #When user click on customers menu
     #And click on customers menu Item 
     #And Enter customer email
     #When click on search button
     #Then user should found email in the search table
    #And Close browser
