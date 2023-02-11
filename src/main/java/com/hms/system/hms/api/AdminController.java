package com.hms.system.hms.api;


import com.hms.system.hms.domain.Doctor;
import com.hms.system.hms.domain.Patient;
import com.hms.system.hms.domain.User;
import com.hms.system.hms.service.AdministratorService;
import com.hms.system.hms.service.dto.DoctorCreationResponse;
import com.hms.system.hms.service.dto.Doctordto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdministratorService administratorService;

    @PostMapping("/createDoctor")
    public ResponseEntity<DoctorCreationResponse> createDoctor(@RequestBody Doctordto doctor){
      return   administratorService.createDoctor(doctor);
    }
    @GetMapping("/listOfPatients")
    public List<Patient> listOfPatients(){
        return administratorService.listOfPatients();
    }
//
    @GetMapping("/listOfDoctors")
    public List<Doctor> listOfDoctors(){
        return administratorService.listOfDoctors();
    }

}
