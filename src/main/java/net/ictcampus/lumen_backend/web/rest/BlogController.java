package net.ictcampus.lumen_backend.web.rest;

import lombok.RequiredArgsConstructor;
import net.ictcampus.lumen_backend.service.BlogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.ictcampus.lumen_backend.entities.Blog;
import net.ictcampus.lumen_backend.entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;


@Tag(name = "Blogs")
@RestController
@RequestMapping("/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping(path = "")
    public Iterable<Blog> getAll() {
        try {
            return blogService.findAll();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No blog found!");
        }
    }

    @GetMapping(path = "{id}")
    public Blog get(@PathVariable Integer id) {
        try {
            return blogService.findById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog not found!");
        }
    }

    @GetMapping(path = "/count/{id}")
    public Integer count(@PathVariable Integer id) {
        try {
            return blogService.count(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog not found!");
        }
    }

    @PutMapping(path = "{id}", consumes = "application/json")
    public void update(@PathVariable Integer id, @Valid @RequestBody Blog blog) {
        try {
            blogService.update(id, blog);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Failed to update blog!");
        }
    }

    @GetMapping(path = "{id}/posts")
    public Iterable<Post> getPosts(@PathVariable Integer id) {
        try {
            return blogService.findById(id).getPosts();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog not found!");
        }
    }


    @PostMapping(path = "", consumes = "application/json")
    public void create(@Valid @RequestBody Blog blog) {
        try {
            blogService.create(blog);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Failed to create blog!");
        }
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Integer id) {
        try {
            blogService.deleteById(id);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Failed to delete blog!");
        }
    }
}
