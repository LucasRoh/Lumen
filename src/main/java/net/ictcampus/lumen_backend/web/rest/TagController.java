package net.ictcampus.lumen_backend.web.rest;

import lombok.RequiredArgsConstructor;
import net.ictcampus.lumen_backend.entities.Post;
import net.ictcampus.lumen_backend.entities.Tags;
import net.ictcampus.lumen_backend.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @GetMapping(path = "")
    public Iterable<Tags> getAll() {
        try {
            return tagService.findAll();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No tag found!");
        }
    }

    @GetMapping(path = "{id}")
    public Tags get(@PathVariable Integer id) {
        try {
            return tagService.findById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tag not found!");
        }
    }

    @PostMapping(path = "", consumes = "application/json")
    public void create(@Valid @RequestBody Tags tags) {
        try {
            tagService.create(tags);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Failed to create Tag!");
        }
    }
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Integer id) {
        try {
            tagService.deleteById(id);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Failed to delete Tags!");
        }
    }

}

