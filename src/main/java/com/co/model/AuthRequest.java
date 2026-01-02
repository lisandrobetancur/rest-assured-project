package com.co.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/** Represents an authentication request. */
@Builder
@Data
public class AuthRequest {
    /** The username for authentication. */
    @JsonProperty("username")
    private String username;

    /** The password for authentication. */
    @JsonProperty("password")
    private String password;
}
