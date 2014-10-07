Feature: workshop
In this suite will be covers all functional tests defined for workshop page as an worker/TeamLeader



    @workshop
    Scenario: Test workerUI as an worker
    
    Given Open wfm as an worker user in order to test workshop functionality
    Then i will check workerUi page title
    And I will check worker logged name
    When i click on not productive tab 
    Then I should see the not productive operation in the list
    When I click on Play icon to start a not productive operation
    Then Not productive operation shout be started
    When i click on add a comment button 
    Then Add a comment modal window whould be opened
    And I will Input a comment here and i will save it
    When  I will go to recurrent tab
    Then Recurrent operation should be displayed
    When i will try to start a recurrent operation when a not productive operation is still running
    Then Error message should be displayed
    When i will go to Available jobs tab
    Then jobs are displayed on jobs table
    When I will try to start a productive job and a not productive job is still running 
    Then An error message should be displayed
    When I will finish the current Not productive operation running
    Then Job should not be displayed on running job table
    When i click on finish Job tab in order to check if Not productive job was set executed
    Then Not productive operation should be displayed on Finished job panel
    
    