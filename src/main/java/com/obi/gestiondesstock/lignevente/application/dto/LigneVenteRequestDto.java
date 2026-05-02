package com.obi.gestiondesstock.lignevente.application.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record LigneVenteRequestDto(

        Integer id,

        //@NotNull(message = "l' idVente est obligatoire")
        Integer  idVente,

        @NotNull(message = "l' idArticle est obligatoire")
        Integer idArticle,

        @NotNull(message = "la quantite est obligatoire")
        @Positive(message = "la quantite doit etre positive")
        BigDecimal quantite,

        @NotNull(message = "L prix unitaire est obligatoire")
        @Positive(message = "Le prix unitaire doit etre positive")
        BigDecimal prixUnitaire,

        //à identifier automatiquement
        Integer idEntreprise
) {}
