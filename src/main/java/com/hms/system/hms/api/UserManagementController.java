package com.hms.system.hms.api;


import com.hms.system.hms.service.RegistrationService;
import com.hms.system.hms.service.SignInService;
import com.hms.system.hms.service.dto.PatientDto;
import com.hms.system.hms.service.dto.SignInRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserManagementController {

private final RegistrationService registrationService;
private final SignInService signInService;

    @PostConstruct
    public void initiateRoles(){

        registrationService.initiateRoles();
    }
    @PostMapping("/register")
    public String registerPatient(@RequestBody PatientDto patientDto){
       registrationService.registerPatient(patientDto);
        return "Registered successfully please log in ";
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SignInRequest signInRequest) {
        return signInService.signInUser(signInRequest);
    }



}
