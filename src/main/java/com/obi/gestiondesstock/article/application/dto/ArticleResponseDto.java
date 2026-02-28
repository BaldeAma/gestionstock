package com.obi.gestiondesstock.article.application.dto;

import java.math.BigDecimal;

public record ArticleResponseDto(
        //pour retourner au client
        Integer id,

        String codeArticle,

        String designation,

        BigDecimal prixUnitaireHt,

        BigDecimal tauxTva,

        BigDecimal prixUnitaireTtc,

        String photo,

        Integer idEntreprise,

        // Infos utiles de la catégorie
        Integer categoryId,

        String categoryCode,

        String categoryDesignation
) {
}
