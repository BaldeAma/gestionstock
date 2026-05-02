package com.obi.gestiondesstock.entreprise.infrastructure.repository;

import com.obi.gestiondesstock.entreprise.domain.entity.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {
}
