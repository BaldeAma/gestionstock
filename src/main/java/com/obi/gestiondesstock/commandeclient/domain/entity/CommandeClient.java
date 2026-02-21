package com.obi.gestiondesstock.commandeclient.domain.entity;

import com.obi.gestiondesstock.client.domain.entity.Client;
import com.obi.gestiondesstock.common.domain.AbstractEntity;
import com.obi.gestiondesstock.common.domain.enums.EtatCommande;
import com.obi.gestiondesstock.lignecommandeclient.domain.entity.LigneCommandeClient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "commandeclient" )
public class CommandeClient extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "datecommande")
    private Instant dateCommande;

    //EtatCommande est une enumeration
    @Column(name = "etatcommande")
    @Enumerated(EnumType.STRING)
    private EtatCommande etatCommande;


    @Column(name = "identreprise")
    private Integer idEntreprise;

    @ManyToOne
    @JoinColumn(name = "idclient")
    private Client client;

    @OneToMany(mappedBy = "commandeClient")
    private List<LigneCommandeClient> ligneCommandeClients;


}
