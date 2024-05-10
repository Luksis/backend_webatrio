package com.project.backend.mapper;


import com.project.backend.dto.EmploiDTO;
import com.project.backend.dto.PersonneDTO;
import com.project.backend.entity.Emploi;
import com.project.backend.entity.Personne;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring",uses = EmploiMapper.class)
public interface PersonneMapper {

    @Mapping(source = "emploi", target = "emploi")
    PersonneDTO toDto(Personne personne);

    @Mapping(source = "emploi", target = "emploi")
    Personne toEntity(PersonneDTO personneDTO);

}
