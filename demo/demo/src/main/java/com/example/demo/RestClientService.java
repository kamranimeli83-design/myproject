package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class RestClientService {

    private final RestClient restClient;

    public RestClientService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }

    public Post getPost(int id) {
        return this.restClient
                .get()
                .uri("/posts/" + id)
                .retrieve()
                .body(Post.class);
    }
    public Post createPost(Post post) {
        return this.restClient
                .post()
                .uri("/posts")
                .body(post)
                .retrieve()
                .body(Post.class);
    }
    public Post updatePost(int id, Post post) {
        return this.restClient
                .put()
                .uri("/posts/" + id)
                .body(post)
                .retrieve()
                .body(Post.class);
    }
    public void deletePost(int id) {
        this.restClient
                .delete()
                .uri("/posts/" + id)
                .retrieve()
                .toBodilessEntity();
    }
}