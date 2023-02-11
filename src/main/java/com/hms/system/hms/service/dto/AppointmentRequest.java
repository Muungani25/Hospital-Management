package com.hms.system.hms.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequest {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate appointmentDate;
    private String appointmentTime;
    private Long doctorId;
    //private String userId;
}
