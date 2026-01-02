package com.co.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Represents the dates of a booking. */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingDates {
    /** The check-in date. */
    @JsonProperty("checkin")
    private String checkin;

    /** The check-out date. */
    @JsonProperty("checkout")
    private String checkout;
}
