package com.hms.system.hms.service;


import com.hms.system.hms.domain.ERole;
import com.hms.system.hms.domain.Patient;
import com.hms.system.hms.domain.Role;
import com.hms.system.hms.domain.User;
import com.hms.system.hms.persistence.PatientRepository;
import com.hms.system.hms.persistence.RoleRepository;
import com.hms.system.hms.persistence.UserRepository;
import com.hms.system.hms.service.dto.PatientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService{
   private final UserRepository userRepository;
private final RoleRepository roleRepository;

private final PatientRepository patientRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public String registerPatient(PatientDto patientDto) {

        String hashedPassword = passwordEncoder.encode(patientDto.getPassword());

        Set<Role> roles = new HashSet<>();
        Patient patient = Patient.builder()
                .phoneNumber(patientDto.getPhoneNumber())
                .lastName(patientDto.getLastName())
                .firstName(patientDto.getFirstName())
                .gender(patientDto.getGender())
                .dateOfBirth(patientDto.getDateOfBirth())
                .address(patientDto.getAddress())
                .build();
        patientRepository.save(patient);
        Optional<Role> userRole = roleRepository.findByName(ERole.PATIENT);
        roles.add(userRole.get());
        User user = User.builder()
                .email(patientDto.getEmail())
                .password(hashedPassword)
                .roles(roles)
                .build();
        userRepository.save(user);

        return null;
    }

    @Override
    public void initiateRoles() {
        Optional<Role> role = roleRepository.findByName(ERole.ADMIN);
        Boolean isRolePresent = role.isPresent();
        if (!isRolePresent) {
            Role doctorRole = new Role();
            doctorRole.setName(ERole.DOCTOR);
            roleRepository.save(doctorRole);

            Role adminRole = new Role();
            adminRole.setName(ERole.ADMIN);
            roleRepository.save(adminRole);



            Role patientRole = new Role();
            patientRole.setName(ERole.PATIENT);
            roleRepository.save(patientRole);


        }
    }
}

