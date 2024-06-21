package net.ictcampus.lumen_backend.web.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import net.ictcampus.lumen_backend.service.CommentService;
import net.ictcampus.lumen_backend.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;


@Tag(name = "Comments")
@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    public Iterable<Comment> findAll() {
        try {
            return commentService.findAll();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Users not found");
        }
    }

    public void insertComment(@Valid @RequestBody Comment comment) {
        try {
            commentService.insertAbility(comment);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Conflict");
        }
    }

    public void updateAbility(@Valid @RequestBody Comment comment) {
        try {
            commentService.updateAbility(comment);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

    }

    public void deleteById(@RequestParam("id") Integer id) {
        try {
            commentService.deleteById(id);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
