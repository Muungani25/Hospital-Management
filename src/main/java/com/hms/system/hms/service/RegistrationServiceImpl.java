package com.hms.system.hms.service;


import com.hms.system.hms.domain.User;
import com.hms.system.hms.persistence.UserRepository;
import com.hms.system.hms.service.dto.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService{
   private final UserRepository userRepository;


    @Override
    public String registerPatient(Patient patient) {
        User user = User.builder()
                .address(patient.getAddress())
                .dateOfBirth(patient.getDateOfBirth())
                .email(patient.getEmail())
                .gender(patient.getGender())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .phoneNumber(patient.getPhoneNumber())
                .password(patient.getPassword())
                .userId(Utils.generateRandomId(5))
                .build();
        userRepository.save(user);
        return null;
    }
}

