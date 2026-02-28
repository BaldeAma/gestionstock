package com.obi.gestiondesstock.lignecommandeclient.infrastructure.mapper;

import com.obi.gestiondesstock.lignecommandeclient.application.dto.LigneCommandeClientRequestDto;
import com.obi.gestiondesstock.lignecommandeclient.application.dto.LigneCommandeClientResponseDto;
import com.obi.gestiondesstock.lignecommandeclient.domain.entity.LigneCommandeClient;

public class LigneCommandeClientMapper {
    //entity --> dto
    public static LigneCommandeClientResponseDto toResponseDto(LigneCommandeClient commandeClient){
        return null;
    }


    //dto --> entity
    public static LigneCommandeClient toEntity(LigneCommandeClientRequestDto dto){
        return null;
    }
}
