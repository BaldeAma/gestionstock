package com.obi.gestiondesstock.category.infrastructure.mapper;

import com.obi.gestiondesstock.category.application.dto.CategoryRequestDto;
import com.obi.gestiondesstock.category.application.dto.CategoryResponseDto;
import com.obi.gestiondesstock.category.domain.entity.Category;

public class CategoryMapper {

    public static CategoryResponseDto toResponseDto (Category category){

        if(category == null){
            return null;
        }
        return new CategoryResponseDto(
                category.getId(),
                category.getCode(),
                category.getDesignation(),
                category.getIdEntreprise());
    }

    public static Category toEntity(CategoryRequestDto dto){

        if(dto == null) return null;

        return Category.builder()
                .id(dto.id())
                .idEntreprise(dto.idEntreprise())
                .code(dto.code())
                .designation(dto.designation())
                .build();
    }

}
