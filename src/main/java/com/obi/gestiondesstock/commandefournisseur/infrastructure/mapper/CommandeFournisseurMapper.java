package com.obi.gestiondesstock.commandefournisseur.infrastructure.mapper;

import com.obi.gestiondesstock.commandefournisseur.application.dto.CommandeFournisseurRequestDto;
import com.obi.gestiondesstock.commandefournisseur.application.dto.CommandeFournisseurResponseDto;
import com.obi.gestiondesstock.commandefournisseur.domain.entity.CommandeFournisseur;
import com.obi.gestiondesstock.fournisseur.infrastructure.mapper.FournisseurMapper;
import com.obi.gestiondesstock.lignecommandefournisseur.domain.entity.LigneCommandeFournisseur;

public class CommandeFournisseurMapper {

    //dto --> entity
    public static CommandeFournisseur toEntity (CommandeFournisseurRequestDto dto){

        if(dto == null) return null;

        return CommandeFournisseur.builder()
                .code(dto.code())
                .dateCommande(dto.dateCommande())
                .etatCommande(dto.etatCommande())
                .fournisseur(FournisseurMapper.toEntity(dto.fournisseur()))
                .idEntreprise(dto.idEntreprise())
                .build();
    }

    //entity --> dto
    public static CommandeFournisseurResponseDto toResponseDto(CommandeFournisseur commandeFournisseur){
        if(commandeFournisseur == null) return null;

        return new CommandeFournisseurResponseDto(
                 commandeFournisseur.getId(),
                 commandeFournisseur.getCode(),
                 commandeFournisseur.getDateCommande(),
                 commandeFournisseur.getEtatCommande(),
                 FournisseurMapper.toResponseDto(commandeFournisseur.getFournisseur()),
                 commandeFournisseur.getIdEntreprise(),
                null
         );
    }
}
