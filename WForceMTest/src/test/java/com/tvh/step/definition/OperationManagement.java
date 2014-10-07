package com.tvh.step.definition;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;

import com.tvh.test.driver.SharedDriver;
import com.tvh.test.locators.General;
import com.tvh.test.locators.OperationPageElements;
import com.tvh.test.pages.Login;
import com.tvh.test.pages.OperationTypePageMap;
import com.tvh.test.pages.RandomizeNumber;
import com.tvh.test.pages.SeleniumWebdriver;
import com.tvh.test.pages.SeleniumWebdriver.Locators;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class OperationManagement extends OperationTypePageMap {
	
public OperationManagement(SharedDriver webDriver){
	super(webDriver);
	
}


@Given("^Open wfm application as an admin$") 
public void Open_wfm_application_as_an_admin() throws Throwable {

   Login.loginAsAdmin(webDriver);
    
}


@Given("^GoTo Operation Type page$")
public void GoTo_Operation_Type_page() throws Throwable {
    
	OpenOperationPage();
}

@Then("^Search screen are displayed and results panel are displayed$")
public void Search_screen_are_displayed_and_results_panel_are_displayed() throws Throwable {
   
	CheckIfOperationPageIsOpened();
	
}

@When("^Click on AddOperationType button$")
public void Click_on_AddOperationType_button() throws Throwable {
	
	SeleniumWebdriver.click(Locators.xpath, OperationPageElements.AddOperationTypeButtonXpath, webDriver);
	
}

@Then("^AddOperationType modal window is opened$")
public void AddOperationType_modal_window_is_opened() throws Throwable {
	
	SeleniumWebdriver.wait(2);
	SeleniumWebdriver.waitForElementDisplayed(Locators.xpath, OperationPageElements.AddOperationTypeModalWindowByXpath, webDriver);
	
   
}

@When("^I will try to save with no field filled$")
public void I_will_try_to_save_with_no_field_filled() throws Throwable {
	
	clickOnSaveButton();
	
}

@Then("^Erro message will be displayed$")
public void Erro_message_will_be_displayed() throws Throwable {
	 
		assertEquals("Field 'Description' is required.", webDriver.findElement(By.xpath(General.ErrorClearBox1ByXpath)).getText());
			
		assertEquals("Field 'Factor' is required.", webDriver.findElement(By.xpath(General.ErrorClearBox2ByXpath)).getText());

}

@When("^I will fill all operation type fileds$")
public void I_will_fill_all_operation_type_fileds() throws Throwable {
    
	FillOperationTypeFieldsAsProductiveOperation();
		
}

@When("^I will click on save button to save OperationType$")
public void I_will_click_on_save_button_to_save_OperationType() throws Throwable {
    
	clickOnSaveButton();
	
	addOperationTypeButton();
	
	FillOperationTypeFieldsAsNonproductiveOperation();
	
	clickOnSaveButton();
}

@When("^I will test operationType search Filter$")
public void I_input_value_on_seach_operation_type_search_box() throws Throwable {
    SearchProductiveOperationType();
    //reset the filter
    	ClickOnResetBytton();
    	SearchNPOperationType();
    ClickOnResetBytton();
	
}
@Then("^I will test edit operation type$")
public void I_will_test_edit_operation_type() throws Throwable {
	 SearchProductiveOperationType();
	    EditProductiveOperationType();
	 // check if operation type was modified
		 CheckIfOperationTypeWasModifyed();
		 ClickOnResetBytton();
		 SearchNPOperationType();
	EditNonProductiveOperationType();	 
	 	 CheckIfNonProductiveOperationTypeWasModifyed();
	 	 ClickOnResetBytton();
}


{
   
	try {
		RandomizeNumber.WriteFile(RandomizeNumber.FileReader()+ 1);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
}



}
