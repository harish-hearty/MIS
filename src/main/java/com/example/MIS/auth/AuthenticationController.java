package com.example.MIS.auth;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/srm/mis/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  @Autowired	
  private final AuthenticationService service;

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
	if(service.register(request))
		return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
	else
		return new ResponseEntity<>("User already registered", HttpStatus.CONFLICT);
  }
  
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
    return ResponseEntity.ok(service.authenticate(request));
  }
  
}
