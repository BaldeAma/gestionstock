package com.obi.gestiondesstock.article.infrastructure.mapper;

import com.obi.gestiondesstock.article.application.dto.ArticleRequestDto;
import com.obi.gestiondesstock.article.application.dto.ArticleResponseDto;
import com.obi.gestiondesstock.article.domain.entity.Article;
import com.obi.gestiondesstock.category.domain.entity.Category;

public class ArticleMapper {
    public static Article toEntity(ArticleRequestDto dto) {

        return Article.builder()
                .id(dto.id())
                .codeArticle(dto.codeArticle())
                .designation(dto.designation())
                .prixUnitaireHt(dto.prixUnitaireHt())
                .tauxTva(dto.tauxTva())
                .prixUnitaireTtc(dto.prixUnitaireTtc())
                .photo(dto.photo())
                .idEntreprise(dto.idEntreprise())
                .build();
    }

    public static ArticleResponseDto toResponseDto(Article article) {

        if(article ==null){
            return null;
        }

        Category category=article.getCategory();

        return new ArticleResponseDto(
                article.getId(),
                article.getCodeArticle(),
                article.getDesignation(),
                article.getPrixUnitaireHt(),
                article.getTauxTva(),
                article.getPrixUnitaireTtc(),
                article.getPhoto(),
                article.getIdEntreprise(),
                //donnée category
                //on verifie que l'objet category n'est pas null, on recupere l'id, sinon on retourne null
                //article.getCategory() != null ? article.getCategory().getId() : null,
                //article.getCategory() != null ? article.getCategory().getCode() : null,
                //article.getCategory() != null ? article.getCategory().getDesignation() : null
                category != null ? category.getId() : null,
                category != null ? category.getCode() : null,
                category != null ? category.getDesignation() : null
        );
    }
}
