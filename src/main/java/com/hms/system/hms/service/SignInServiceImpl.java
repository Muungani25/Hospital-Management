package com.hms.system.hms.service;

import com.hms.system.hms.service.dto.JwtResponse;
import com.hms.system.hms.service.dto.SignInRequest;
import com.hms.system.hms.util.JwtUtil;
import com.hms.system.hms.util.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class SignInServiceImpl implements  SignInService{
    private final JwtUtil jwtUtil;
    private  final AuthenticationManager authenticationManager;
    @Override
    public ResponseEntity<JwtResponse> signInUser(SignInRequest signInRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        JwtResponse res = new JwtResponse();
        res.setToken(jwt);
        //   res.setRoles(roles);
        return  ResponseEntity.ok(res);
    }
}
