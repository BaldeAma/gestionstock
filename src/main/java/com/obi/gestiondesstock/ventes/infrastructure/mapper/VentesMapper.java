package com.obi.gestiondesstock.ventes.infrastructure.mapper;

import com.obi.gestiondesstock.lignevente.infrastructure.mapper.LigneVenteMapper;
import com.obi.gestiondesstock.ventes.application.dto.VentesRequestDto;
import com.obi.gestiondesstock.ventes.application.dto.VentesResponseDto;
import com.obi.gestiondesstock.ventes.domain.entity.Ventes;

import java.util.List;

public class VentesMapper {

    //entity --> response dto
    public static VentesResponseDto toResponseDto(Ventes ventes) {
        if (ventes == null) {
            return null;
        }
        return new VentesResponseDto(
                ventes.getId(),
                ventes.getCode(),
                ventes.getDateVente(),
                ventes.getCommentaire(),
                ventes.getLigneVentes() != null
                        ? ventes.getLigneVentes()
                        .stream().map(LigneVenteMapper::toResponseDto)
                        .toList() : List.of(),
                ventes.getIdEntreprise()

        );
    }

    //dto --> entity
    public static Ventes toEntity(VentesRequestDto dto) {

        if (dto == null) {
            return null;
        }

        return Ventes.builder()
                .id(dto.id())
                .code(dto.code())
                //pour la modification
                .dateVente(dto.dateVente())
                .commentaire(dto.commentaire())
                //A calculer
                .idEntreprise(dto.idEntreprise())
                .build();
    }


}
