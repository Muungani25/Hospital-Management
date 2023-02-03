package com.hms.system.hms.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {
    private String firstName;
    private String lastName;
    private String gender;
    private String dateOfBirth;
    private String phoneNumber;
    private String address;
    private String email;
    private String password;
}
