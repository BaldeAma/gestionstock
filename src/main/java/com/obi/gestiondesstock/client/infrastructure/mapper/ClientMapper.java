package com.obi.gestiondesstock.client.infrastructure.mapper;

import com.obi.gestiondesstock.adresse.infrastructure.mapper.AdresseMapper;
import com.obi.gestiondesstock.client.application.dto.ClientRequestDto;
import com.obi.gestiondesstock.client.application.dto.ClientResponseDto;
import com.obi.gestiondesstock.client.domain.entity.Client;

public class ClientMapper {

    //entity --> dto
    public static ClientResponseDto toDto(Client client){
        if(client ==null) return null;

        return ClientResponseDto.builder()
                .id(client.getId())
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .adresse(AdresseMapper.toDto(client.getAdresse()))
                .photo(client.getPhoto())
                .mail(client.getMail())
                .numTel(client.getNumTel())
                .idEntreprise(client.getIdEntreprise())
                .build();
    }


    //dto --> entity

    public static Client toEntity(ClientRequestDto dto){

        if(dto == null) return null;

        return Client.builder()
                .nom(dto.nom())
                .prenom(dto.prenom())
                .adresse(AdresseMapper.toEntity(dto.adresse()))
                .photo(dto.photo())
                .mail(dto.mail())
                .numTel(dto.numTel())
                .idEntreprise(dto.idEntreprise())
                .build();
    }


}
