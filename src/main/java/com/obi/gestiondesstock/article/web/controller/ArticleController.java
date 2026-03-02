package com.obi.gestiondesstock.article.web.controller;

import com.obi.gestiondesstock.article.application.dto.ArticleRequestDto;
import com.obi.gestiondesstock.article.application.dto.ArticleResponseDto;
import com.obi.gestiondesstock.article.web.controller.api.ArticleApi;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ArticleController implements ArticleApi {
    @Override
    public ResponseEntity<ArticleResponseDto> save(ArticleRequestDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<ArticleResponseDto> findById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<ArticleResponseDto> findByCodeArticle(String codeArticle) {
        return null;
    }

    @Override
    public ResponseEntity<List<ArticleResponseDto>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteById(Integer id) {
        return null;
    }
}
