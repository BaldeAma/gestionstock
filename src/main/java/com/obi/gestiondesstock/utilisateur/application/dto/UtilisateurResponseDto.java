package com.obi.gestiondesstock.utilisateur.application.dto;

import com.obi.gestiondesstock.adresse.application.dto.AdresseDto;
import com.obi.gestiondesstock.entreprise.application.dto.EntrepriseRequestDto;
import com.obi.gestiondesstock.entreprise.application.dto.EntrepriseResponseDto;
import com.obi.gestiondesstock.roles.application.dto.RolesRequestDto;
import com.obi.gestiondesstock.roles.application.dto.RolesResponseDto;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;
import java.util.List;

public record UtilisateurResponseDto(

        @NotEmpty(message = "le Nom est obligatoir")
        String nom,

        @NotEmpty(message = "le prenom est obligatoir")
        String prenom,

        @NotEmpty(message = "l'email est obligatoire")
        String email,

        Instant dateDeNaissance,

        String moteDePasse,

        AdresseDto adresse,

        String photo,

        EntrepriseResponseDto entreprise,

        List<RolesResponseDto> roles
) {
}
