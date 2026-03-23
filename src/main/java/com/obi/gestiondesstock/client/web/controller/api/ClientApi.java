package com.obi.gestiondesstock.client.web.controller.api;

import com.obi.gestiondesstock.client.application.dto.ClientRequestDto;
import com.obi.gestiondesstock.client.application.dto.ClientResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.obi.gestiondesstock.common.config.Constants.CLIENT;


import java.util.List;

@RequestMapping(CLIENT)
public interface ClientApi {

    //save
    @PostMapping
    ResponseEntity<ClientResponseDto> save(@Valid @RequestBody ClientRequestDto dto);

    //findById
    @GetMapping("/{id}")
    ResponseEntity<ClientResponseDto> findById(@PathVariable Integer id);

    //findAll
    @GetMapping
    ResponseEntity<List<ClientResponseDto>> findAll();

    //delete
    @DeleteMapping
    void delete(Integer id);
}
