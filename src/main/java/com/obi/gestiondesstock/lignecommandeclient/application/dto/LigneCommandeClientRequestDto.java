package com.obi.gestiondesstock.lignecommandeclient.application.dto;

import com.obi.gestiondesstock.article.application.dto.ArticleRequestDto;
import com.obi.gestiondesstock.commandeclient.application.dto.CommandeClientRequestDto;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record LigneCommandeClientRequestDto(

        @NotNull(message = "L' Id est obligatoire")
        Integer id,

        ArticleRequestDto article,

        CommandeClientRequestDto commandeClient,

        BigDecimal quantite,

        BigDecimal prixUnitaire,

        Integer idEntreprise
) {
}
