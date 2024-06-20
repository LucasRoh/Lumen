package controller.controllers;

import controller.services.BlogService;
import models.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    @Operation(summary = "Get all blogs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Blogs found", content =
            @Content(mediaType = "application/json", array = @ArraySchema(
                    schema = @Schema(implementation = Blog.class)))),
            @ApiResponse(responseCode = "404", description = "Blog not found", content =
            @Content)})
    public Iterable<Blog> getAll() {
        try {
            return blogService.findAll();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No blog found!");
        }
    }

    @GetMapping(path = "{id}")
    @Operation(summary = "Get a blog by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Canton found", content =
            @Content(mediaType = "application/json", schema =
            @Schema(implementation = Blog.class))),
            @ApiResponse(responseCode = "404", description = "Blog not found", content =
            @Content)})
    public Blog get(@PathVariable String id) {
        try {
            return blogService.findById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog not found!");
        }
    }

    @PutMapping(path = "{id}", consumes = "application/json")
    @Operation(summary = "Update a blog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Blog was updated successfully"),
            @ApiResponse(responseCode = "400", description = "Validation failed"),
            @ApiResponse(responseCode = "403", description = "Access not allowed"),
            @ApiResponse(responseCode = "404", description = "Blog was not found"),
    })
    public void update(@PathVariable String id, @Valid @RequestBody Blog blog) {
        User loggedInUser = userService.findByUsername(loggedInUsername);

        try {
            blogService.update(id, blog);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Failed to update blog!");
        }
    }

    @GetMapping(path = "{id}/posts")
    @Operation(summary = "Get a blog's answers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful", content =
            @Content(mediaType = "application/json", array = @ArraySchema(
                    schema = @Schema(implementation = Post.class)))),
            @ApiResponse(responseCode = "404", description = "Blog was not found")})
    public Iterable<Post> getFeedbacks(@PathVariable String id) {
        try {
            return blogService.findById(id).getPosts();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog not found!");
        }
    }
}
