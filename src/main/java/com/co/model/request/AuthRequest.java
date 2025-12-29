package com.co.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthRequest {
    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;
}
