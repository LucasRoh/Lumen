package net.ictcampus.lumen_backend.web.rest;

import net.ictcampus.lumen_backend.service.BlogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.ictcampus.lumen_backend.domain.Blog;
import net.ictcampus.lumen_backend.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;


@Tag(name = "Blogs")
@RestController
@RequestMapping("/blogs")
public class BlogController {


    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping(path = "")
    public Iterable<Blog> getAll() {
        try {
            return blogService.findAll();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No blog found!");
        }
    }

    @GetMapping(path = "{id}")
    public Blog get(@PathVariable String id) {
        try {
            return blogService.findById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog not found!");
        }
    }

    @PutMapping(path = "{id}", consumes = "application/json")
    public void update(@PathVariable String id, @Valid @RequestBody Blog blog) {
        try {
            blogService.update(id, blog);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Failed to update blog!");
        }
    }

    @GetMapping(path = "{id}/posts")
    public Iterable<Post> getPosts(@PathVariable String id) {
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
