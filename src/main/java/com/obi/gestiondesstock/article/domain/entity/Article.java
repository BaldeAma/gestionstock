package com.obi.gestiondesstock.article.domain.entity;

import com.obi.gestiondesstock.common.domain.AbstractEntity;
import com.obi.gestiondesstock.category.domain.entity.Category;
import com.obi.gestiondesstock.lignecommandeclient.domain.entity.LigneCommandeClient;
import com.obi.gestiondesstock.lignecommandefournisseur.domain.entity.LigneCommandeFournisseur;
import com.obi.gestiondesstock.lignevente.domain.entity.LigneVente;
import com.obi.gestiondesstock.mvtstk.domain.entity.MvtStk;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "article" )
@Builder
public class Article extends AbstractEntity {

    @Column(name = "codearticle")
    private String codeArticle;

    @Column(name = "designation")
    private String designation;

    @Column(name = "prixunitaireht")
    private BigDecimal prixUnitaireHt;

    @Column(name = "tauxtva")
    private BigDecimal tauxTva;

    @Column(name = "prixunitairettc")
    private BigDecimal prixUnitaireTtc;

    @Column(name = "photo")
    private String photo;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @OneToMany(mappedBy = "article")
    private List<LigneVente> ligneVentes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcategory")
    private Category category;
    /**
     * chaque article appartient à une categorie
     * idcategory est une cle etrangere
     */

    @OneToMany(mappedBy = "article")
    private List<LigneCommandeClient> ligneCommandeClients;

    @OneToMany(mappedBy = "article")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;

    @OneToMany(mappedBy = "article")
    private List<MvtStk> mvtStks;

}
