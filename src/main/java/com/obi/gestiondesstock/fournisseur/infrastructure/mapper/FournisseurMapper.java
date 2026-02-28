package com.obi.gestiondesstock.fournisseur.infrastructure.mapper;

import com.obi.gestiondesstock.adresse.infrastructure.mapper.AdresseMapper;
import com.obi.gestiondesstock.fournisseur.application.dto.FournisseurRequestDto;
import com.obi.gestiondesstock.fournisseur.application.dto.FournisseurResponseDto;
import com.obi.gestiondesstock.fournisseur.domain.entity.Fournisseur;

public class FournisseurMapper {
    //entity --> dto
    public static FournisseurResponseDto toResponseDto (Fournisseur fournisseur){

        return new  FournisseurResponseDto(
                fournisseur.getId(),
                fournisseur.getNom(),
                fournisseur.getPrenom(),
                fournisseur.getPhoto(),
                fournisseur.getMail(),
                fournisseur.getNumTel(),
                fournisseur.getIdEntreprise(),
                null
        );}

    //dto --> entity
    public static Fournisseur toEntity (FournisseurRequestDto dto)
    {
        return null;
    }
}
