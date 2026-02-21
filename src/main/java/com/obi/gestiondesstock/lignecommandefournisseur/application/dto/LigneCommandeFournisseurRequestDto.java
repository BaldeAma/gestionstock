package com.obi.gestiondesstock.lignecommandefournisseur.application.dto;

import com.obi.gestiondesstock.article.application.dto.ArticleRequestDto;
import com.obi.gestiondesstock.commandefournisseur.application.dto.CommandeFournisseurRequestDto;

import java.math.BigDecimal;

public record LigneCommandeFournisseurRequestDto(

        ArticleRequestDto article,

        CommandeFournisseurRequestDto commandeFournisseur,

        BigDecimal quantite,

        BigDecimal prixUnitaire,

        Integer idEntreprise

) {
}
