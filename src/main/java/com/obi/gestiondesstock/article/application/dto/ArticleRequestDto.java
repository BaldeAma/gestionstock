package com.obi.gestiondesstock.article.application.dto;

import com.obi.gestiondesstock.category.application.dto.CategoryRequestDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ArticleRequestDto (
        // pour creer / modifier

        @NotNull(message = "Le code article est obligatoire")
        String codeArticle,

        @NotBlank(message = "La designation est obligatoire")
        String designation,

        @NotNull(message = "Le prixUnitaireHt est obligatoire")
        @Positive(message = "Le prixUnitaireHt doit être positif")
        BigDecimal prixUnitaireHt,

        BigDecimal tauxTva,

        BigDecimal prixUnitaireTtc,

        String photo,

        CategoryRequestDto category,

        @NotNull(message = "Le idEntreprise est obligatoire")
        Integer idEntreprise
){}
