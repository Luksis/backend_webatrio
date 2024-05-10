package com.project.backend.service.impl;

import com.project.backend.dto.PersonneDTO;
import com.project.backend.entity.Personne;
import com.project.backend.mapper.PersonneMapper;
import com.project.backend.repository.PersonneRepository;
import com.project.backend.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonneServiceImpl implements PersonneService {

    @Autowired
    private PersonneRepository personneRepository;

    @Autowired
    private PersonneMapper personneMapper;

    @Override
    public PersonneDTO createPersonne(PersonneDTO personneDTO) {
        Personne personne = this.personneMapper.toEntity(personneDTO);
        Personne savedPersonne = this.personneRepository.save(personne);
        return this.personneMapper.toDto(savedPersonne);
    }

    @Override
    public PersonneDTO getPersonne(Long id) {
        Personne personne = this.personneRepository.findById(id).orElseThrow(() -> new RuntimeException("Personne not found"));
        return this.personneMapper.toDto(personne);
    }

    @Override
    public PersonneDTO updatePersonne(Long id, PersonneDTO personneDTO) {
        Personne existingPersonne = this.personneRepository.findById(id).orElseThrow(() -> new RuntimeException("Personne not found"));
        Personne toUpdate = this.personneMapper.toEntity(personneDTO);
        Personne updated = this.personneRepository.save(toUpdate);
        return this.personneMapper.toDto(updated);
    }

    @Override
    public void deletePersonne(Long id) {
        if (!this.personneRepository.existsById(id)) {
            throw new RuntimeException("Personne not found");
        }
        this.personneRepository.deleteById(id);
    }

    @Override
    public List<PersonneDTO> getAllPersonnes() {
        return this.personneRepository.findAll().stream()
                .map(this.personneMapper::toDto)
                .collect(Collectors.toList());
    }
}