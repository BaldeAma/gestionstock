package com.obi.gestiondesstock.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

@Data
@MappedSuperclass
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
    @GeneratedValue
    private Integer id;

    @CreatedDate
    @Column(name = "creationDate", nullable = false, updatable = false)
    private Instant creationDate;

    @LastModifiedDate
    @Column(name = "lastModifiedDate")
    private Instant lastModifiedDate;

}
