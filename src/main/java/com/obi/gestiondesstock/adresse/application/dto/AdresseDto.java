package com.obi.gestiondesstock.adresse.application.dto;

import lombok.Builder;

@Builder
public record AdresseDto(

        String adresse1,

        String adresse2,

        String ville,

        String codePostale,

        String pays
) {}
