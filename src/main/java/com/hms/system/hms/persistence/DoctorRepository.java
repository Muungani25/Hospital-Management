package com.hms.system.hms.persistence;

import com.hms.system.hms.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Optional<Doctor> findDoctorById(Long id);
List<Doctor> findAll();

    List<Doctor> findAllBySpecialisationId(Long id);
}
