package com.obi.gestiondesstock.lignevente.application.dto;

import com.obi.gestiondesstock.article.application.dto.ArticleResponseDto;
import com.obi.gestiondesstock.ventes.application.dto.VentesResponseDto;

import java.math.BigDecimal;

public record LigneVenteResponseDto(

        Integer id,

        //VentesResponseDto vente,
        Integer idVente,

        //ArticleResponseDto article,
        Integer idArticle,

        BigDecimal quantite,

        BigDecimal prixUnitaire,

        Integer idEntreprise
) {
}
