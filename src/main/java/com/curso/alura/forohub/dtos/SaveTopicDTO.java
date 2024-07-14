package com.curso.alura.forohub.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Soriano
 */
public record SaveTopicDTO(
        @JsonProperty("title")
        @NotBlank
        String title,

        @JsonProperty("message")
        @NotBlank
        String message,

        @JsonProperty("idUser")
        @NotNull
        long idUser,

        @JsonProperty("idCourse")
        @NotNull
        long idCourse
) {
}
