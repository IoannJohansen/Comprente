package com.sachishin.comprente.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    @NotBlank(message = "login must be specified")
    private String login;

    @NotBlank(message = "Password must be specified")
    private String password;
}
