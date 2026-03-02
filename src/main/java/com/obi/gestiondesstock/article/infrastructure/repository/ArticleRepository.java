package com.obi.gestiondesstock.article.infrastructure.repository;

import com.obi.gestiondesstock.article.domain.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    Optional<Article> findArticleByCodeArticle(String codeArticle);

    List<Article> findAllByCategoryId(Integer idCategory);

    //recherche par codeArticle et Designation tout en ignorant la casse
    List<Article> findByCodeArticleIgnoreCaseAndDesignationIgnoreCase(String codeArticle,String designation);

    //recherche par like
    Optional<Article>findByCodeArticleContainingIgnoreCase (String codeArticle);

    //verfier si codeArticle n'existe pas
    boolean existsByCodeArticle(String codeArticle);

}
