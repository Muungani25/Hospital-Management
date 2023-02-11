package com.hms.system.hms.persistence;

import com.hms.system.hms.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Override
    List<Patient> findAll();
}
