package com.obi.gestiondesstock.category.application.service;

import com.obi.gestiondesstock.category.application.dto.CategoryRequestDto;
import com.obi.gestiondesstock.category.application.dto.CategoryResponseDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    //save
    public CategoryResponseDto save(CategoryRequestDto dto);

    //findByCode
    public CategoryResponseDto findByCode(String code);

    //findByAll
    public List<CategoryResponseDto> findAll();

    //findById
    public CategoryResponseDto findById(Integer id);

    //deleteByID
    public void deleteById(Integer idCategory);

}
