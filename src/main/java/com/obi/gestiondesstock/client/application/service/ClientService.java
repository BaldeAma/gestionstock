package com.obi.gestiondesstock.client.application.service;

import com.obi.gestiondesstock.client.application.dto.ClientRequestDto;
import com.obi.gestiondesstock.client.application.dto.ClientResponseDto;
import com.obi.gestiondesstock.client.domain.entity.Client;

import java.util.List;

public interface ClientService {

    //save
    ClientResponseDto save(ClientRequestDto dto);

    //findById
    ClientResponseDto findById(Integer id);

    //findAll
    List<ClientResponseDto> findAll();

    //delete
    void delete(Integer id);

}
