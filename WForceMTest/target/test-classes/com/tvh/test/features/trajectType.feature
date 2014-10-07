Feature: trajectType
In this suite will be covers all functional tests defined for TrajectType page as an Admin User



    @trajectTypePage
    Scenario: Test functionality from traject type page as an admin
    
    Given Open WFM as an admin user in order to test Traject Type page
    When i will click on traject Type page lik 
    Then Traject Type page will be opened
    And  Company filed will be empty
    When i clikc on Add traject type button 
    Then Add traject type modal window will be opened 
    When i click on company lookup button 
    Then Select a company modal window will be opened and i will selected a company 
    And Company will be selected
    And i will imput a description that should be unique 
    And i will select a Type 
    When i will click on save button in order to save the traject type
    
    Then i will search by description to check if trajecttype was created
   
    When i click on edit icon 
    Then edit traject type modal window is opened 
    When i will renamed the traject type and i will click on save button 
    Then Traject type should be renamed
    When i click on magnifier icon in order to edit the workordercode 
    Then Default checkbox should be selected for selected traject type
    When i click on second checkbox 
    Then a positive message apear-WOC was added
    When i unselect the second checkbox 
    Then Confirmation message apear WOC was removed
    When i click on back to traject type button 
  
    When i try to create a traject type withot company and description 
    Then A validate message should be displayed that traject type cannont be created
    When i will click on reset button 
    Then filter should be reseted
    