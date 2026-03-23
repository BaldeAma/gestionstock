package com.obi.gestiondesstock.article.application.dto;

import com.obi.gestiondesstock.category.application.dto.CategoryRequestDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ArticleRequestDto (
        // pour creer / modifier

        @NotNull(message = "L'id est obligatoire")
        Integer id,

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

        @NotNull(message = "La catégorie est obligatoire")
        Integer categoryId,

        @NotNull(message = "Le idEntreprise est obligatoire")
        Integer idEntreprise
){}
