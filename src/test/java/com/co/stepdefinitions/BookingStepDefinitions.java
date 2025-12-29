package com.co.stepdefinitions;

import com.co.steps.BookingStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class BookingStepDefinitions {

    @Steps BookingStep booking;

    @Given("I logged into restful-booker with {string} and {string}")
    public void theUserIsAuthorized(String username, String password) {
        booking.login(username, password);
    }

    @When("the user authenticates with {string} and {string}")
    public void authenticate(String user, String pass) {}

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int statusCode) {}
}
