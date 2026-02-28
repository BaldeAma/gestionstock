package com.obi.gestiondesstock.utilisateur.application.dto;

import com.obi.gestiondesstock.adresse.application.dto.AdresseDto;
import com.obi.gestiondesstock.entreprise.application.dto.EntrepriseRequestDto;
import com.obi.gestiondesstock.roles.application.dto.RolesRequestDto;

import java.time.Instant;
import java.util.List;

public record UtilisateurRequestDto(

        String nom,

        String prenom,

        String email,

        Instant dateDeNaissance,

        String moteDePasse,

        AdresseDto adresse,

        String photo,

        EntrepriseRequestDto entreprise,

        List<RolesRequestDto> roles
) {
}
