package com.sachishin.comprente.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {
    Boolean success;
    String token;
    String username;
    long userId;
    String role;
}
