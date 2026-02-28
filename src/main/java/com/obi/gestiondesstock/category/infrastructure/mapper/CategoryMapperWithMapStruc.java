package com.obi.gestiondesstock.category.infrastructure.mapper;

import com.obi.gestiondesstock.category.application.dto.CategoryRequestDto;
import com.obi.gestiondesstock.category.domain.entity.Category;

public interface CategoryMapperWithMapStruc {

    //convertir une entity en dto
    CategoryRequestDto toDto (Category category);


    //convertir un dto en entity
    Category toEntity (CategoryRequestDto dto);

}
