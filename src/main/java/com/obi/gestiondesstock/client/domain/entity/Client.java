package com.obi.gestiondesstock.client.domain.entity;

import com.obi.gestiondesstock.common.domain.AbstractEntity;
import com.obi.gestiondesstock.adresse.domain.entity.Adresse;
import com.obi.gestiondesstock.commandeclient.domain.entity.CommandeClient;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Table(name = "client" )
public class Client extends AbstractEntity {

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

    //un client peut avoir plusieur commande
    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandeClients;
}
