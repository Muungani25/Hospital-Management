package com.hms.system.hms.service;

import com.hms.system.hms.domain.Doctor;
import com.hms.system.hms.domain.Patient;
import com.hms.system.hms.domain.User;
import com.hms.system.hms.service.dto.DoctorCreationResponse;
import com.hms.system.hms.service.dto.Doctordto;
import org.springframework.http.ResponseEntity;

import javax.xml.ws.Response;
import java.util.List;

public interface AdministratorService {

    List<Patient> listOfPatients();
    List<Doctor> listOfDoctors();

    ResponseEntity<DoctorCreationResponse> createDoctor(Doctordto doctor);
}
