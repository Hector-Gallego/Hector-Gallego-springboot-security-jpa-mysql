package dev.hectorgallego.springbootsecurityjpa.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUser implements UserDetails {

    private User user;
    
    public SecurityUser(User user) {
        this.user = user;
    }


    @Override
    public String getUsername() {
        return user.getUsername();
    }
    @Override
    public String getPassword() {
        return user.getPassword();
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    
        // muy posible proballe un error aqui
        return user.getRoles()
            .stream()
            .map((user) -> new SimpleGrantedAuthority(user.getRole()))
            .toList();
        }

    
}
