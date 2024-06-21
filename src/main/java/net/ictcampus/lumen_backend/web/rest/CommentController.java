package net.ictcampus.lumen_backend.web.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import net.ictcampus.lumen_backend.entities.Blog;
import net.ictcampus.lumen_backend.service.CommentService;
import net.ictcampus.lumen_backend.entities.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;


@Tag(name = "Comments")
@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping(path = "")
    public Iterable<Comment> getAll() {
        try {
            return commentService.findAll();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No comment found!");
        }
    }

    @GetMapping(path = "{id}")
    public Comment get(@PathVariable Integer id) {
        try {
            return commentService.findById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found!");
        }
    }

    @PutMapping(path = "{id}", consumes = "application/json")
    public void update(@PathVariable Integer id, @Valid @RequestBody Comment comment) {
        try {
            commentService.update(id, comment);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Failed to update comment!");
        }
    }

    @PostMapping(path = "", consumes = "application/json")
    public void create(@Valid @RequestBody Comment comment) {
        try {
            commentService.create(comment);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Failed to create comment!");
        }
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Integer id) {
        try {
            commentService.deleteById(id);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Failed to delete comment!");
        }
    }
}
