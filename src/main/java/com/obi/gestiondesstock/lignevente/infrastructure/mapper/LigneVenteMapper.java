package com.obi.gestiondesstock.lignevente.infrastructure.mapper;

import com.obi.gestiondesstock.article.domain.entity.Article;
import com.obi.gestiondesstock.lignevente.application.dto.LigneVenteRequestDto;
import com.obi.gestiondesstock.lignevente.application.dto.LigneVenteResponseDto;
import com.obi.gestiondesstock.lignevente.domain.entity.LigneVente;
import com.obi.gestiondesstock.ventes.domain.entity.Ventes;


public class LigneVenteMapper {
    //entity --> dto
    public static LigneVenteResponseDto toResponseDto(LigneVente ligneVente) {
        if (ligneVente == null) {
            return null;
        }
        return new LigneVenteResponseDto(
                ligneVente.getId(),
                //VentesMapper.toResponseDto(ligneVente.getVente()),
                ligneVente.getVente() != null ? ligneVente.getVente().getId() : null,
                //ArticleMapper.toResponseDto(ligneVente.getArticle()),
                ligneVente.getArticle() != null ? ligneVente.getArticle().getId() : null,
                ligneVente.getQuantite(),
                ligneVente.getPrixUnitaire(),
                ligneVente.getIdEntreprise()
        );
    }

    //dto --> entity
    public static LigneVente toEntity(LigneVenteRequestDto dto) {
        return LigneVente.builder()
                //transformer l'idVente en objet de ventes
                .vente(dto.idVente() != null ? Ventes.builder().id(dto.idVente()).build() : null)
                //transformer l'idArticle en objet article
                .article(dto.idArticle() != null ? Article.builder().id(dto.idArticle()).build() : null)
                .quantite(dto.quantite())
                .prixUnitaire(dto.prixUnitaire())
                .idEntreprise(dto.idEntreprise())
                .build();
    }
}
