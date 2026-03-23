package com.obi.gestiondesstock.lignecommandeclient.infrastructure.repository;

import com.obi.gestiondesstock.lignecommandeclient.domain.entity.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient, Integer> {
    List<LigneCommandeClient> findAllByCommandeClientId(Integer id);
    List<LigneCommandeClient> findAllByArticleId(Integer id);
}
