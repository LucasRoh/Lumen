package controller.controllers;

import controller.services.PostService;
import models.Blog;
import models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

@Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(path = "")
    public Iterable<Post> getAll() {
        try {
            return postService.findAll();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No post found!");
        }
    }

    @GetMapping(path = "{id}")
    public Post get(@PathVariable String id) {
        try {
            return postService.findById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found!");
        }
    }

    @PutMapping(path = "{id}", consumes = "application/json")
    public void update(@PathVariable String id, @Valid @RequestBody Post post) {
        try {
            postService.update(id, post);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Failed to update post!");
        }
    }


}






