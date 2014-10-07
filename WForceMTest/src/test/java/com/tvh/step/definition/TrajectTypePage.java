package com.tvh.step.definition;

import java.io.IOException;

import com.tvh.test.driver.SharedDriver;
import com.tvh.test.pages.Login;
import com.tvh.test.pages.RandomizeNumber;
import com.tvh.test.pages.TrajectTypePageMap;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TrajectTypePage extends TrajectTypePageMap{
	
	public TrajectTypePage(SharedDriver webDriver){
		
		super(webDriver);
		
	}
	
	
	@Given("^Open WFM as an admin user in order to test Traject Type page$")
	public void Open_WFM_as_an_admin_user_in_order_to_test_Traject_Type_page() throws Throwable {
	   
		Login.loginAsAdmin(webDriver);
		
	}

	@When("^i will click on traject Type page lik$")
	public void i_will_click_on_traject_Type_page_lik() throws Throwable {
		
		ClickonTrajectTypePageLInk();
	}

	@Then("^Traject Type page will be opened$")
	public void Traject_Type_page_will_be_opened() throws Throwable {
		
		getTrajectTypePageTitile();
	}

	@Then("^Company filed will be empty$")
	public void Company_filed_will_be_empty() throws Throwable {
		
		CheckifcompanyfieldIsEmpty();
	}

	@When("^i clikc on Add traject type button$")
	public void i_clikc_on_Add_traject_type_button() throws Throwable {
		
		ClickonAddTrajectTypeButton();
	}

	@Then("^Add traject type modal window will be opened$")
	public void Add_traject_type_modal_window_will_be_opened() throws Throwable {
		
	   CheckIfAdDTrajectTypeModalWindowIsOpened();
	}

	@When("^i click on company lookup button$")
	public void i_click_on_company_lookup_button() throws Throwable {
		
		ClickOnCompanyLookUpButton();
	}

	@Then("^Select a company modal window will be opened and i will selected a company$")
	public void Select_a_company_modal_window_will_be_opened_and_i_will_selected_a_company() throws Throwable {
		
		SelectComapnyFromList();
	}

	@Then("^Company will be selected$")
	public void Company_will_be_selected() throws Throwable {
		
		CheckIfCompanyIsSelected();
	}

	@Then("^i will imput a description that should be unique$")
	public void i_will_imput_a_description_that_should_be_unique() throws Throwable {
	    
		InputADecsription();
	}

	@Then("^i will select a Type$")
	public void i_will_select_a_Type() throws Throwable {
		
	  SelectATypeFromList();
	}

	@When("^i will click on save button in order to save the traject type$")
	public void i_will_click_on_save_button_in_order_to_save_the_traject_type() throws Throwable {
	    
		ClickOnSaveButton();
		
	}

	

	@Then("^i will search by description to check if trajecttype was created$")
	public void i_will_search_by_description() throws Throwable {
		
		SearchForTrajectTypeAndCheckIfWasCreated();
		
	}

	
	@When("^i click on edit icon$")
	public void i_click_on_edit_icon() throws Throwable {
	
		ClickonEditIcon();
	}

	@Then("^edit traject type modal window is opened$")
	public void edit_traject_type_modal_window_is_opened() throws Throwable {
	   
		CheckIfAdDTrajectTypeModalWindowIsOpened();
		
	}

	@When("^i will renamed the traject type and i will click on save button$")
	public void i_will_renamed_the_traject_type_and_i_will_click_on_save_button() throws Throwable {
	   
		RenameTrajectType();
		ClickOnSaveButton();
		
	}

	@Then("^Traject type should be renamed$")
	public void Traject_type_should_be_renamed() throws Throwable {
	   
		CheckIfTrajectTypeWasRenamed();
	}

	@When("^i click on magnifier icon in order to edit the workordercode$")
	public void i_click_on_magnifier_icon_in_order_to_edit_the_workordercode() throws Throwable {
	  
		ClickOnMagnifierIcon();
	}

	@Then("^Default checkbox should be selected for selected traject type$")
	public void Default_checkbox_should_be_selected_for_selected_traject_type() throws Throwable {
		
		CheckIfDefaultWOCisSelected();
	}

	@When("^i click on second checkbox$")
	public void i_click_on_second_checkbox() throws Throwable {
	   
		SelectTheSecondWOC();
	}

	@Then("^a positive message apear-WOC was added$")
	public void a_positive_message_apear_WOC_was_added() throws Throwable {
	  
		CheckifWOCWasAssign();
	}

	@When("^i unselect the second checkbox$")
	public void i_unselect_the_second_checkbox() throws Throwable {
	    
		
		UnselectTheSecondWOC();
		
	}

	@Then("^Confirmation message apear WOC was removed$")
	public void Confirmation_message_apear_WOC_was_removed() throws Throwable {
	 
		CheckifWOCWasUnAssign();
		
		
	}

	@When("^i click on back to traject type button$")
	public void i_click_on_back_to_traject_type_button() throws Throwable {
	   
		ClikonBacktoTrajectButton();
	}



	@When("^i try to create a traject type withot company and description$")
	public void i_try_to_create_a_traject_type_withot_company_and_description() throws Throwable {
		
		ClickonAddTrajectTypeButton();
		CheckIfAdDTrajectTypeModalWindowIsOpened();
		ClickOnSaveButton();
		
	}

	@Then("^A validate message should be displayed that traject type cannont be created$")
	public void A_validate_message_should_be_displayed_that_traject_type_cannont_be_created() throws Throwable {
	   
		CheckErrorMessage();
		CloseAddTrajectTypeModalwindow();
		
			
	}

	@When("^i will click on reset button$")
	public void i_will_click_on_reset_button() throws Throwable {
	   
		
		clickontheresetbutton();
		
	}

	@Then("^filter should be reseted$")
	public void filter_should_be_reseted() throws Throwable {
	   
		CheckIfFilterWasReseted();
	}
	
	{
	
	
	try {
		RandomizeNumber.WriteFile(RandomizeNumber.FileReader()+ 1);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
	
	}
}
