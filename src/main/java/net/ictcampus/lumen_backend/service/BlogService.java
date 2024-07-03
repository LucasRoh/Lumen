package net.ictcampus.lumen_backend.service;

import javax.persistence.EntityNotFoundException;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.ictcampus.lumen_backend.entities.Blog;
import net.ictcampus.lumen_backend.entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import net.ictcampus.lumen_backend.repository.BlogRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    public void update(Integer id, Blog blog) {
        if (!blogRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        if (blog.getId() == null) {
            blog.setId(id);
        } else if (!blog.getId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id in URL does not match " +
                    "ID in body!");
        }
        blogRepository.save(blog);
    }

    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    public Blog findById(Integer id) {
        Optional<Blog> subject = blogRepository.findById(id);
        return subject.orElseThrow(EntityNotFoundException::new);
    }

    public int count(Integer blogId) {
        Blog blog = findById(blogId);
        return blog.getPosts().size();
    }
    public void create(Blog blog) {
        blogRepository.save(blog);
    }

    // In BlogService.java
    public List<Blog> findByTagTitle(String tagTitle) {
        return blogRepository.findByTag_Title(tagTitle);
    }

    public void deleteById(Integer id) {
        blogRepository.deleteById(id);
    }
}

