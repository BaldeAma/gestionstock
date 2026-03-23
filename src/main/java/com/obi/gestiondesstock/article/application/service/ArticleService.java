package com.obi.gestiondesstock.article.application.service;

import com.obi.gestiondesstock.article.application.dto.ArticleRequestDto;
import com.obi.gestiondesstock.article.application.dto.ArticleResponseDto;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    //definition des methodes de base

    //save
    public ArticleResponseDto save(ArticleRequestDto dto);

    //findById
    public  ArticleResponseDto findById (Integer id);

    //fingByCodeArticle
    public ArticleResponseDto findByCodeArticle (String codeArticle);

    //findAll -->liste des articles
    public List<ArticleResponseDto> findAll();

    //delete
    public void deleteById (Integer id);

    public List<ArticleResponseDto> findAllByCategoryId (Integer idCategory);

}
