package stepdefinitions;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScenarioAbcSteps {
	// create test + log , attach images
	@Given("I want to write a step with precondition")
	public void i_want_to_write_a_step_with_precondition() {
		System.out.println("gergrege");
	}
	@When("I complete action")
	public void i_complete_action() {
	}
	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
		assertTrue(true);
	}
	@Then("I validate the wrong outcomes")
	public void i_validate_the_2_outcomes() {
		assertTrue(false);
		
	}

	@Given("I want to write a step with name1")
	public void i_want_to_write_a_step_with_name1() {
	    System.out.println("fawawf wegweg gewgwegw");
	}
	@When("I check for the {int} in step")
	public void i_check_for_the_in_step(Integer int1) {
	    assertTrue(int1.equals(5));
	}
	@Then("I verify the {string} in step")
	public void i_verify_the_success_in_step(String expectText) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
