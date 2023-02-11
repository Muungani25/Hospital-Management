package com.hms.system.hms.service.dto;

import lombok.Data;

@Data
public class SignInRequest {
    private String email;
    private String password;
}
