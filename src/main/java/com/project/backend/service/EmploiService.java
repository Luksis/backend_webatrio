package com.project.backend.service;

import com.project.backend.dto.EmploiDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmploiService {

    EmploiDTO createEmploi(EmploiDTO emploi);

    EmploiDTO getEmploi(Long id);

    EmploiDTO updateEmploi(Long id, EmploiDTO emploi);

    void deleteEmploi(Long id);

    List<EmploiDTO> getAllEmplois();
}
