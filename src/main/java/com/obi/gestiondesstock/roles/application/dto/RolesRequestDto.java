package com.obi.gestiondesstock.roles.application.dto;

import com.obi.gestiondesstock.utilisateur.application.dto.UtilisateurRequestDto;

public record RolesRequestDto(

        String roleName,

        UtilisateurRequestDto utilisateur
) {
}
