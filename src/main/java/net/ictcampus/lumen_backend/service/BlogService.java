package net.ictcampus.lumen_backend.service;

import javax.persistence.EntityNotFoundException;
import net.ictcampus.lumen_backend.domain.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import net.ictcampus.lumen_backend.repository.BlogRepository;
import java.util.Optional;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public void update(String id, Blog blog) {
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

    public Blog findById(String id) {
        Optional<Blog> subject = blogRepository.findById(id);
        return subject.orElseThrow(EntityNotFoundException::new);
    }
}

