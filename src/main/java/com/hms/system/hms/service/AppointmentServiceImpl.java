package com.hms.system.hms.service;

import com.hms.system.hms.domain.Appointment;
import com.hms.system.hms.domain.Doctor;
import com.hms.system.hms.domain.Status;
import com.hms.system.hms.persistence.AppointmentRepository;
import com.hms.system.hms.persistence.DoctorRepository;
import com.hms.system.hms.service.AppointmentService;
import com.hms.system.hms.service.dto.AppointmentRequest;
import com.hms.system.hms.service.dto.AppointmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    @Override
    public Appointment createAppointment(AppointmentRequest appointmentRequest) {
        LocalTime localTime = LocalTime.parse(appointmentRequest.getAppointmentTime());
        Optional<Doctor> assignedDoctor = Optional.ofNullable(doctorRepository.findDoctorById(appointmentRequest.getDoctorId()).
                orElseThrow(() -> new IllegalArgumentException("Doctor id does not exist")));
        Appointment appointment= Appointment.builder()
                .appointmentDate(appointmentRequest.getAppointmentDate())
                .appointmentTime(localTime)
                .assignedDoctor(assignedDoctor.get())
                .status(Status.PENDING)
//                .patientId(appointmentRequest.getUserId())
                .build();
        appointmentRepository.save(appointment);
        return null;
    }
}
