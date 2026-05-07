package com.obi.gestiondesstock.lignecommandeclient.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.obi.gestiondesstock.article.application.dto.ArticleRequestDto;
import com.obi.gestiondesstock.commandeclient.application.dto.CommandeClientRequestDto;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record LigneCommandeClientRequestDto(

        //@NotNull(message = "L' Id est obligatoire")
        Integer id,

        //ArticleRequestDto article,
        @NotNull(message = "L' idArticle est obligatoire")
        Integer idArticle,

        //@JsonIgnore
        //CommandeClientRequestDto commandeClient,
        Integer idCommandeClient,

        @NotNull(message = "La quantite est obligatoire")
        BigDecimal quantite,

        @NotNull(message = "le prix unitaire est obligatoire")
        BigDecimal prixUnitaire,

        Integer idEntreprise
) {}
