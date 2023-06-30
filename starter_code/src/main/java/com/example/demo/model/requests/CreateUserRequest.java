package com.example.demo.model.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateUserRequest {

    @JsonProperty
    private String username;

    public String getUsername() {
        return username;
    }

    @JsonProperty
    private String confirmPassword;
}
