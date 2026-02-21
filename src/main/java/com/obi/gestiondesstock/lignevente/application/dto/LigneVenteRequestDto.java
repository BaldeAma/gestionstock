package com.obi.gestiondesstock.lignevente.application.dto;

import com.obi.gestiondesstock.article.application.dto.ArticleRequestDto;
import com.obi.gestiondesstock.vente.application.dto.VentesRequestDto;

import java.math.BigDecimal;

public record LigneVenteRequestDto(

        VentesRequestDto vente,

        ArticleRequestDto article,

        BigDecimal quantite,

        BigDecimal prixUnitaire,

        Integer idEntreprise
) {
}
