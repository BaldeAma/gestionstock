package com.obi.gestiondesstock.commandeclient.application.dto;

import com.obi.gestiondesstock.client.application.dto.ClientRequestDto;
import com.obi.gestiondesstock.common.domain.enums.EtatCommande;
import com.obi.gestiondesstock.lignecommandeclient.application.dto.LigneCommandeClientRequestDto;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.Instant;
import java.util.List;

@Builder
public record CommandeClientRequestDto(

        //@NotNull(message = "L'id est obligatoire")
        Integer id,

        @NotNull(message = "le code ne peut pas etre null")
        String code,

        Instant dateCommande,

        EtatCommande etatCommande,

        ClientRequestDto client,

        Integer idEntreprise,

        List<LigneCommandeClientRequestDto> ligneCommandeClients
) {}
