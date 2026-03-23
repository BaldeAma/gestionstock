package com.obi.gestiondesstock.commandeclient.infrastructure.mapper;

import com.obi.gestiondesstock.client.infrastructure.mapper.ClientMapper;
import com.obi.gestiondesstock.commandeclient.application.dto.CommandeClientRequestDto;
import com.obi.gestiondesstock.commandeclient.application.dto.CommandeClientResponseDto;
import com.obi.gestiondesstock.commandeclient.domain.entity.CommandeClient;
import com.obi.gestiondesstock.lignecommandeclient.infrastructure.mapper.LigneCommandeClientMapper;
import org.springframework.stereotype.Component;

import java.util.List;

public class CommandeClientMapper {

    //entity --> dto
    public static CommandeClientResponseDto toResponse(CommandeClient commandeClient) {

        if (commandeClient == null) return null;

        return new CommandeClientResponseDto(
                commandeClient.getId(),
                commandeClient.getCode(),
                commandeClient.getDateCommande(),
                commandeClient.getEtatCommande(),
                ClientMapper.toDto(commandeClient.getClient()),
                commandeClient.getIdEntreprise(),
                commandeClient.getLigneCommandeClients() != null
                        ? commandeClient.getLigneCommandeClients()
                        .stream()
                        .map(LigneCommandeClientMapper::toResponseDto)
                        .toList()
                        : List.of()
        );
    }


    //dto --> entity
    public static CommandeClient toEntity(CommandeClientRequestDto dto) {

        if (dto == null) return null;

        return CommandeClient.builder()
                .idEntreprise(dto.idEntreprise())
                .code(dto.code())
                .client(ClientMapper.toEntity(dto.client()))
                .dateCommande(dto.dateCommande())
                .etatCommande(dto.etatCommande())
                .idEntreprise(dto.idEntreprise())
                .build();
    }
}
