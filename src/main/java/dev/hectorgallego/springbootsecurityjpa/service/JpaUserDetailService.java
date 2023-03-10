package dev.hectorgallego.springbootsecurityjpa.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.hectorgallego.springbootsecurityjpa.model.SecurityUser;
import dev.hectorgallego.springbootsecurityjpa.repository.UserRepository;

@Service
public class JpaUserDetailService implements UserDetailsService{


    private final UserRepository userRepository;
    public JpaUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        return userRepository
            .findByUsername(username)
            .map(SecurityUser::new)// equivalente a (user) -> { return new SecurityUser(user) }
            .orElseThrow(() -> new UsernameNotFoundException(username) );
        
    }
    
}
