package com.hms.system.hms.service;

import com.hms.system.hms.service.dto.PatientDto;


public interface RegistrationService {
    String registerPatient(PatientDto patientDto);

    void initiateRoles();
}
