package com.obi.gestiondesstock.lignecommandefournisseur.infrastructure.mapper;

import com.obi.gestiondesstock.article.infrastructure.mapper.ArticleMapper;
import com.obi.gestiondesstock.commandefournisseur.infrastructure.mapper.CommandeFournisseurMapper;
import com.obi.gestiondesstock.lignecommandefournisseur.application.dto.LigneCommandeFournisseurResponseDto;
import com.obi.gestiondesstock.lignecommandefournisseur.domain.entity.LigneCommandeFournisseur;

public class LigneCommandeFournisseurMapper {

    //entity --> dto
    public static LigneCommandeFournisseurResponseDto toDto(LigneCommandeFournisseur ligneCommandeFournisseur){
        if (ligneCommandeFournisseur == null) return null;
        return new LigneCommandeFournisseurResponseDto(
                ligneCommandeFournisseur.getId(),
                ArticleMapper.toResponseDto(ligneCommandeFournisseur.getArticle()),
                CommandeFournisseurMapper.toResponseDto(ligneCommandeFournisseur.getCommandeFournisseur()),
                ligneCommandeFournisseur.getQuantite(),
                ligneCommandeFournisseur.getPrixUnitaire(),
                ligneCommandeFournisseur.getIdEntreprise()
        );
    }

    //dto --> entity
}
