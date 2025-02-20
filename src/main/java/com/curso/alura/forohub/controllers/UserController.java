package com.curso.alura.forohub.controllers;

import com.curso.alura.forohub.models.User;
import com.curso.alura.forohub.services.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author Soriano
 */
@RestController
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

}
