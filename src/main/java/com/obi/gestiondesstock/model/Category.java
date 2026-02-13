package com.obi.gestiondesstock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "category" )
public class Category extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "designation")
    private String designation;

    @Column(name = "identreprise")
    private Integer idEntreprise;


   @OneToMany(mappedBy = "category")
    private List<Article> articles;
    /**
     * une categorie possede plusieurs articles donc la clé etrangere doit etre dans Articles (category_id)
     mappedBy indique que la clé étrangère est dans l’autre entité (Article).
     */

}
