package com.obi.gestiondesstock.fournisseur.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.obi.gestiondesstock.adresse.application.dto.AdresseDto;
import com.obi.gestiondesstock.commandefournisseur.application.dto.CommandeFournisseurResponseDto;
import com.obi.gestiondesstock.lignecommandefournisseur.application.dto.LigneCommandeFournisseurResponseDto;

import java.util.List;

public record FournisseurResponseDto(

        //adresse non mapper en sortie

        Integer id,

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
