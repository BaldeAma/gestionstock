package com.obi.gestiondesstock.common.domain;

import jakarta.persistence.*;

import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

@Data
@MappedSuperclass
@NoArgsConstructor
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {
    /**
     * @EntityListeners(AuditingEntityListener.class)
     * est utilisé pour gerer l'audit
     * Spring va automatiquement remplir les champs annotés avec avant insertion en base de données:
     * @CreatedDate
     * @LastModifiedDate
     * @CreatedBy
     * @LastModifiedBy
     * Sans que tu écrives de code dans tes services.
     */

    //id tehcnique
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreatedDate
    @Column(name = "creationDate", nullable = false, updatable = false)
    private Instant creationDate;

    @LastModifiedDate
    @Column(name = "lastModifiedDate")
    private Instant lastModifiedDate;

}
