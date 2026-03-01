package com.obi.gestiondesstock.category.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CategoryRequestDto(

        @NotEmpty(message = "Le code de la category est obligatoire")
        @NotNull
        String code,

        String designation,

        Integer idEntreprise
) {
}
