package com.obi.gestiondesstock.lignecommandeclient.application.dto;

import com.obi.gestiondesstock.article.application.dto.ArticleRequestDto;
import com.obi.gestiondesstock.commandeclient.application.dto.CommandeClientRequestDto;

import java.math.BigDecimal;

public record LigneCommandeClientResponseDto(

        Integer id,

        ArticleRequestDto article,

        CommandeClientRequestDto commandeClient,

        BigDecimal quantite,

        BigDecimal prixUnitaire,

        Integer idEntreprise
) {
}
