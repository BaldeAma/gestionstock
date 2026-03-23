package com.obi.gestiondesstock.category.application.service.impl;


import com.obi.gestiondesstock.article.domain.entity.Article;
import com.obi.gestiondesstock.article.infrastructure.repository.ArticleRepository;
import com.obi.gestiondesstock.category.application.dto.CategoryRequestDto;
import com.obi.gestiondesstock.category.application.dto.CategoryResponseDto;
import com.obi.gestiondesstock.category.application.service.CategoryService;
import com.obi.gestiondesstock.category.infrastructure.mapper.CategoryMapper;
import com.obi.gestiondesstock.category.infrastructure.repository.CategoryRepository;
import com.obi.gestiondesstock.common.exception.EntityNotFoundException;
import com.obi.gestiondesstock.common.exception.ErrorCodes;
import com.obi.gestiondesstock.common.exception.InvalidOperationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryServiceIpml implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ArticleRepository articleRepository;

    @Override
    public CategoryResponseDto save(CategoryRequestDto dto) {
        if(dto == null){
            throw new IllegalArgumentException("l'objet category ne peut pas être null.");
        }
        //verifier que l'idCategory n'est pas present dans la bd
        if(categoryRepository.existsByCode(dto.code())){
            throw new EntityNotFoundException("Le code existe deja", ErrorCodes.CATEGORY_ALREADY_IN_USE);
        }
        return CategoryMapper.toResponseDto(categoryRepository.save(CategoryMapper.toEntity(dto)));
    }

    @Override
    public CategoryResponseDto findByCode(String code) {
        if(code.isEmpty()){
            throw new IllegalArgumentException(" Le code de la category ne peut pas etre vide.");
        }
        return categoryRepository.findCategoryByCode(code)
                .map(CategoryMapper::toResponseDto)
                .orElseThrow(()->new EntityNotFoundException("Aucune category avec le code "+code+" n'est present dans la BD", ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public List<CategoryResponseDto> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toResponseDto)
                .toList();
    }

    @Override
    public CategoryResponseDto findById(Integer id) {
        if(id==null){
            throw new IllegalArgumentException("L' id ne peut pas etre null");
        }
        return categoryRepository.findById(id)
                .map(CategoryMapper::toResponseDto)
                .orElseThrow(()-> new EntityNotFoundException("La categorie avec l' id "+id+" n'est pas present dans la BD",ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public void deleteById(Integer idCategory) {
        if(idCategory==null){
            throw new IllegalArgumentException("L' id ne peut pas etre null");
        }
        // verifier que la categorie n'est pas utiliser dans un autre articles --> findAllByCategoryId

        List<Article> articles= articleRepository.findAllByCategoryId(idCategory);
        if(!articles.isEmpty()){
            throw new InvalidOperationException("Impossible de supprimer cette categorie qui est utilisée", ErrorCodes.CATEGORY_ALREADY_IN_USE);
        }
        categoryRepository.deleteById(idCategory);
    }
}
