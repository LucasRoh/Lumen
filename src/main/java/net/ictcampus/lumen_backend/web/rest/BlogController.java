package net.ictcampus.lumen_backend.web.rest;

import lombok.RequiredArgsConstructor;
import net.ictcampus.lumen_backend.entities.Tags;
import net.ictcampus.lumen_backend.service.BlogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.ictcampus.lumen_backend.entities.Blog;
import net.ictcampus.lumen_backend.entities.Post;
import net.ictcampus.lumen_backend.service.PostService;
import net.ictcampus.lumen_backend.service.TagService;
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
    private final PostService postService;
    private final TagService tagService;

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

    @PostMapping(path = "/{tagId}", consumes = "application/json")
    public void create(@PathVariable Integer tagId, @Valid @RequestBody Blog blog) {
        try {
            Tags tag = tagService.findById(tagId);
            blog.setTag(tag);
            blogService.create(blog);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tag not found!");
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Failed to create Blog!");
        }
    }

    @PostMapping(path = "/create/{tagTitle}", consumes = "application/json")
    public void createWithTagName(@PathVariable String tagTitle, @Valid @RequestBody Blog blog) {
        String formattedTagTitle = tagTitle.substring(0, 1).toUpperCase() + tagTitle.substring(1).toLowerCase();
        Tags tag = tagService.findByTitle(formattedTagTitle);
        if (tag == null) {
            tag = new Tags();
            tag.setTitle(formattedTagTitle);
            tagService.create(tag);
        }
        blog.setTag(tag);
        blogService.create(blog);
    }

    @PostMapping(path = "", consumes = "application/json")
    public void create(@Valid @RequestBody Blog blog) {
        try {
            blogService.create(blog);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Failed to create blog!");
        }
    }

    @PostMapping(path = "{id}/post", consumes = "application/json")
    public void createPost(@PathVariable Integer id, @Valid @RequestBody Post post) {
        try {
            postService.createPostByBlogId(id, post);
        }catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Failed to create post by BlogId!");
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
