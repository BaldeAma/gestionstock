package com.obi.gestiondesstock.entreprise.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.obi.gestiondesstock.adresse.application.dto.AdresseDto;
import com.obi.gestiondesstock.utilisateur.application.dto.UtilisateurResponseDto;

import java.util.List;

public record EntrepriseResponseDto(

        Integer id,

        String nom,

        String description,

        AdresseDto adresse,

        String codeFiscal,

        String photo,

        String email,

        String numTel,

        String steWeb,

        @JsonIgnore
        List<UtilisateurResponseDto> utilisateurs
) {}
