package com.obi.gestiondesstock.lignevente.infrastructure.repository;

import com.obi.gestiondesstock.lignevente.domain.entity.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneVenteRepository extends JpaRepository<LigneVente, Integer> {

}
