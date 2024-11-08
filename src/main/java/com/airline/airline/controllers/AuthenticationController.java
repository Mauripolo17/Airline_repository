package com.airline.airline.controllers;

import ch.qos.logback.core.net.server.Client;
import com.airline.airline.dto.JwtResponse;
import com.airline.airline.dto.LoginRequest;
import com.airline.airline.dto.SingupRequest;
import com.airline.airline.entities.Cliente;
import com.airline.airline.entities.ERole;
import com.airline.airline.entities.Role;
import com.airline.airline.repositories.ClienteRepository;
import com.airline.airline.repositories.RoleRepository;
import com.airline.airline.security.jwt.JwtUtil;
import com.airline.airline.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/auth/")
public class AuthenticationController {

    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private JwtUtil jwtUtil;
    @Autowired PasswordEncoder passwordEncoder;
    @Autowired ClienteRepository clienteRepository;
    @Autowired RoleRepository roleRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest)  {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(),
                        loginRequest.password())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtUtil.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities()
                .stream().map(role -> role.getAuthority()).collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwtToken,"Bearer", userDetails.getUsername(), roles));
    }
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SingupRequest sRequest){
        Cliente user = new Cliente();
        user.setUsername(sRequest.username());
        user.setPassword(passwordEncoder.encode(sRequest.password()));
        user.setEmail(sRequest.email());
        Set<String> roles = sRequest.roles();
        Cliente newUser = clienteRepository.save(user);
        return ResponseEntity.ok(newUser);
    }

}
