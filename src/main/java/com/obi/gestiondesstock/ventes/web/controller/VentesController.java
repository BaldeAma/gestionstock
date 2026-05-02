package com.obi.gestiondesstock.ventes.web.controller;

import com.obi.gestiondesstock.ventes.application.dto.VentesRequestDto;
import com.obi.gestiondesstock.ventes.application.dto.VentesResponseDto;
import com.obi.gestiondesstock.ventes.application.service.VentesService;
import com.obi.gestiondesstock.ventes.web.controller.api.VentesApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class VentesController implements VentesApi {

    private final VentesService ventesService;

    @Override
    public ResponseEntity<VentesResponseDto> save(VentesRequestDto dto) {
        //log.info("appel du service save controller");
        return ResponseEntity.ok(ventesService.save(dto));
    }
}
