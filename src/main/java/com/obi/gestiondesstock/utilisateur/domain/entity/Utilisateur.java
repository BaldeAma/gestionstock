package com.obi.gestiondesstock.utilisateur.domain.entity;


import com.obi.gestiondesstock.entreprise.domain.entity.Entreprise;
import com.obi.gestiondesstock.common.domain.AbstractEntity;
import com.obi.gestiondesstock.adresse.domain.entity.Adresse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "utilisateur" )
public class Utilisateur extends AbstractEntity {

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "datedenaissance")
    private Instant dateDeNaissance;

    @Column(name = "motdepasse")
    private String moteDePasse;

    @Embedded
    private Adresse adresse;

    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "identreprise")
    private Entreprise entreprise;


    //mappedBy = "utilisateur" --> veut dire que la clé etrangère est dans l'autre entite
    //Forcer EAGER = très mauvaise pratique en prod
   /*
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "utilisateur")
    @JsonIgnore
    private List<Roles> roles;
    */

}
