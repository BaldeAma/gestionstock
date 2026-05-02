package com.obi.gestiondesstock.ventes.application.service;

import com.obi.gestiondesstock.ventes.application.dto.VentesRequestDto;
import com.obi.gestiondesstock.ventes.application.dto.VentesResponseDto;

import java.util.List;

public interface VentesService {

    //save
    VentesResponseDto save (VentesRequestDto dto);

    //Recherche par id
    VentesResponseDto findById (Integer id);

    //Afficher
    List<VentesResponseDto> findAll ();

    //find by code
    List<VentesResponseDto> findByCode (String code);

}