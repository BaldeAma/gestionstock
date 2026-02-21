package com.obi.gestiondesstock.adresse.application.dto;

import jakarta.validation.constraints.NotBlank;

public record AdresseResponseDto(

        String adresse1,

        String adresse2,

        String ville,

        String codePostale,

        String pays
) {}
