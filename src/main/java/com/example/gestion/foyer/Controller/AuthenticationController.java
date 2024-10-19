package com.example.gestion.foyer.Controller;

import com.example.gestion.foyer.Entities.Auth.AuthenticationRequest;
import com.example.gestion.foyer.Entities.Auth.AuthenticationResponse;
import com.example.gestion.foyer.Entities.Auth.RegisterRequest;
import com.example.gestion.foyer.Service.Impl.AuthentificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/auth")

public class AuthenticationController {
    private final AuthentificationService authentificationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(authentificationService.register(registerRequest));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(authentificationService.authenticate(authenticationRequest));
    }
}
