package com.obi.gestiondesstock.commandeclient.web.controller.api;

import com.obi.gestiondesstock.commandeclient.application.dto.CommandeClientRequestDto;
import com.obi.gestiondesstock.commandeclient.application.dto.CommandeClientResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.obi.gestiondesstock.common.config.Constants.COMMANDE_CLIENT;


@RequestMapping(COMMANDE_CLIENT)
public interface CommandeClientApi {


    @PostMapping
    ResponseEntity<CommandeClientResponseDto> save (@Valid @RequestBody CommandeClientRequestDto dto);

    //recherche par code
    @GetMapping("/search")
    ResponseEntity<List<CommandeClientResponseDto>> findByCode(@RequestParam String code);

    //rechercher par id findCommandeClientById
    @GetMapping("/{id}")
    ResponseEntity<CommandeClientResponseDto> findById(@PathVariable Integer id);

    //Affiher tout findAll
    @GetMapping
    ResponseEntity<List<CommandeClientResponseDto>> findAll();

}
