package com.hms.system.hms.service;

import com.hms.system.hms.domain.Appointment;
import com.hms.system.hms.service.dto.AppointmentRequest;
import com.hms.system.hms.service.dto.AppointmentResponse;
import org.springframework.http.ResponseEntity;

public interface AppointmentService {

Appointment createAppointment(AppointmentRequest appointmentRequest);
}
