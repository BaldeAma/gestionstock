package com.obi.gestiondesstock.commandeclient.infrastructure.repository;

import com.obi.gestiondesstock.commandeclient.domain.entity.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer> {
}
