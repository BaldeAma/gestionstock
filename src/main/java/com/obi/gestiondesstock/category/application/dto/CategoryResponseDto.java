package com.obi.gestiondesstock.category.application.dto;

public record CategoryResponseDto(
        Integer id,

        String code,

        String designation,

        Integer idEntreprise
) {
}
