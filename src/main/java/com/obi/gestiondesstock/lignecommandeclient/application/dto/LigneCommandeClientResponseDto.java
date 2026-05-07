package com.obi.gestiondesstock.lignecommandeclient.application.dto;

import com.obi.gestiondesstock.article.application.dto.ArticleResponseDto;
import com.obi.gestiondesstock.commandeclient.application.dto.CommandeClientResponseDto;

import java.math.BigDecimal;

public record LigneCommandeClientResponseDto(

        Integer id,

        //ArticleResponseDto article,
        Integer idArticle,

        //CommandeClientResponseDto commandeClient,
        Integer idCommandeClient,

        BigDecimal quantite,

        BigDecimal prixUnitaire,

        Integer idEntreprise
) {
}
