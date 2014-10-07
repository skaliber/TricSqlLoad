Feature: Plants Management
In this suite will be covers a smoke  functional tests defined for Plant  page as an admin user



    @plantsPage
    Scenario: Test functionality from Plants  page as an admin
    
    Given Open WFM as an admin user in order to test Plants  page
    Then i will create a new plant
    And i will search for the new created plant 
    And i will search for a not created plant
    Then i will go to edit move time with valid data 
    And i will edit move time with invalid data
    Then i will go back and i will reset the filter 
    And i will assign a company to a plant 
    Then i will try to assign the same company again 
    And i will removed assigned company 
    