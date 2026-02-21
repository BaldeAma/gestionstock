package com.obi.gestiondesstock.vente.application.dto;

import com.obi.gestiondesstock.lignevente.application.dto.LigneVenteRequestDto;

import java.time.Instant;
import java.util.List;

public record VentesResponseDto(

        Integer id,

        String code,

        Instant dateVente,

        String commentaire,

        List<LigneVenteRequestDto> ligneVentes,

        Integer idEntreprise
) {
}
