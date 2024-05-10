package com.project.backend.mapper;

import com.project.backend.dto.EmploiDTO;
import com.project.backend.entity.Emploi;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel="spring",uses = PersonneMapper.class)
public interface EmploiMapper {

    @Mapping(target = "personne", ignore = true)
    EmploiDTO toDto(Emploi emploi);

    @Mapping(target = "personne", ignore = true)
    Emploi toEntity(EmploiDTO emploiDTO);
}
