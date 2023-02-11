package com.hms.system.hms.service;

import com.hms.system.hms.domain.Doctor;
import com.hms.system.hms.domain.Patient;
import com.hms.system.hms.domain.Specialisation;
import com.hms.system.hms.domain.User;
import com.hms.system.hms.persistence.*;
import com.hms.system.hms.service.dto.Doctordto;
import com.hms.system.hms.service.dto.DoctorCreationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class AdministratorServiceImpl implements AdministratorService{
    private final RoleRepository roleRepository;
    private final SpecialisationRepository specialisationRepository;
    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Override
    public List<Patient> listOfPatients() {

        return patientRepository.findAll();
    }
    @Override
    public List<Doctor> listOfDoctors() {

        return doctorRepository.findAll();
    }
    @Override
    public ResponseEntity<DoctorCreationResponse> createDoctor(Doctordto doctordto) {

        Specialisation specialisation = specialisationRepository.findByName(doctordto.getSpecialisation());
       Doctor doctor = Doctor.builder()
                .firstName(doctordto.getFirstName())
                .lastName(doctordto.getLastName())
                .gender(doctordto.getGender())
               .dateOfBirth(doctordto.getDateOfBirth())
                .phoneNumber(doctordto.getPhoneNumber())
               .specialisation(specialisation)
                .build();
//        userRepository.save(user);
        doctorRepository.save(doctor);

        return ResponseEntity.ok(DoctorCreationResponse.builder()
                        .message("Doctor by the name "+ doctordto.getFirstName()+" "+ doctordto.getLastName()+" was created successfully")
                .build());
    }
}
