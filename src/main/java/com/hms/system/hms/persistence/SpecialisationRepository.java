package com.hms.system.hms.persistence;

import com.hms.system.hms.domain.Specialisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpecialisationRepository extends JpaRepository<Specialisation, Long> {
Specialisation findAllById(Long id);
Specialisation findByName(String name);


    Optional<Specialisation> findSpecialisationByName(String name);
}
