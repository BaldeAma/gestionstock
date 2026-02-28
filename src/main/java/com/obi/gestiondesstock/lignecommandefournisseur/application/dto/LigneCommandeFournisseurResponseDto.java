package com.obi.gestiondesstock.lignecommandefournisseur.application.dto;

import com.obi.gestiondesstock.article.application.dto.ArticleResponseDto;
import com.obi.gestiondesstock.commandefournisseur.application.dto.CommandeFournisseurResponseDto;

import java.math.BigDecimal;

public record LigneCommandeFournisseurResponseDto(

        Integer id,

        ArticleResponseDto article,

        CommandeFournisseurResponseDto commandeFournisseur,

        BigDecimal quantite,

        BigDecimal prixUnitaire,

        Integer idEntreprise

) {
}
