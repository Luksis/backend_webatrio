package com.project.backend.service.impl;

import com.project.backend.dto.EmploiDTO;
import com.project.backend.entity.Emploi;
import com.project.backend.entity.Personne;
import com.project.backend.mapper.EmploiMapper;
import com.project.backend.repository.EmploiRepository;
import com.project.backend.repository.PersonneRepository;
import com.project.backend.service.EmploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmploiServiceImpl implements EmploiService {


    private EmploiRepository emploiRepository;
    private EmploiMapper emploiMapper;

    @Override
    public EmploiDTO createEmploi(EmploiDTO emploiDTO) {
        Emploi emploi = this.emploiMapper.toEntity(emploiDTO);
        Emploi savedEmploi =  this.emploiRepository.save(emploi);
        return  this.emploiMapper.toDto(savedEmploi);
    }

    @Override
    public EmploiDTO getEmploi(Long id) {
        Emploi emploi =  this.emploiRepository.findById(id).orElseThrow(() -> new RuntimeException("Emploi not found"));
        return  this.emploiMapper.toDto(emploi);
    }

    @Override
    public EmploiDTO updateEmploi(Long id, EmploiDTO emploiDTO) {
        Emploi existing =  this.emploiRepository.findById(id).orElseThrow(() -> new RuntimeException("Emploi not found"));
        Emploi toUpdate = this.emploiMapper.toEntity(emploiDTO);
        Emploi updated =  this.emploiRepository.save(existing);
        return  this.emploiMapper.toDto(updated);
    }

    @Override
    public void deleteEmploi(Long id) {
        if (! this.emploiRepository.existsById(id)) {
            throw new RuntimeException("Emploi not found");
        }
        this.emploiRepository.deleteById(id);
    }

    @Override
    public List<EmploiDTO> getAllEmplois() {
        return  this.emploiRepository.findAll().stream()
                .map( this.emploiMapper::toDto)
                .collect(Collectors.toList());
    }
}