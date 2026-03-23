package com.obi.gestiondesstock.lignecommandeclient.domain.entity;

import com.obi.gestiondesstock.article.domain.entity.Article;
import com.obi.gestiondesstock.commandeclient.domain.entity.CommandeClient;
import com.obi.gestiondesstock.common.domain.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Table(name = "lignecommandeclient" )
public class LigneCommandeClient extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "idcommandeclient")
    private CommandeClient commandeClient;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "prixunitaire")
    private BigDecimal prixUnitaire;

    @Column(name = "identreprise")
    private Integer idEntreprise;

}
