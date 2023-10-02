package com.project.El_Buen_Sabor.entities.audit;

import com.project.El_Buen_Sabor.config.CustomRevisionListener;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Revision_Info")
@RevisionEntity(CustomRevisionListener.class)
@Data
public class Revision implements Serializable {

    private static final long seriaVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "revision_seq")
    @SequenceGenerator(
            name = "revison_seq",
            sequenceName = "rbac.seq_revision_id"
    )
    @RevisionNumber
    private int id;

    @Column(name = "Revicion_Date")
    @Temporal(TemporalType.TIMESTAMP)
    @RevisionTimestamp
    private Date date;

}