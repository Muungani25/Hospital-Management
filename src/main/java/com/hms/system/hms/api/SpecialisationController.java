package com.hms.system.hms.api;

import com.hms.system.hms.domain.Doctor;
import com.hms.system.hms.domain.Specialisation;
import com.hms.system.hms.service.SpecialisationService;
import com.hms.system.hms.service.dto.AddDoctorRequest;
import com.hms.system.hms.service.dto.CreateSpecialisationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/specialisation")
public class SpecialisationController {
    private final SpecialisationService specialisationService;

    @PostConstruct
    public void initiateRoles(){

        specialisationService.createSpecialisations();
    }
    @PostMapping("/create")
    public String createSpecialisation(@RequestBody CreateSpecialisationRequest request){
        return specialisationService.createSpecialisation(request);
    }
    @GetMapping("/list")
    public List<Doctor> getAllDoctorsInASpecialisation(@RequestParam Long specialisationId){

        return specialisationService.getAllDoctorsInASpecialisation(specialisationId);
    }

    @PutMapping("/addDoctor")
    public String adddoctor(@RequestBody AddDoctorRequest addDoctorRequest){
        return specialisationService.addDoctorToSpecialisation(addDoctorRequest);
    }
}
