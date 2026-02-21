package com.obi.gestiondesstock.adresse.application.dto;

import jakarta.validation.constraints.NotBlank;

public record AdresseRequestDto(

        @NotBlank(message = "L' adresse 1 est obligatoire")
        String adresse1,

        String adresse2,

        @NotBlank(message = "La ville est obligatoire")
        String ville,

        @NotBlank(message = "Le code postale est obligatoire")
        String codePostale,

        @NotBlank(message = "Le pays est obligatoire")
        String pays
) {}
