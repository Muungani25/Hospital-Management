package com.hms.system.hms.service;

import com.hms.system.hms.domain.Doctor;
import com.hms.system.hms.domain.Specialisation;
import com.hms.system.hms.service.dto.AddDoctorRequest;
import com.hms.system.hms.service.dto.CreateSpecialisationRequest;

import java.util.List;

public interface SpecialisationService {
    String createSpecialisation(CreateSpecialisationRequest request);
    List<Doctor> getAllDoctorsInASpecialisation(Long id);
    String addDoctorToSpecialisation(AddDoctorRequest addDoctorRequest);
    void createSpecialisations();
}
