package dev.hectorgallego.springbootsecurityjpa.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import dev.hectorgallego.springbootsecurityjpa.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
 
    Optional<User> findByUsername(String username);
}
