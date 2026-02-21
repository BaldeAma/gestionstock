package com.obi.gestiondesstock.commandefournisseur.domain.entity;

import com.obi.gestiondesstock.common.domain.AbstractEntity;
import com.obi.gestiondesstock.common.domain.enums.EtatCommande;
import com.obi.gestiondesstock.fournisseur.domain.entity.Fournisseur;
import com.obi.gestiondesstock.lignecommandefournisseur.domain.entity.LigneCommandeFournisseur;
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
@Table(name = "commandefournisseur" )
public class CommandeFournisseur extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "datecommande")
    private Instant dateCommande;

    @Column(name = "etatcommande")
    @Enumerated(EnumType.STRING)
    private EtatCommande etatCommande;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @ManyToOne
    @JoinColumn(name = "idfournisseur")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "commandeFournisseur")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;


}
