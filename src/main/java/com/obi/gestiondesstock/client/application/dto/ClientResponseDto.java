package com.obi.gestiondesstock.client.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.obi.gestiondesstock.adresse.application.dto.AdresseDto;
import com.obi.gestiondesstock.commandeclient.application.dto.CommandeClientRequestDto;
import com.obi.gestiondesstock.commandeclient.application.dto.CommandeClientResponseDto;
import lombok.Builder;

import java.util.List;

@Builder
public record ClientResponseDto(

        Integer id,

        String nom,

        String prenom,

        AdresseDto adresse,

        String photo,

        String mail,

        String numTel,

        Integer idEntreprise,

        @JsonIgnore
        List<CommandeClientResponseDto> commandeClients
) {}
