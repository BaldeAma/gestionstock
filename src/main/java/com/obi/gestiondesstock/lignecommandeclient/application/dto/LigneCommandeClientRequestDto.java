package com.obi.gestiondesstock.lignecommandeclient.application.dto;

import com.obi.gestiondesstock.article.application.dto.ArticleRequestDto;
import com.obi.gestiondesstock.commandeclient.application.dto.CommandeClientRequestDto;

import java.math.BigDecimal;

public record LigneCommandeClientRequestDto(

        ArticleRequestDto article,

        CommandeClientRequestDto commandeClient,

        BigDecimal quantite,

        BigDecimal prixUnitaire,

        Integer idEntreprise
) {
}
