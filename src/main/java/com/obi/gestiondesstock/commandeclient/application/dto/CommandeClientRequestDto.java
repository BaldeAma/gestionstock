package com.obi.gestiondesstock.commandeclient.application.dto;

import com.obi.gestiondesstock.client.application.dto.ClientRequestDto;
import com.obi.gestiondesstock.common.domain.enums.EtatCommande;
import com.obi.gestiondesstock.lignecommandeclient.application.dto.LigneCommandeClientRequestDto;
import lombok.Builder;

import java.time.Instant;
import java.util.List;

@Builder
public record CommandeClientRequestDto(


        String code,

        Instant dateCommande,

        EtatCommande etatCommande,

        ClientRequestDto client,

        Integer idEntreprise,

        List<LigneCommandeClientRequestDto> ligneCommandeClients
) {
}
