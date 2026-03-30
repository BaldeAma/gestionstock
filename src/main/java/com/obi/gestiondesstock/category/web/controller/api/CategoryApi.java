package com.obi.gestiondesstock.category.web.controller.api;

import com.obi.gestiondesstock.category.application.dto.CategoryRequestDto;
import com.obi.gestiondesstock.category.application.dto.CategoryResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.obi.gestiondesstock.common.config.Constants.CATEGORY;
import java.util.List;

@RequestMapping(CATEGORY)
public interface CategoryApi {

    //save
    @PostMapping
     ResponseEntity<CategoryResponseDto> save(@Valid @RequestBody CategoryRequestDto dto);

    //findByCode
    @GetMapping("/search")
     ResponseEntity<CategoryResponseDto> findByCode(@RequestParam String code);

    //findByAll
    @GetMapping
     ResponseEntity<List<CategoryResponseDto>> findAll();

    //findById
    @GetMapping("/{id}")
     ResponseEntity<CategoryResponseDto> findById(@PathVariable Integer id);

    //deleteByID
    @DeleteMapping("/{idCategory}")
    ResponseEntity<Void> deleteById(@PathVariable Integer idCategory);

}
