package com.obi.gestiondesstock.commandeclient.infrastructure.repository;

import com.obi.gestiondesstock.commandeclient.domain.entity.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer> {
    //rechercher par code
    List<CommandeClient> findCommandeClientByCode(String code);

    //rechercher par ClientId
    List<CommandeClient> findAllByClientId(Integer idCliend);
}
