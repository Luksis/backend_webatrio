package com.project.backend.dto;
import com.project.backend.entity.Personne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmploiDTO {
    private String nomEntreprise;
    private String posteOccupe;
    private Date dateDeDebut;
    private Date dateDeFin;
    private Personne personne;
}
