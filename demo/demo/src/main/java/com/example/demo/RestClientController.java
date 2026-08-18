package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class RestClientController {

    private final RestClientService restClientService;

    public RestClientController(RestClientService restClientService) {
        this.restClientService = restClientService;
    }

    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable int id) {
        return restClientService.getPost(id);
    }
    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        return restClientService.createPost(post);
    }
    @PutMapping("/posts/{id}")
    public Post updatePost(
            @PathVariable int id,
            @RequestBody Post post) {

        return restClientService.updatePost(id, post);
    }
    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable int id) {
        restClientService.deletePost(id);
    }
}