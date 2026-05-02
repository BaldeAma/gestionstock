package com.obi.gestiondesstock.ventes.application.dto;

import com.obi.gestiondesstock.lignevente.application.dto.LigneVenteResponseDto;

import java.time.Instant;
import java.util.List;

public record VentesResponseDto(

        Integer id,

        String code,

        Instant dateVente,

        String commentaire,

        List<LigneVenteResponseDto> ligneVentes,

        Integer idEntreprise
) {
}
