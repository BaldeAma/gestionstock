package com.obi.gestiondesstock.entreprise.application.dto;

import com.obi.gestiondesstock.adresse.application.dto.AdresseRequestDto;
import com.obi.gestiondesstock.utilisateur.application.dto.UtilisateurRequestDto;

import java.util.List;

public record EntrepriseRequestDto(

        String nom,

        String description,

        AdresseRequestDto adresse,

        String codeFiscal,

        String photo,

        String email,

        String numTel,

        String steWeb,


        List<UtilisateurRequestDto> utilisateurs
) {
}
