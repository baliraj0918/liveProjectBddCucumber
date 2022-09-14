Feature: Login
@sanity
  Scenario: Succesfull Login With Valid Credentials
    Given User Lunch Chrome Browser
    When User Opens URL "http://admin-demo.nopcommerce.com/login"
    And Users enter Email as "admin@yourstore.com"and password as"admin"
    And Click on login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on log out link 
    Then Page title should be "Your store. Login"
    And Close browser
@regression    
  Scenario Outline:  Login data driven
    Given User Lunch Chrome Browser
    When User Opens URL "http://admin-demo.nopcommerce.com/login"
    And Users enter Email as "<email>"and password as"<password>"
    And Click on login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on log out link 
    Then Page title should be "Your store. Login"
    And Close browser
    
    Examples:
  |email |password |
  |admin@yourstore.com|admin|
  |admin@yourstore.com|admin123|
