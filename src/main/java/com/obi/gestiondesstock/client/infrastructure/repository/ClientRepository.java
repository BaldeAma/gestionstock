package com.obi.gestiondesstock.client.infrastructure.repository;

import com.obi.gestiondesstock.client.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
