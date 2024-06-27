package net.ictcampus.lumen_backend.web.rest;

import lombok.RequiredArgsConstructor;
import net.ictcampus.lumen_backend.entities.Blog;
import net.ictcampus.lumen_backend.entities.Comment;
import net.ictcampus.lumen_backend.service.PostService;
import net.ictcampus.lumen_backend.entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping(path = "")
    public Iterable<Post> getAll() {
        try {
            return postService.findAll();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No post found!");
        }
    }

    @GetMapping(path = "{id}")
    public Post get(@PathVariable Integer id) {
        try {
            return postService.findById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found!");
        }
    }

    @PutMapping(path = "{id}", consumes = "application/json")
    public void update(@PathVariable Integer id, @Valid @RequestBody Post post) {
        try {
            postService.update(id, post);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Failed to update post!");
        }
    }

    @GetMapping(path = "{id}/comments")
    public Iterable<Comment> getComments(@PathVariable Integer id) {
        try {
            return postService.findById(id).getComments();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found!");
        }
    }

    @PostMapping(path = "", consumes = "application/json")
    public void create(@Valid @RequestBody Post post) {
        try {
            postService.create(post);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Failed to create post!");
        }
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Integer id) {
        try {
            postService.deleteById(id);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Failed to delete post!");
        }
    }
}






