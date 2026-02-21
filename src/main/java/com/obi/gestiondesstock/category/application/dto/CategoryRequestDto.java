package com.obi.gestiondesstock.category.application.dto;

public record CategoryRequestDto(

        String code,

        String designation,

        Integer idEntreprise
) {
}
