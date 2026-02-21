package com.obi.gestiondesstock.commandefournisseur.application.dto;

import com.obi.gestiondesstock.common.domain.enums.EtatCommande;
import com.obi.gestiondesstock.fournisseur.application.dto.FournisseurRequestDto;
import com.obi.gestiondesstock.lignecommandefournisseur.application.dto.LigneCommandeFournisseurRequestDto;

import java.time.Instant;
import java.util.List;

public record CommandeFournisseurRequestDto(

        String code,

        Instant dateCommande,

        EtatCommande etatCommande,

        FournisseurRequestDto fournisseur,

        Integer idEntreprise,

        List<LigneCommandeFournisseurRequestDto> ligneCommandeFournisseurs
) {
}
