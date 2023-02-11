package com.hms.system.hms.service;

import com.hms.system.hms.service.dto.JwtResponse;
import com.hms.system.hms.service.dto.SignInRequest;
import org.springframework.http.ResponseEntity;

public interface SignInService {
    ResponseEntity<JwtResponse> signInUser(SignInRequest signInRequest);
}
