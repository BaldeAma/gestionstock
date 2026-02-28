package com.obi.gestiondesstock.lignecommandeclient.application.dto;

import com.obi.gestiondesstock.article.application.dto.ArticleRequestDto;
import com.obi.gestiondesstock.commandeclient.application.dto.CommandeClientRequestDto;
import com.obi.gestiondesstock.commandeclient.application.dto.CommandeClientResponseDto;

import java.math.BigDecimal;

public record LigneCommandeClientResponseDto(

        Integer id,

        ArticleRequestDto article,

        CommandeClientResponseDto commandeClient,

        BigDecimal quantite,

        BigDecimal prixUnitaire,

        Integer idEntreprise
) {
}
