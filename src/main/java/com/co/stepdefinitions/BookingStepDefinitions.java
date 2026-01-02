package com.co.stepdefinitions;

import com.co.steps.BookingStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class BookingStepDefinitions {

    @Steps BookingStep booking;

    @Given("I logged into restful-booker with {string} and {string}")
    public void loggedWithUsernameAndPassword(String username, String password) {
        booking.login(username, password);
    }

    @When("get the booking with ID {int}")
    public void getTheBookingWithId(int bookingId) {
        booking.searchBooking(bookingId);
    }

    @Then("updated the new firstname and lastname as {string} and {string}")
    public void updateFirstnameAndLastName(String firstname, String lastname) {
        booking.updateFirstnameAndLastName(firstname, lastname);
    }
}
