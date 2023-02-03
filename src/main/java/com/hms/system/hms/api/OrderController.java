package com.hms.system.hms.api;


import com.hms.system.hms.service.RegistrationService;
import com.hms.system.hms.service.dto.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("register")
public class OrderController {

private final RegistrationService registrationService;
    @PostMapping("/user")
    public String registerUser(@RequestBody Patient patient){
       registrationService.registerPatient(patient);
        return "Registered successfully please log in ";
    }



}
