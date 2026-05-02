package com.obi.gestiondesstock.lignevente.infrastructure.mapper;

import com.obi.gestiondesstock.article.domain.entity.Article;
import com.obi.gestiondesstock.article.infrastructure.mapper.ArticleMapper;
import com.obi.gestiondesstock.lignevente.application.dto.LigneVenteRequestDto;
import com.obi.gestiondesstock.lignevente.application.dto.LigneVenteResponseDto;
import com.obi.gestiondesstock.lignevente.domain.entity.LigneVente;
import com.obi.gestiondesstock.ventes.domain.entity.Ventes;
import com.obi.gestiondesstock.ventes.infrastructure.mapper.VentesMapper;

public class LigneVenteMapper {
    //entity --> dto
    public static LigneVenteResponseDto toResponseDto(LigneVente ligneVente){
        return new LigneVenteResponseDto(
                ligneVente.getId(),
                VentesMapper.toResponseDto(ligneVente.getVente()),
                ArticleMapper.toResponseDto(ligneVente.getArticle()),
                ligneVente.getQuantite(),
                ligneVente.getPrixUnitaire(),
                ligneVente.getIdEntreprise()
        );
    }

    //dto --> entity
    public static LigneVente toEntity(LigneVenteRequestDto dto){
        return LigneVente.builder()
                //transformer l'idVente en objet de ventes
                .vente(Ventes.builder().id(dto.idVente()).build())
                //transformer l'idArticle en objet article
                .article(Article.builder().id(dto.idArticle()).build())
                .quantite(dto.quantite())
                .prixUnitaire(dto.prixUnitaire())
                .idEntreprise(dto.idEntreprise())
                .build();
    }
}
