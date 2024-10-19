package com.example.gestion.foyer.Service.Impl;


import com.example.gestion.foyer.Config.JWTservice;
import com.example.gestion.foyer.Entities.Auth.AuthenticationRequest;
import com.example.gestion.foyer.Entities.Auth.AuthenticationResponse;
import com.example.gestion.foyer.Entities.Auth.RegisterRequest;
import com.example.gestion.foyer.Entities.Role;
import com.example.gestion.foyer.Entities.User;
import com.example.gestion.foyer.Repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthentificationService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JWTservice jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = User.builder()
                .nom(registerRequest.getNom())
                .prenom(registerRequest.getPrenom())
                .email(registerRequest.getEmail())
                .statue("true")
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.Admin)
                .build();
        User userResponse= userRepo.save(user);
        var jwt = jwtService.generateToken(userResponse);
        return AuthenticationResponse.builder().token(jwt).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        var user = userRepo.findByEmail(authenticationRequest.getUsername()).orElse(null);
        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwt).build();
    }
    public AuthenticationResponse authenticateWithuserId(long userId) {
        var user = userRepo.findById((long) userId).orElse(null);
        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwt).build();
    }
//    public AuthenticationResponse forgetPassword(ForgotPasswordRequest forgotPasswordRequest) {
//        Utilisateur user = utilisateurRepository.findByEmail(forgotPasswordRequest.getEmail())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        String newPassword = generateRandomPassword();
//
//        user.setPassword(passwordEncoder.encode(newPassword));
//        utilisateurRepository.save(user);
//
//        emailService.sendPasswordResetEmail(user.getEmail(), newPassword);
//
//        return AuthenticationResponse.builder().message("Password reset successful. Check your email for the new password.").build();
//    }

    private String generateRandomPassword() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

}