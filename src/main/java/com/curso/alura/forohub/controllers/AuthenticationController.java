package com.curso.alura.forohub.controllers;

import com.curso.alura.forohub.dtos.AuthUserDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity authUser(@RequestBody @Valid AuthUserDTO userDTO){
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(
            userDTO.userName(), userDTO.password()
        );

        authenticationManager.authenticate(authenticationToken);

        return ResponseEntity.ok().build();
    }
}
