package com.curso.alura.forohub.services;

import com.curso.alura.forohub.models.User;
import com.curso.alura.forohub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author Soriano
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public User getUserById(long idUser) {
        return this.userRepository.findById(idUser).orElse(null);
    }

    public UserDetails getByUserName(String userName){
        return this.userRepository.findByuserName(userName);
    }
}
