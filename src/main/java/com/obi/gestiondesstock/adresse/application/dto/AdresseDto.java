package com.obi.gestiondesstock.adresse.application.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record AdresseDto(

        @NotEmpty(message = "l'adresse1 est obligatoire")
        String adresse1,

        String adresse2,

        String ville,

        String codePostale,

        String pays
) {}
