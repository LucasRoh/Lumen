package net.ictcampus.lumen_backend.controller.services;

import net.ictcampus.lumen_backend.controller.repositories.PostRepository;
import net.ictcampus.lumen_backend.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
//Nicht sicher ob int onder string
    public void update(String id, Post post) {
        if (!postRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }

        if (post.getId_post() == null) {
            post.setId_post(id);
        } else if (!post.getId_post().equals(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id in URL does not match " +
                    "ID in body!");
        }

        postRepository.save(post);
    }

    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(String id) {
        Optional<Post> subject = postRepository.findById(id);
        return subject.orElseThrow(EntityNotFoundException::new);
    }
}
