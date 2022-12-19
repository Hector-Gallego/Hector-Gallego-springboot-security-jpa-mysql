package dev.hectorgallego.springbootsecurityjpa.repository;

import org.springframework.data.repository.CrudRepository;

import dev.hectorgallego.springbootsecurityjpa.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
    
}
