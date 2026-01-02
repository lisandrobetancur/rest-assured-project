package com.co.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/** Represents an authentication request. */
@Builder
@Data
public class AuthRequest {
    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;
}
