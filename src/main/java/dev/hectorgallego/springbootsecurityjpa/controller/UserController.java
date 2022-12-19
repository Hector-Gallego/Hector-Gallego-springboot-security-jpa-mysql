package dev.hectorgallego.springbootsecurityjpa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hectorgallego.springbootsecurityjpa.model.User;
import dev.hectorgallego.springbootsecurityjpa.repository.UserRepository;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api")
public class UserController {
    
    private UserRepository userRepository;
    private PasswordEncoder encoder;
    public UserController(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>)userRepository.findAll();
    }
    

    @PostMapping("/users")
    public User saveUser(@RequestBody User user){

        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);

    }
}
