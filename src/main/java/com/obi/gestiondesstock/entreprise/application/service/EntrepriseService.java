package com.obi.gestiondesstock.entreprise.application.service;

import com.obi.gestiondesstock.entreprise.application.dto.EntrepriseRequestDto;
import com.obi.gestiondesstock.entreprise.application.dto.EntrepriseResponseDto;

import java.util.List;

public interface EntrepriseService {
    EntrepriseResponseDto save(EntrepriseRequestDto dto);
    List<EntrepriseResponseDto> findAll();
}
