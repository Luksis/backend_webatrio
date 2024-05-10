package com.project.backend.service;

import com.project.backend.dto.PersonneDTO;

import java.util.List;

public interface PersonneService {

    PersonneDTO createPersonne(PersonneDTO personne);

    PersonneDTO getPersonne(Long id);

    PersonneDTO updatePersonne(Long id, PersonneDTO personne);

    void deletePersonne(Long id);

    List<PersonneDTO> getAllPersonnes();
}
