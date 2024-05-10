package com.project.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Personne {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="personne_SEQ")
    @SequenceGenerator(name="personne_SEQ", sequenceName="personne_SEQ", allocationSize=1)
    private Long id;

    @Column(nullable=false)
    private String nom;

    @Column(nullable=false)
    private String prenom;

    @Column(nullable=false)
    private Date dateDeNaissance;

    @OneToMany(mappedBy = "personne", cascade = CascadeType.ALL)
    private List<Emploi> emploi;
}