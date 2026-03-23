package com.obi.gestiondesstock.client.application.service.impl;

import com.obi.gestiondesstock.client.application.dto.ClientRequestDto;
import com.obi.gestiondesstock.client.application.dto.ClientResponseDto;
import com.obi.gestiondesstock.client.application.service.ClientService;
import com.obi.gestiondesstock.client.infrastructure.mapper.ClientMapper;
import com.obi.gestiondesstock.client.infrastructure.repository.ClientRepository;
import com.obi.gestiondesstock.common.exception.EntityNotFoundException;
import com.obi.gestiondesstock.common.exception.ErrorCodes;
import com.obi.gestiondesstock.common.exception.InvalidEntityException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    public static ClientRepository clientRepository;

    @Override
    public ClientResponseDto save(ClientRequestDto dto) {
        if(dto == null){
            throw new InvalidEntityException("Le client n'est pas valide");
        }

        return ClientMapper.toDto(clientRepository.save(ClientMapper.toEntity(dto)));
    }

    @Override
    public ClientResponseDto findById(Integer id) {
        if(id == null){
            throw new IllegalArgumentException("l' id ne peut pas etre null");
        }
        return clientRepository
                .findById(id)
                .map(ClientMapper::toDto)
                .orElseThrow(()-> new EntityNotFoundException("Aucun Client avec l' Id = "+id+" n'est present dans la BD", ErrorCodes.CLIENT_NOT_VALID));
    }

    @Override
    public List<ClientResponseDto> findAll() {
        return clientRepository
                .findAll()
                .stream()
                .map(ClientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        //verifier que le client n'a pas de commande client en cours

    }
}
