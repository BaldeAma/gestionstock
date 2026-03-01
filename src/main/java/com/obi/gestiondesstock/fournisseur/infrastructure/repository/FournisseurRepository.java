package com.obi.gestiondesstock.fournisseur.infrastructure.repository;

import com.obi.gestiondesstock.fournisseur.domain.entity.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {
}
