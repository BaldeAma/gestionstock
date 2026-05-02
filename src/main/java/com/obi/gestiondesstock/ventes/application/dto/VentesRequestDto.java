package com.obi.gestiondesstock.ventes.application.dto;

import com.obi.gestiondesstock.lignevente.application.dto.LigneVenteRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.List;

public record VentesRequestDto(

        Integer id,

        @NotNull(message = "le code est obligatoire")
        String code,

        //A utiliser pour le update
        Instant dateVente,

        String commentaire,

        @Valid
        List<LigneVenteRequestDto> ligneVentes,

        //à calculer dans le futur
        Integer idEntreprise
) {}