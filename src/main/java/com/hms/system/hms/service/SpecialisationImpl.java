package com.hms.system.hms.service;

import com.hms.system.hms.domain.Doctor;
import com.hms.system.hms.domain.ERole;
import com.hms.system.hms.domain.Role;
import com.hms.system.hms.domain.Specialisation;
import com.hms.system.hms.persistence.DoctorRepository;
import com.hms.system.hms.persistence.SpecialisationRepository;
import com.hms.system.hms.service.dto.AddDoctorRequest;
import com.hms.system.hms.service.dto.CreateSpecialisationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpecialisationImpl implements SpecialisationService {
    private final SpecialisationRepository specialisationRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public String createSpecialisation(CreateSpecialisationRequest request) {
        Optional<Specialisation> specialisationOptional = specialisationRepository.findSpecialisationByName(request.getName().toUpperCase());
        if (specialisationOptional.isPresent()) {
            return "specialisation " + request.getName() + " already exists";
        }

        Specialisation specialisation = Specialisation.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
        specialisationRepository.save(specialisation);

        return "specialization " + specialisation.getName() + " created successfully";
    }

    @Override
    public List<Doctor> getAllDoctorsInASpecialisation(Long id) {

        List<Doctor> doctorListInASpecialisation = doctorRepository.findAllBySpecialisationId(id);

        return doctorListInASpecialisation;
    }

    @Override
    public String addDoctorToSpecialisation(AddDoctorRequest addDoctorRequest) {
        Long doctorId = addDoctorRequest.getDoctorId();
        Optional<Doctor> doctor = doctorRepository.findDoctorById(doctorId);
        Specialisation TargetSpecialisation = specialisationRepository.findAllById(addDoctorRequest.getSpecialisationId());
        Specialisation specialisation = Specialisation.builder()

                .build();
        specialisationRepository.save(specialisation);
        return "Doctor " + doctor.get().getLastName() + "successfully added to specialisation";
    }

    @Override
    public void createSpecialisations() {
        Optional<Specialisation> specialisation = specialisationRepository.findSpecialisationByName("CARDIOLOGIST");
        Boolean isSpecialisationPresent = specialisation.isPresent();
        if (!isSpecialisationPresent) {
            Specialisation specialisation1 = new Specialisation();
            specialisation1.setDescription("treats heart diseases");
            specialisation1.setName("CARDIOLOGIST");
            specialisationRepository.save(specialisation1);
        }
    }
}
