package com.project.backend.repository;

import com.project.backend.entity.Emploi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploiRepository extends JpaRepository<Emploi, Long> {
}