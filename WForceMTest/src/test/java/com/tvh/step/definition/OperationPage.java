package com.tvh.step.definition;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;

import com.tvh.test.driver.SharedDriver;
import com.tvh.test.locators.General;
import com.tvh.test.pages.Login;
import com.tvh.test.pages.OperationPageMap;
import com.tvh.test.pages.RandomizeNumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OperationPage extends OperationPageMap {

public OperationPage(SharedDriver webDriver){
	super(webDriver);
	
}
	
	@Given("^Open wfm application as an admin in order to test OperationPage$")
	public void Open_wfm_application_as_an_admin_in_order_to_test_OperationPage() throws Throwable {
	   
		  Login.loginAsAdmin(webDriver);
		  
	}

	@When("^i will click on operation page link$")
	public void i_will_click_on_operation_page_link() throws Throwable {
	    
		OpenoperationPage();
	  
	}
	
	@Then("^I will check if operation page is opened$")
	public void I_will_check_if_operation_page_is_opened() throws Throwable {
	   
		  assertEquals("TVH - WFM - Operation Page", webDriver.getTitle());
	}

	@When("^i click on Add operation button$")
	public void i_click_on_Add_operation_button() throws Throwable {
	   
		AddOperationButton();
	}

	@Then("^Add operation modal window is opened$")
	public void Add_operation_modal_window_is_opened() throws Throwable {
	   
		CheckIFAddOperationModalWindowIsOpened();
		
	}

	@When("^i Try to click on save button with no fields filled$")
	public void i_Try_to_click_on_save_button_with_no_fields_filled() throws Throwable {
		
		ClickOnSaveButton();
	    
	}

	@Then("^I will receive an error message$")
	public void I_will_receive_an_error_message() throws Throwable {
	   
		assertEquals("Field 'Short description' is required.", webDriver.findElement(By.xpath(General.ErrorClearBox1ByXpath)).getText());
		
		assertEquals("Field 'Description' is required.", webDriver.findElement(By.xpath(General.ErrorClearBox2ByXpath)).getText());
		
		assertEquals("Field 'Operation type' is required.", webDriver.findElement(By.xpath(General.ErrorClearBox3ByXpath)).getText());
	}

	@When("^i will fill operation description and shoprt description filed$")
	public void i_will_fill_operation_description_and_shoprt_description_filed() throws Throwable {
	   
		FillOperationDescriptionAndShoprtdescription();
	}

	@When("^I will look after and operation type and i will select it$")
	public void I_will_look_after_and_operation_type_and_i_will_select_it() throws Throwable {
		
		SelectOperationType();
	    
	}

	@When("^i will look after an external link and i will select it$")
	public void i_will_look_after_an_external_link_and_i_will_select_it() throws Throwable {
	   
	    SelectExternalLink();
	    
	}

	@When("^i will save the operation$")
	public void i_will_save_the_operation() throws Throwable {
	   
	    ClickOnSaveButton();
	}

	@When("^i will test search filter from operation page$")
	public void i_will_test_search_filter_from_operation_page() throws Throwable {
	   
		SearchAValidOperationName();
			ClickOnSearchButton();
		CheckIfOperationWasFound();
			ClickOnResetButton();	
		SearchAnInValidOperationName();
			ClickOnSearchButton();
		CheckIfNoResultsFoundMessageApear();
			ClickOnResetButton();
		
	}

	@When("^i will try to edit the operation that was created before$")
	public void i_will_try_to_edit_the_operation_that_was_created_before() throws Throwable {
		SearchAValidOperationName();
			ClickOnSearchButton();
			EditProductiveOperation();
			ClickOnSaveButton();
			SearchAfterOperationRenamed();
			ClickOnSearchButton();
			CheckIfOperationWasModified();
			ClickOnResetButton();
	}
	{
	 
		try {
			RandomizeNumber.WriteFile(RandomizeNumber.FileReader()+ 1);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	
}
