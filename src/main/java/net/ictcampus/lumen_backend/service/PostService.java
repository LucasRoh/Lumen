package net.ictcampus.lumen_backend.service;

import lombok.RequiredArgsConstructor;
import net.ictcampus.lumen_backend.repository.PostRepository;
import net.ictcampus.lumen_backend.entities.Post;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public void update(Integer id, Post post) {
        if (!postRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        if (post.getId() == null) {
            post.setId(id);
        } else if (!post.getId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id in URL does not match " +
                    "ID in body!");
        }
        postRepository.save(post);
    }

    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(Integer id) {
        Optional<Post> subject = postRepository.findById(id);
        return subject.orElseThrow(EntityNotFoundException::new);
    }

    public void create(Post post) {
        postRepository.save(post);
    }

    public void deleteById(Integer id) {
        postRepository.deleteById(id);
    }
    public void setLike(Integer postId, boolean isLike){
        Post post = postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("Post not found"));
        if (isLike) {
            post.setLikes(post.getLikes() + 1);
        } else {
            post.setLikes(post.getLikes() - 1);
        }

        postRepository.save(post);
    }
    public Integer getLikesForUser(Integer UserId){
        return postRepository.findByUserId(UserId);
    }
}
