package com.obi.gestiondesstock.fournisseur.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.obi.gestiondesstock.article.application.dto.ArticleRequestDto;
import com.obi.gestiondesstock.commandefournisseur.application.dto.CommandeFournisseurRequestDto;
import com.obi.gestiondesstock.commandefournisseur.application.dto.CommandeFournisseurResponseDto;

import java.math.BigDecimal;
import java.util.List;

public record FournisseurRequestDto(

        String nom,

        String prenom,

        String photo,

        String mail,

        String numTel,

        Integer idEntreprise,

         @JsonIgnore
        List<CommandeFournisseurResponseDto> commandeFournisseurs
) {
}
