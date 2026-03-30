package com.obi.gestiondesstock.category.infrastructure.repository;

import com.obi.gestiondesstock.category.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<Category> findCategoryByCode (String code);

    //verifier si le code  fourni exist
    boolean existsByCode(String code);

}
