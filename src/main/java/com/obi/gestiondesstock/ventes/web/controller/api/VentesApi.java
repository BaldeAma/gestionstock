package com.obi.gestiondesstock.ventes.web.controller.api;

import com.obi.gestiondesstock.ventes.application.dto.VentesRequestDto;
import com.obi.gestiondesstock.ventes.application.dto.VentesResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static com.obi.gestiondesstock.common.config.Constants.Ventes;

@RequestMapping(Ventes)
public interface VentesApi {

    //save
    @PostMapping
    ResponseEntity<VentesResponseDto> save(@Valid @RequestBody VentesRequestDto dto);

    //findByID

    //findByCode

    //findAll

    //delete



}
