package com.obi.gestiondesstock.article.application.service.impl;

import com.obi.gestiondesstock.article.application.dto.ArticleRequestDto;
import com.obi.gestiondesstock.article.application.dto.ArticleResponseDto;
import com.obi.gestiondesstock.article.application.service.ArticleService;
import com.obi.gestiondesstock.article.domain.entity.Article;
import com.obi.gestiondesstock.article.infrastructure.mapper.ArticleMapper;
import com.obi.gestiondesstock.article.infrastructure.repository.ArticleRepository;
import com.obi.gestiondesstock.category.domain.entity.Category;
import com.obi.gestiondesstock.category.infrastructure.repository.CategoryRepository;
import com.obi.gestiondesstock.common.exception.EntityNotFoundException;
import com.obi.gestiondesstock.common.exception.ErrorCodes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;

  /*
  //injection par constructeur @RequiredArgsConstructor, recommander par spring
  @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository){
        this.articleRepository=articleRepository;
    }*/

    @Override
    @Transactional
    public ArticleResponseDto save(ArticleRequestDto dto) {
        //verifier les validations metiers
        //si erreur lever une exception
        /**
         *  List<String> errors = ArticleValidator.validate(dto);
         *     if (!errors.isEmpty()) {
         *       log.error("Article is not valid {}", dto);
         *       throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
         *     }
         */
        //verrifier si le code de l'article n'existe pas avant insertion
        if (articleRepository.existsByCodeArticle(dto.codeArticle())) {
            throw new EntityNotFoundException("Un article avec ce code existe deja", ErrorCodes.ARTICLE_ALREADY_EXISTS);
        }
        //verifier que categoryId existe en BD category.findById
        Category category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(()-> new EntityNotFoundException("Category id "+dto.categoryId()+" non present en BD", ErrorCodes.CATEGORY_NOT_VALID));

        //Mapping, setting de category
        Article article = ArticleMapper.toEntity(dto);
        article.setCategory(category);

        return ArticleMapper.toResponseDto(articleRepository.save(article));
    }

    @Override
    @Transactional(readOnly = true)
    public ArticleResponseDto findById(Integer id) {

        if (id == null) {
            throw new IllegalArgumentException("l' id ne peut pas etre null");
        }

        return articleRepository.findById(id)
                .map(ArticleMapper::toResponseDto)
                .orElseThrow(() -> new EntityNotFoundException("Aucun article avec l'id = " + id + " n'est present dans la BD", ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    @Transactional(readOnly = true)
    public ArticleResponseDto findByCodeArticle(String codeArticle) {
        //verfier que code article n'est pas null --> validation technique bean
        if (codeArticle == null) {
            log.error("le code article est null");
            return null;
        }
        return articleRepository.findArticleByCodeArticle(codeArticle)
                .map(ArticleMapper::toResponseDto)
                .orElseThrow(() -> new EntityNotFoundException("Aucun article avec le code " + codeArticle + " n'est present dans la BD", ErrorCodes.ARTICLE_NOT_FOUND));
    }

    // une liste vide = 200
    // gerer la pagination
    @Override
    @Transactional(readOnly = true)
    public List<ArticleResponseDto> findAll() {
        return articleRepository
                .findAll()
                .stream()
                .map(ArticleMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        if (id == null) {
            log.error("l' id est vide");
            return;
        }
        articleRepository.deleteById(id);
    }

    @Override
    public List<ArticleResponseDto> findAllByCategoryId(Integer idCategory) {

        if (idCategory == null) throw new IllegalArgumentException("l 'id category est vide");

        return articleRepository.findAllByCategoryId(idCategory)
                .stream()
                .map(ArticleMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
