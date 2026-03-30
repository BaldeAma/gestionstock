package com.obi.gestiondesstock.category.web.controller;

import com.obi.gestiondesstock.category.application.dto.CategoryRequestDto;
import com.obi.gestiondesstock.category.application.dto.CategoryResponseDto;
import com.obi.gestiondesstock.category.application.service.CategoryService;
import com.obi.gestiondesstock.category.web.controller.api.CategoryApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController implements CategoryApi {

    private final CategoryService categoryService;

    @Override
    public ResponseEntity<CategoryResponseDto> save(CategoryRequestDto dto) {
        return ResponseEntity.ok(categoryService.save(dto));
    }

    @Override
    public ResponseEntity<CategoryResponseDto> findByCode(String code) {
        return ResponseEntity.ok(categoryService.findByCode(code));
    }

    @Override
    public ResponseEntity<List<CategoryResponseDto>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @Override
    public ResponseEntity<CategoryResponseDto> findById(Integer id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @Override
    public ResponseEntity<Void> deleteById(Integer idCategory) {
        return null;
    }
}
