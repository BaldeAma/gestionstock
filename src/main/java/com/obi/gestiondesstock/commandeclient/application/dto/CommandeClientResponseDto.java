package com.obi.gestiondesstock.commandeclient.application.dto;

import com.obi.gestiondesstock.client.application.dto.ClientResponseDto;
import com.obi.gestiondesstock.common.domain.enums.EtatCommande;
import com.obi.gestiondesstock.lignecommandeclient.application.dto.LigneCommandeClientResponseDto;

import java.time.Instant;
import java.util.List;


public record CommandeClientResponseDto(

        Integer id,

        String code,

        Instant dateCommande,

        EtatCommande etatCommande,

        ClientResponseDto client,

        Integer idEntreprise,

        List<LigneCommandeClientResponseDto> ligneCommandeClients
) {
}
