package com.sachishin.comprente.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "login must be specified")
    private String login;

    @NotBlank(message = "Password must be specified")
    private String password;

    @NotBlank(message = "Email must be specified")
    @Email(message = "Invalid email")
    private String email;
}