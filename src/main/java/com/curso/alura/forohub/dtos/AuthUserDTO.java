package com.curso.alura.forohub.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

/**
 * @author Soriano
 */
public record AuthUserDTO(
        @JsonProperty("userName")
        @NotBlank
        String userName,

        @JsonProperty("password")
        @NotBlank
        String password
) {
}
