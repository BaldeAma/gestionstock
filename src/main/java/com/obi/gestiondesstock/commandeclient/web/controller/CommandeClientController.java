package com.obi.gestiondesstock.commandeclient.web.controller;

import com.obi.gestiondesstock.commandeclient.application.dto.CommandeClientRequestDto;
import com.obi.gestiondesstock.commandeclient.application.dto.CommandeClientResponseDto;
import com.obi.gestiondesstock.commandeclient.application.service.CommandeClientService;
import com.obi.gestiondesstock.commandeclient.web.controller.api.CommandeClientApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommandeClientController implements CommandeClientApi {

    private final CommandeClientService commandeClientService;

    @Override
    public ResponseEntity<CommandeClientResponseDto> save(CommandeClientRequestDto dto) {
        CommandeClientResponseDto saved = commandeClientService.save(dto);
        return ResponseEntity.ok(saved);
    }

    @Override
    public ResponseEntity<List<CommandeClientResponseDto>> findByCode(String code) {
        return ResponseEntity.ok(commandeClientService.findByCode(code));
    }

    @Override
    public ResponseEntity<CommandeClientResponseDto> findById(Integer id) {
        return ResponseEntity.ok(commandeClientService.findById(id));
    }

    @Override
    public ResponseEntity<List<CommandeClientResponseDto>> findAll() {
        return ResponseEntity.ok(commandeClientService.findAll());
    }
}
