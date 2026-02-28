package com.obi.gestiondesstock.commandefournisseur.application.dto;

import com.obi.gestiondesstock.common.domain.enums.EtatCommande;
import com.obi.gestiondesstock.fournisseur.application.dto.FournisseurResponseDto;
import com.obi.gestiondesstock.lignecommandefournisseur.application.dto.LigneCommandeFournisseurResponseDto;

import java.time.Instant;
import java.util.List;

public record CommandeFournisseurResponseDto(

        Integer id,

        String code,

        Instant dateCommande,

        EtatCommande etatCommande,

        FournisseurResponseDto fournisseur,

        Integer idEntreprise,

        List<LigneCommandeFournisseurResponseDto> ligneCommandeFournisseurs
) {
}
