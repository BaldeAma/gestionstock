package com.obi.gestiondesstock.client.web.controller;

import com.obi.gestiondesstock.client.application.dto.ClientRequestDto;
import com.obi.gestiondesstock.client.application.dto.ClientResponseDto;
import com.obi.gestiondesstock.client.application.service.ClientService;
import com.obi.gestiondesstock.client.web.controller.api.ClientApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientController implements ClientApi {

    private final ClientService clientService;

    @Override
    public ResponseEntity<ClientResponseDto> save(ClientRequestDto dto) {
        return ResponseEntity.ok(clientService.save(dto));
    }

    @Override
    public ResponseEntity<ClientResponseDto> findById(Integer id) {
        return ResponseEntity.ok(clientService.findById(id));
    }

    @Override
    public ResponseEntity<List<ClientResponseDto>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @Override
    public void delete(Integer id) {

    }
}
