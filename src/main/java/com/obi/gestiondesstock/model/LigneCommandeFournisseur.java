package com.obi.gestiondesstock.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lignecommandefournisseur" )
public class LigneCommandeFournisseur extends AbstractEntity{
}
