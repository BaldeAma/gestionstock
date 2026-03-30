package com.obi.gestiondesstock.entreprise.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.obi.gestiondesstock.adresse.application.dto.AdresseDto;
import com.obi.gestiondesstock.utilisateur.application.dto.UtilisateurRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record EntrepriseRequestDto(

        Integer id,

        @NotNull(message = "le nom est obligatoire")
        String nom,

        String description,

        @Valid
        AdresseDto adresse,

        String codeFiscal,

        String photo,

        String email,

        String numTel,

        String steWeb,


        @JsonIgnore
        List<UtilisateurRequestDto> utilisateurs
) {
}
