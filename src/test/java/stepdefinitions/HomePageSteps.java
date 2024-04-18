package stepdefinitions;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.DriverFactory;
import pages.HomePage;

public class HomePageSteps {
 HomePage homePage =  new HomePage(DriverFactory.getPage());
	@Given("I go to demo")
	public void i_go_to_demoqa() {
		homePage.navigateToUrl("https://demo.automationtesting.in/Index.html");
	}

	@When("I want to register a new account")
	public void i_go_register_form() {
		homePage.clickRegisterBtn();
	}
	
	@When("I enter to register form")
	public void i_go_to_register_form() {
		homePage.navigateToUrl("https://demo.automationtesting.in/Register.html");
	}
	
	
	@Then("I am at register form")
	public void i_am_at_form() {
		assertEquals("Register",homePage.getPageTitle()) ;
	}

}
