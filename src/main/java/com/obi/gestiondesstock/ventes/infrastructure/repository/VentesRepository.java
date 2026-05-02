package com.obi.gestiondesstock.ventes.infrastructure.repository;

import com.obi.gestiondesstock.ventes.domain.entity.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentesRepository extends JpaRepository<Ventes, Integer> {
}
