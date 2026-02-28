package com.obi.gestiondesstock.fournisseur.domain.entity;

import com.obi.gestiondesstock.commandefournisseur.domain.entity.CommandeFournisseur;
import com.obi.gestiondesstock.common.domain.AbstractEntity;
import com.obi.gestiondesstock.adresse.domain.entity.Adresse;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Builder
@Table(name = "fournisseur" )
public class Fournisseur extends AbstractEntity {

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Embedded
    private Adresse adresse;

    @Column(name = "photo")
    private String photo;

    @Column(name = "mail")
    private String mail;

    @Column(name = "numTel")
    private String numTel;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur> commandeFournisseurs;

}
