package dev.hectorgallego.springbootsecurityjpa.controller;



import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hectorgallego.springbootsecurityjpa.model.Post;
import dev.hectorgallego.springbootsecurityjpa.repository.PostRepository;

@RestController
@RequestMapping("api")
public class PostController {
    

    private final PostRepository postRepository;
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/post")
    @PreAuthorize("hasRole('ROLE_USER')")
     public Iterable<Post> findAll(){
        return postRepository.findAll();
    }


    @GetMapping("post/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
     public Post findById(@PathVariable Long id){
        return postRepository.findById(id).get();
    }



}
