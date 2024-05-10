package com.project.backend.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonneDTO {
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private List<EmploiDTO> emploi;
}

