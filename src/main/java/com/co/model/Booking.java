package com.co.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Represents a booking. */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Booking {
    /** The first name of the person who made the booking. */
    @JsonProperty("firstname")
    private String firstName;

    /** The last name of the person who made the booking. */
    @JsonProperty("lastname")
    private String lastName;

    /** The total price of the booking. */
    @JsonProperty("totalprice")
    private int totalPrice;

    /** Whether a deposit has been paid for the booking. */
    @JsonProperty("depositpaid")
    private boolean depositPaid;

    /** The dates of the booking. */
    @JsonProperty("bookingdates")
    private BookingDates bookingDates;

    /** Any additional needs for the booking. */
    @JsonProperty("additionalneeds")
    private String additionalNeeds;
}
