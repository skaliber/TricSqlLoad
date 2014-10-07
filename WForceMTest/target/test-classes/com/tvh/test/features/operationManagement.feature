Feature: Operation Type page
In this suite will be covers all functional tests defined for Operation Type page



    @operationManagement
    Scenario: Test operation type page as an admin
    
    Given Open wfm application as an admin 
    Then GoTo Operation Type page
    Then Search screen are displayed and results panel are displayed
    
    When  Click on AddOperationType button
    Then  AddOperationType modal window is opened
    When I will try to save with no field filled
    Then Erro message will be displayed
    When I will fill all operation type fileds
    And I will click on save button to save OperationType
    
    When  I will test operationType search Filter
    Then I will test edit operation type
  
   
