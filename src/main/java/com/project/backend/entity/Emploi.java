package com.project.backend.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Emploi {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="emploi_SEQ")
    @SequenceGenerator(name="emploi_SEQ", sequenceName="emploi_SEQ", allocationSize=1)
    private Long id;

    @Column(nullable=false)
    private String nomEntreprise;

    @Column(nullable=false)
    private String posteOccupe;

    @Column(nullable=false)
    private Date dateDeDebut;

    @Column(nullable=false)
    private Date dateDeFin;

    @ManyToOne
    @JoinColumn(name = "personne_id")
    private Personne personne;
}