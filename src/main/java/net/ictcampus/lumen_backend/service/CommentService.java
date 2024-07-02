package net.ictcampus.lumen_backend.service;

import lombok.RequiredArgsConstructor;
import net.ictcampus.lumen_backend.entities.Blog;
import net.ictcampus.lumen_backend.entities.Post;
import net.ictcampus.lumen_backend.repository.CommentRepository;
import net.ictcampus.lumen_backend.entities.Comment;
import net.ictcampus.lumen_backend.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public void update(Integer id, Comment comment) {
        if (!commentRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        if (comment.getId() == null) {
            comment.setId(id);
        } else if (!comment.getId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id in URL does not match " +
                    "ID in body!");
        }
        commentRepository.save(comment);
    }

    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Comment findById(Integer id) {
        Optional<Comment> subject = commentRepository.findById(id);
        return subject.orElseThrow(EntityNotFoundException::new);
    }

    public void create(Comment comment) {
        commentRepository.save(comment);
    }

    public void createCommentByPostId(Integer postId, Comment comment) {
        Post post = postRepository.findById(postId)
                .orElseThrow(EntityNotFoundException::new);
        comment.setPost(post);
        commentRepository.save(comment);
    }

    public void deleteById(Integer id) {
        commentRepository.deleteById(id);
    }
}


