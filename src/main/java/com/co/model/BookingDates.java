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
    @JsonProperty("checkin")
    private String checkin;

    @JsonProperty("checkout")
    private String checkout;
}
