package com.obi.gestiondesstock.adresse.infrastructure.mapper;

import com.obi.gestiondesstock.adresse.application.dto.AdresseDto;
import com.obi.gestiondesstock.adresse.domain.entity.Adresse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdresseMapper {

    public static Adresse toEntity(AdresseDto dto){
        if(dto == null) return null;
        return Adresse.builder()
                .adresse1(dto.adresse1())
                .adresse2(dto.adresse2())
                .codePostale(dto.codePostale())
                .ville(dto.ville())
                .pays(dto.pays())
                .build();
    }

    public static AdresseDto toDto(Adresse adresse){

        if (adresse == null) return null;


        return AdresseDto.builder()
                .adresse1(adresse.getAdresse1())
                .adresse2(adresse.getAdresse2())
                .codePostale(adresse.getCodePostale())
                .ville(adresse.getVille())
                .pays(adresse.getPays())
                .build();
    }
}
