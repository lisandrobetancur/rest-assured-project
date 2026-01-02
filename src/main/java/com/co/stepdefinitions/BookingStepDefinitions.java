package com.co.stepdefinitions;

import com.co.steps.BookingStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

/** Step definitions for the booking feature. */
public class BookingStepDefinitions {

    @Steps BookingStep booking;

    /**
     * Logs into the restful-booker application.
     *
     * @param username The username to use for login.
     * @param password The password to use for login.
     */
    @Given("I logged into restful-booker with {string} and {string}")
    public void loggedWithUsernameAndPassword(String username, String password) {
        booking.login(username, password);
    }

    /**
     * Retrieves a booking by its ID.
     *
     * @param bookingId The ID of the booking to retrieve.
     */
    @When("get the booking with ID {int}")
    public void getTheBookingWithId(int bookingId) {
        booking.searchBooking(bookingId);
    }

    /**
     * Updates the first name and last name of a booking.
     *
     * @param firstname The new first name.
     * @param lastname The new last name.
     */
    @Then("updated the new firstname and lastname as {string} and {string}")
    public void updateFirstnameAndLastName(String firstname, String lastname) {
        booking.updateFirstnameAndLastName(firstname, lastname);
    }
}
