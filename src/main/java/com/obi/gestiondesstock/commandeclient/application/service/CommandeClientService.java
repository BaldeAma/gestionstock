package com.obi.gestiondesstock.commandeclient.application.service;

import com.obi.gestiondesstock.commandeclient.application.dto.CommandeClientRequestDto;
import com.obi.gestiondesstock.commandeclient.application.dto.CommandeClientResponseDto;

import java.util.List;

public interface CommandeClientService {

    //save
    CommandeClientResponseDto save (CommandeClientRequestDto dto);

    //recherche par code
    List<CommandeClientResponseDto> findByCode(String code);

    //rechercher par id findCommandeClientById
    CommandeClientResponseDto findById(Integer id);

    //Affiher tout findAll
    List<CommandeClientResponseDto> findAll();

    //update etat de la commande

}
