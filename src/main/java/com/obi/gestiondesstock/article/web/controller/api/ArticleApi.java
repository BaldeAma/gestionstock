package com.obi.gestiondesstock.article.web.controller.api;

import com.obi.gestiondesstock.article.application.dto.ArticleRequestDto;
import com.obi.gestiondesstock.article.application.dto.ArticleResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.obi.gestiondesstock.common.config.Constants.ARTICLE;


@RequestMapping(ARTICLE)
public interface ArticleApi {

    @PostMapping
    ResponseEntity<ArticleResponseDto> save(@Valid @RequestBody ArticleRequestDto dto);

    @GetMapping("/{id}")
    ResponseEntity<ArticleResponseDto> findById(@PathVariable Integer id);

    @GetMapping("/search")
    ResponseEntity<ArticleResponseDto> findByCodeArticle(@RequestParam String codeArticle);

    @GetMapping
    ResponseEntity<List<ArticleResponseDto>> findAll();

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Integer id);
}

