package com.obi.gestiondesstock.article.web.controller;

import com.obi.gestiondesstock.article.application.dto.ArticleRequestDto;
import com.obi.gestiondesstock.article.application.dto.ArticleResponseDto;
import com.obi.gestiondesstock.article.application.service.impl.ArticleServiceImpl;
import com.obi.gestiondesstock.article.web.controller.api.ArticleApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleController implements ArticleApi {

    /*
    Si tu veux contrôler le statut HTTP → utilise ResponseEntity
    Sinon → retourne directement l’objet
     */

    private final ArticleServiceImpl articleService;

    @Override
    public ResponseEntity<ArticleResponseDto> save(ArticleRequestDto dto) {

        ArticleResponseDto response=articleService.save(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @Override
    public ResponseEntity<ArticleResponseDto> findById(Integer id) {
        ArticleResponseDto response =articleService.findById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ArticleResponseDto> findByCodeArticle(String codeArticle) {

        ArticleResponseDto response = articleService.findByCodeArticle(codeArticle);

        return ResponseEntity.ok(response);

    }

    @Override
    public ResponseEntity<List<ArticleResponseDto>> findAll() {

        List<ArticleResponseDto> response = articleService.findAll();

        return ResponseEntity.ok(response);

    }

    @Override
    public ResponseEntity<Void> deleteById(Integer id) {

        articleService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
