package dev.hectorgallego.springbootsecurityjpa.repository;

import org.springframework.data.repository.CrudRepository;

import dev.hectorgallego.springbootsecurityjpa.model.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
    
}
