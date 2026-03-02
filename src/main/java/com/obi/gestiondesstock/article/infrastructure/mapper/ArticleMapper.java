package com.obi.gestiondesstock.article.infrastructure.mapper;

import com.obi.gestiondesstock.article.application.dto.ArticleRequestDto;
import com.obi.gestiondesstock.article.application.dto.ArticleResponseDto;
import com.obi.gestiondesstock.article.domain.entity.Article;
import com.obi.gestiondesstock.category.domain.entity.Category;

public class ArticleMapper {
    public static Article toEntity(ArticleRequestDto dto) {

        return Article.builder()
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

        return new ArticleResponseDto(
                article.getId(),
                article.getCodeArticle(),
                article.getDesignation(),
                article.getPrixUnitaireHt(),
                article.getTauxTva(),
                article.getPrixUnitaireTtc(),
                article.getPhoto(),
                article.getIdEntreprise(),
                article.getCategory() != null ? article.getCategory().getId() : null,
                article.getCategory() != null ? article.getCategory().getCode() : null,
                article.getCategory() != null ? article.getCategory().getDesignation() : null
        );
    }
}
