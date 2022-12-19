package dev.hectorgallego.springbootsecurityjpa.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    
    @GetMapping("/home")
    public String home(){
        return ("hello world");
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/user")
    public String user(){
        return ("hello user");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String admin(){
        return ("hello admin");
    }
}
