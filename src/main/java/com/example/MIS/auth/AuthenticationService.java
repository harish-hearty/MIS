package com.example.MIS.auth;

import com.example.MIS.config.JwtService;
import com.example.MIS.user.User;
import com.example.MIS.user.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  
  @Transactional
  public boolean register(RegisterRequest request) throws DataAccessException {
	if(repository.findByEmail(request.getEmail()).isEmpty()) {
		var user = User.builder()
		        .username(request.getUsername())
		        .email(request.getEmail())
		        .password(passwordEncoder.encode(request.getPassword()))
		        .role(request.getRole())
		        .build();
		repository.save(user);
		return true;
	}
	else return false; 
  }
  
  @Transactional
  public AuthenticationResponse authenticate(AuthenticationRequest request) throws DataAccessException{
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    var user = repository.findByEmailAndRole(request.getEmail(), request.getRole())
        .orElseThrow();
    Map<String, Object> extraClaims = new HashMap<>();
    extraClaims.put("authority",user.getRole());
    var jwtToken = jwtService.generateToken(extraClaims,user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }
}
