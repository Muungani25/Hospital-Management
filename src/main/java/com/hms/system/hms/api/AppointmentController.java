package com.hms.system.hms.api;

import com.hms.system.hms.domain.Appointment;
import com.hms.system.hms.service.AppointmentService;
import com.hms.system.hms.service.dto.AppointmentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;
    @PostMapping("/create")
    public Appointment createAppointment(@RequestBody AppointmentRequest appointmentRequest){

        return appointmentService.createAppointment(appointmentRequest);
    }
}
