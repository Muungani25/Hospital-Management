package com.hms.system.hms.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentResponse {
    private String description;
    private LocalTime appointmentTime;
    private String doctorId;
    private String userId;
    private LocalDate appointmentDate;
}
