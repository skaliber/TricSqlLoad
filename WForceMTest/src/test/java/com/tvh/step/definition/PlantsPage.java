package com.tvh.step.definition;

import java.io.IOException;

import com.tvh.test.driver.SharedDriver;
import com.tvh.test.pages.Login;
import com.tvh.test.pages.PlantsPageMap;
import com.tvh.test.pages.RandomizeNumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class PlantsPage extends PlantsPageMap{

	public PlantsPage(SharedDriver webDriver){
		
		super(webDriver);
		
	}
	
	@Given("^Open WFM as an admin user in order to test Plants  page$")
	public void Open_WFM_as_an_admin_user_in_order_to_test_Plants_page() throws Throwable {
	   
		Login.loginAsAdmin(webDriver);
		
		
	}

	@Then("^i will create a new plant$")
	public void i_will_create_a_new_plant() throws Throwable {
		
		openPlantPage();
		checkifPlantPageIsOpened();
		
		
	}

	@Then("^i will search for the new created plant$")
	public void i_will_search_for_the_new_created_plant() throws Throwable {
	    
	}

	@Then("^i will search for a not created plant$")
	public void i_will_search_for_a_not_created_plant() throws Throwable {
	  
	}

	@Then("^i will go to edit move time with valid data$")
	public void i_will_go_to_edit_move_time_with_valid_data() throws Throwable {
	 
	}

	@Then("^i will edit move time with invalid data$")
	public void i_will_edit_move_time_with_invalid_data() throws Throwable {
	   
	}

	@Then("^i will go back and i will reset the filter$")
	public void i_will_go_back_and_i_will_reset_the_filter() throws Throwable {
	    
	}

	@Then("^i will assign a company to a plant$")
	public void i_will_assign_a_company_to_a_plant() throws Throwable {
	   
	}

	@Then("^i will try to assign the same company again$")
	public void i_will_try_to_assign_the_same_company_again() throws Throwable {
	  
	}

	@Then("^i will removed assigned company$")
	public void i_will_removed_assigned_company() throws Throwable {
	 
	}
	
	
	{
		try {
			RandomizeNumber.WriteFile(RandomizeNumber.FileReader()+ 1);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
}
}
